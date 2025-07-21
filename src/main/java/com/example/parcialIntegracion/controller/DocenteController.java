
package com.example.parcialIntegracion.controller;

import com.example.parcialIntegracion.model.Docente;
import com.example.parcialIntegracion.service.IDocenteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author jeand
 */
@RestController
@RequestMapping("/docentes")
public class DocenteController {

    @Autowired
    private IDocenteService doceServ;

    @GetMapping("/traer")
    public List<Docente> getDocentes() {
        return doceServ.getDocentes();
    }

    @PostMapping("/crear")
    public String saveDocente(@RequestBody Docente docente) {
        doceServ.saveDocente(docente);
        return "El docente fue creado correctamente";
    }

    @DeleteMapping("/borrar/{id}")
    public String deleteDocente(@PathVariable Long id) {
        doceServ.deleteDocente(id);
                return "El docente fue eliminado correctamente";
            }

    @PutMapping("/editar/{id_original}")
    public Docente editDocente(
            @PathVariable Long id_original,
            @RequestParam(required = false) String apellidos,
            @RequestParam(required = false) String nombres,
            @RequestParam(required = false) String profesion,
            @RequestParam(required = false) String fechaNacimiento,
            @RequestParam(required = false) String correo
    ) {
        doceServ.editDocente(id_original, apellidos, nombres, profesion, fechaNacimiento, correo);
        return doceServ.findDocente(id_original);
    }

    // ✅ Editar docente usando JSON completo (recomendado para integración con frontend moderno)
    @PutMapping("/editar")
    public Docente editDocenteBody(@RequestBody Docente docente) {
        doceServ.editDocente(docente);
        return doceServ.findDocente(docente.getId());
    }
}

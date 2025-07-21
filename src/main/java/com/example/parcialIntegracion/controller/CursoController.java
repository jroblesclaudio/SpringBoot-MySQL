
package com.example.parcialIntegracion.controller;

import com.example.parcialIntegracion.model.Curso;
import com.example.parcialIntegracion.service.ICursoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author jeand
 */
@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private ICursoService cursServ;

    @GetMapping("/traer")
    public List<Curso> getCursos() {
        return cursServ.getCursos();
    }

    @PostMapping("/crear")
    public String saveCurso(@RequestBody Curso curso) {
        cursServ.saveCurso(curso);
        return "El curso fue creado correctamente";
    }

    @DeleteMapping("/borrar/{id}")
    public String deleteCurso(@PathVariable Long id) {
        cursServ.deleteCurso(id);
        return "El curso fue eliminado correctamente";
    }

    @PutMapping("/editar/{id_original}")
    public Curso editCurso(
            @PathVariable Long id_original,
            @RequestParam(required = false) String nombreCurso,
            @RequestParam(required = false) Integer creditos,
            @RequestParam(required = false) Integer horasSemanal,
            @RequestParam(required = false) String ciclo
    ) {
        cursServ.editCurso(id_original, nombreCurso, creditos, horasSemanal, ciclo);
        return cursServ.findCurso(id_original);
    }

    @PutMapping("/editar")
    public Curso editCursoBody(@RequestBody Curso curso) {
        cursServ.editCurso(curso);
        return cursServ.findCurso(curso.getId());
    }
}

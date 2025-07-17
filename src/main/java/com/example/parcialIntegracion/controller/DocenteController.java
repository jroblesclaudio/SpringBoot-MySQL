
package com.example.parcialIntegracion.controller;

import com.example.parcialIntegracion.model.Docente;
import com.example.parcialIntegracion.service.IDocenteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jeand
 */
@RestController
public class DocenteController {
    
    @Autowired
    private IDocenteService doceServ;
    
     @GetMapping ("/docentes/traer")
    public List<Docente> getDocentes(){
        return doceServ.getDocentes();
    }
    
    @PostMapping ("/docentes/crear")
    public String saveDocente(@RequestBody Docente doce){
        doceServ.saveDocente(doce);
        return "El docente fue creado correctamente";
    }
    
    @DeleteMapping ("/docentes/borrar/{id}")
    public String deleteDocente(@PathVariable Long id){
        doceServ.deleteDocente(id);
        return "El docente fue eliminado correctamente";
    }
    
    @PutMapping ("/docentes/editar/{id_original}")
    public Docente editDocente(@PathVariable Long id_original,
                                @RequestParam(required = false, name = "id_docente") Long nuevaId,
                                @RequestParam(required = false, name = "apellidos") String nuevoApellidos,
                                @RequestParam(required = false, name = "nombres") String nuevoNombres,
                                @RequestParam(required = false, name = "profesion") String nuevaProfesion,
                                @RequestParam(required = false, name = "fechaNacimiento") String nuevaFechaNacimiento,
                                @RequestParam(required = false, name = "correo") String nuevoCorreo){
        
        doceServ.editDocente(id_original, nuevaId, nuevoApellidos, nuevoNombres, nuevaProfesion, nuevaFechaNacimiento, nuevoCorreo);
        Docente doce = doceServ.findDocente(nuevaId);
        return doce;
    }
}

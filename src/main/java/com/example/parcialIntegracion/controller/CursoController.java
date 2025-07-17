
package com.example.parcialIntegracion.controller;

import com.example.parcialIntegracion.model.Curso;
import com.example.parcialIntegracion.service.ICursoService;
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
public class CursoController {
    
    @Autowired
    private ICursoService cursServ;
    
     @GetMapping ("/cursos/traer")
    public List<Curso> getCursos(){
        return cursServ.getCursos();
    }
    
    @PostMapping ("/cursos/crear")
    public String saveCurso(@RequestBody Curso curs){
        cursServ.saveCurso(curs);
        return "El curso fue creado correctamente";
    }
    
    @DeleteMapping ("/cursos/borrar/{id}")
    public String deleteCurso(@PathVariable Long id){
        cursServ.deleteCurso(id);
        return "El curso fue eliminado correctamente";
    }
    
    @PutMapping ("/cursos/editar/{id_original}")
    public Curso editCurso(@PathVariable Long id_original,
                                @RequestParam(required = false, name = "id") Long nuevaId,
                                @RequestParam(required = false, name = "nombreCurso") String nuevoNombreCurso,
                                @RequestParam(required = false, name = "creditos") int nuevoCredito,
                                @RequestParam(required = false, name = "horasSemanal") int nuevaHorasSemanal,
                                @RequestParam(required = false, name = "ciclo") String nuevoCiclo){
        
        cursServ.editCurso(id_original, nuevaId, nuevoNombreCurso, nuevoCredito, nuevaHorasSemanal, nuevoCiclo);
        Curso curs = cursServ.findCurso(nuevaId);
        return curs;
    }
    
    @PutMapping("/cursos/editar")
    public Curso editCurso(@RequestBody Curso curs){
        cursServ.editCurso(curs);
        
        return cursServ.findCurso(curs.getId());
    }
    
}


package com.example.parcialIntegracion.service;

import com.example.parcialIntegracion.model.Curso;
import com.example.parcialIntegracion.repository.ICursoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jeand
 */
@Service
public class CursoService implements ICursoService{
    
    @Autowired
    private ICursoRepository cursRepo;

    @Override
    public List<Curso> getCursos() {
        List<Curso> listaCursos = cursRepo.findAll();
        return listaCursos;
    }

    @Override
    public void saveCurso(Curso curs) {
        cursRepo.save(curs);
    }

    @Override
    public void deleteCurso(Long id) {
        cursRepo.deleteById(id);
    }

    @Override
    public Curso findCurso(Long id) {
        Curso curs = cursRepo.findById(id).orElse(null);
        return curs;
    }

    @Override
    public void editCurso(Long idOriginal, 
                          Long idNueva, 
                          String nuevoNombreCurso, 
                          int nuevoCredito, 
                          int nuevaHorasSemanal, 
                          String nuevoCiclo) {
        //busco al objeto original
        Curso curs = this.findCurso(idOriginal);
        
        curs.setId(idNueva);
        curs.setNombreCurso(nuevoNombreCurso);
        curs.setCreditos(nuevoCredito);
        curs.setHorasSemanal(nuevaHorasSemanal);
        curs.setCiclo(nuevoCiclo);
        
        //guardar los cambios
        this.saveCurso(curs);
    }

    @Override
    public void editCurso(Curso curs) {
        this.saveCurso(curs);
    }
    
  
}

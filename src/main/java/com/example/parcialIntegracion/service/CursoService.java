
package com.example.parcialIntegracion.service;

import com.example.parcialIntegracion.model.Curso;
import com.example.parcialIntegracion.model.Docente;
import com.example.parcialIntegracion.repository.ICursoRepository;
import java.util.List;

import com.example.parcialIntegracion.repository.IDocenteRepository;
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

    @Autowired
    private IDocenteRepository docenteRepo;

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
                          String nuevoNombreCurso,
                          Integer nuevoCredito,
                          Integer nuevaHorasSemanal,
                          String nuevoCiclo) {

        Curso curs = this.findCurso(idOriginal);
        if (curs == null) {
            throw new RuntimeException("Curso con ID " + idOriginal + " no encontrado");
        }

        if (nuevoNombreCurso != null) curs.setNombreCurso(nuevoNombreCurso);
        if (nuevoCredito != null) curs.setCreditos(nuevoCredito);
        if (nuevaHorasSemanal != null) curs.setHorasSemanal(nuevaHorasSemanal);
        if (nuevoCiclo != null) curs.setCiclo(nuevoCiclo);

        this.saveCurso(curs);
    }

    @Override
    public void editCurso(Curso cursoActualizado) {
        Curso cursoExistente = this.findCurso(cursoActualizado.getId());

        if (cursoExistente == null) {
            throw new RuntimeException("Curso con ID " + cursoActualizado.getId() + " no existe.");
        }

        cursoExistente.setNombreCurso(cursoActualizado.getNombreCurso());
        cursoExistente.setCreditos(cursoActualizado.getCreditos());
        cursoExistente.setHorasSemanal(cursoActualizado.getHorasSemanal());
        cursoExistente.setCiclo(cursoActualizado.getCiclo());

        if (cursoActualizado.getUnDocente() != null && cursoActualizado.getUnDocente().getId() != null) {
            Docente docentePersistido = docenteRepo.findById(cursoActualizado.getUnDocente().getId())
                    .orElseThrow(() -> new RuntimeException("Docente con ID " + cursoActualizado.getUnDocente().getId() + " no existe."));
            cursoExistente.setUnDocente(docentePersistido);
        }

        this.saveCurso(cursoExistente);
    }
  
}

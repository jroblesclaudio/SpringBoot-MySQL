
package com.example.parcialIntegracion.service;

import com.example.parcialIntegracion.model.Docente;
import com.example.parcialIntegracion.repository.IDocenteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jeand
 */
@Service
public class DocenteService implements IDocenteService{

    @Autowired
    private IDocenteRepository doceRepo;

    @Override
    public List<Docente> getDocentes() {
        List<Docente> listaDocentes = doceRepo.findAll();
        return listaDocentes;
    }

    @Override
    public void saveDocente(Docente doce) {
        doceRepo.save(doce);
    }

    @Override
    public void deleteDocente(Long id_docente) {
        doceRepo.deleteById(id_docente);
    }

    @Override
    public Docente findDocente(Long id_docente) {
        Docente doce = doceRepo.findById(id_docente).orElse(null);
        return doce;
    }

    @Override
    public void editDocente(Long idOriginal,
                            String nuevoApellidos,
                            String nuevoNombres,
                            String nuevaProfesion,
                            String nuevaFechaNacimiento,
                            String nuevoCorreo) {

        Docente doce = this.findDocente(idOriginal);
        if (doce == null) {
            throw new RuntimeException("Docente con ID " + idOriginal + " no encontrado");
        }

        if (nuevoApellidos != null) doce.setApellidos(nuevoApellidos);
        if (nuevoNombres != null) doce.setNombres(nuevoNombres);
        if (nuevaProfesion != null) doce.setProfesion(nuevaProfesion);
        if (nuevaFechaNacimiento != null) doce.setFechaNacimiento(nuevaFechaNacimiento);
        if (nuevoCorreo != null) doce.setCorreo(nuevoCorreo);

        this.saveDocente(doce);
    }


    @Override
    public void editDocente(Docente docente) {
        // asegurarse de que exista
        Docente existente = this.findDocente(docente.getId());
        if (existente != null) {
            existente.setApellidos(docente.getApellidos());
            existente.setNombres(docente.getNombres());
            existente.setProfesion(docente.getProfesion());
            existente.setFechaNacimiento(docente.getFechaNacimiento());
            existente.setCorreo(docente.getCorreo());
            this.saveDocente(existente);
        }
    }
}

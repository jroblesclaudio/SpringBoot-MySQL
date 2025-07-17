
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
                            Long id_nuevoDocente, 
                            String nuevoApellidos, 
                            String nuevoNombres, 
                            String nuevaProfesion, 
                            String nuevaFechaNacimiento, 
                            String nuevoCorreo) {
        
        Docente doce = this.findDocente(idOriginal);
        
        doce.setId_docente(id_nuevoDocente);
        doce.setApellidos(nuevoApellidos);
        doce.setNombres(nuevoNombres);
        doce.setProfesion(nuevaProfesion);
        doce.setFechaNacimiento(nuevaFechaNacimiento);
        doce.setCorreo(nuevoCorreo);
        
        this.saveDocente(doce);
        
    }

    
}

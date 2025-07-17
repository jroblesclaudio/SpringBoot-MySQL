
package com.example.parcialIntegracion.service;

import com.example.parcialIntegracion.model.Curso;
import com.example.parcialIntegracion.model.Docente;
import java.util.List;

/**
 *
 * @author jeand
 */
public interface IDocenteService {
    
    //metodo para traer a todas las personas
    public List<Docente> getDocentes();
    
    
    //alta
    public void saveDocente(Docente doce);
    
    //baja
    public void deleteDocente(Long id_docente);
    
    //lectura de un solo objeto
    public Docente findDocente(Long id_docente);
    
    //edicion/ modificacion
    public void editDocente(Long idOriginal, 
                            Long id_nuevoDocente, 
                            String nuevoApellidos, 
                            String nuevoNombres, 
                            String nuevaProfesion,
                            String nuevaFechaNacimiento,
                            String nuevoCorreo);
    
}

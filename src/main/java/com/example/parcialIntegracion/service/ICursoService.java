
package com.example.parcialIntegracion.service;

import com.example.parcialIntegracion.model.Curso;
import java.util.List;

/**
 *
 * @author jeand
 */
public interface ICursoService {
    
    //metodo para traer a todas las personas
    public List<Curso> getCursos();
    
    
    //alta
    public void saveCurso(Curso curs);
    
    //baja
    public void deleteCurso(Long id);
    
    //lectura de un solo objeto
    public Curso findCurso(Long id);
    
    //edicion/ modificacion
    public void editCurso(Long idOriginal, 
                            Long idNueva, 
                            String nuevoNombreCurso, 
                            int nuevoCredito, 
                            int nuevaHorasSemanal,
                            String nuevoCiclo);
    
    //otra forma de edicion/modificacion
    public void editCurso(Curso curs);

}

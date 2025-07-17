
package com.example.parcialIntegracion.repository;

import com.example.parcialIntegracion.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jeand
 */
@Repository
public interface ICursoRepository extends JpaRepository<Curso, Long>{
    
}

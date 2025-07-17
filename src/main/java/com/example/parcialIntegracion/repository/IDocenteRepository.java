
package com.example.parcialIntegracion.repository;

import com.example.parcialIntegracion.model.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jeand
 */
@Repository
public interface IDocenteRepository extends JpaRepository<Docente, Long>{
    
}

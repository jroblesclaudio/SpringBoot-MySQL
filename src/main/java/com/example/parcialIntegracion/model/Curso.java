
package com.example.parcialIntegracion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author jeand
 */
@Getter @Setter
@Entity
public class Curso {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombreCurso;
    private int creditos;
    private int horasSemanal;
    private String ciclo;
    
    //relacion uno a uno
    @OneToOne
    @JoinColumn (name = "un_docente_id_docente", referencedColumnName = "id_docente")
    private Docente unDocente;

    public Curso() {
    }

    public Curso(Long id, String nombreCurso, int creditos, int horasSemanal, String ciclo, Docente unDocente) {
        this.id = id;
        this.nombreCurso = nombreCurso;
        this.creditos = creditos;
        this.horasSemanal = horasSemanal;
        this.ciclo = ciclo;
        this.unDocente = unDocente;
    }
    
}

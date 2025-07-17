
package com.example.parcialIntegracion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author jeand
 */
@Getter @Setter
@Entity
public class Docente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_docente;
    private String apellidos;
    private String nombres;
    private String profesion;
    private String fechaNacimiento;
    private String  correo;

    public Docente() {
    }

    public Docente(Long id_docente, String apellidos, String nombres, String profesion, String fechaNacimiento, String correo) {
        this.id_docente = id_docente;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.profesion = profesion;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
    }
    
    
}

package org.example.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

//para mapear entity con mi base de datos
@Entity(name="empleados")
public class Empleado {

    //Crear columnas
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellidos;
    @Column(nullable = false)
    private String cargo;
    @Column(nullable = false)
    private Double salario;
    @Column(nullable = false)
    private LocalDateTime fecha_inicio;

}

package org.example.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

//para mapear entity con mi base de datos
@Entity(name="empleados")
public class Empleado {

    //Crear columnas
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //nullable = false para que el atributo no sea null
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

    //constructores
    public Empleado() {
    }

    public Empleado(Integer id, String nombre, String apellidos, String cargo, Double salario, LocalDateTime fecha_inicio) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cargo = cargo;
        this.salario = salario;
        this.fecha_inicio = fecha_inicio;
    }

    //Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public LocalDateTime getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDateTime fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }


    //toString
    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", cargo='" + cargo + '\'' +
                ", salario=" + salario +
                ", fecha_inicio=" + fecha_inicio +
                '}';
    }
}

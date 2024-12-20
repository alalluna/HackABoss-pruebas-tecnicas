package org.example.controllers;

import org.example.entities.Empleado;
import org.example.persistence.EmpleadoJPA;

public class EmpleadoController {

    EmpleadoJPA empleadoJPA = new EmpleadoJPA();

    public void create(Empleado nuevoEmpleado){
        empleadoJPA.create(nuevoEmpleado);
    }
}

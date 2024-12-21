package org.example.controllers;

import org.example.entities.Empleado;
import org.example.persistence.EmpleadoJPA;

public class EmpleadoController {

    EmpleadoJPA empleadoJPA = new EmpleadoJPA();

    public void create(Empleado nuevoEmpleado){
        empleadoJPA.create(nuevoEmpleado);
    }

    public Empleado find(Integer idSearch){
        return empleadoJPA.find(idSearch);
    }

    public void delete(Integer idDelete){
        empleadoJPA.delete(idDelete);
    }
}

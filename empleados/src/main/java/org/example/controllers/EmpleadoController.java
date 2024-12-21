package org.example.controllers;

import org.example.entities.Empleado;
import org.example.persistence.EmpleadoJPA;

import java.util.List;

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

    public List<Empleado> read(){
        return empleadoJPA.read();
    }

    public void update(Empleado editarEmpleado){
        empleadoJPA.update(editarEmpleado);
    }

    public List<Empleado> searchByCargo (String cargo){
        return empleadoJPA.searchByCargo(cargo);
    }

}

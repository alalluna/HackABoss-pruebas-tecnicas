package org.example.controllers;

import org.example.entities.Empleado;
import org.example.persistence.EmpleadoJPA;

import java.util.List;

public class EmpleadoController {

    EmpleadoJPA empleadoJPA = new EmpleadoJPA();

    public void createEmployee(Empleado nuevoEmpleado){
        empleadoJPA.createEmployee(nuevoEmpleado);
    }

    public Empleado findById(Integer idSearch){
        return empleadoJPA.findById(idSearch);
    }

    public void deleteEmployee(Integer idDelete){
        empleadoJPA.deleteEmployee(idDelete);
    }

    public List<Empleado> readEmployees(){
        return empleadoJPA.readEmployees();
    }

    public void updateEmployee(Empleado editarEmpleado){
        empleadoJPA.updateEmployee(editarEmpleado);
    }

    public List<Empleado> searchByPosition(String cargo){
        return empleadoJPA.searchByPosition(cargo);
    }

}

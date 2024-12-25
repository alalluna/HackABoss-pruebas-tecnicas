package org.example;

import org.example.controllers.EmpleadoController;
import org.example.entities.Empleado;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmpleadoController empleadoController = new EmpleadoController();
        //Crear nuevo empleado
//        Empleado nuevoEmpleado4 = new Empleado(null, "Lucia", "Puig Soler", "camarero/a",
//                1200.00, LocalDateTime.of(2020, 2, 1, 0, 0, 0));
//        empleadoController.createEmployee(nuevoEmpleado4);



        //buscar por id
//        Integer idSearch = 1;
//        Empleado empleado = empleadoController.findById(idSearch);
//        System.out.println(empleado);

       // eliminar registro por id
//       Integer idDelete = 23;
//       empleadoController.deleteEmployee(idDelete);

        //leer lista
//        List<Empleado> listaEmpleados = empleadoController.readEmployees();
//        for(Empleado empleados: listaEmpleados){
//         System.out.println(empleados);
//        }
        //Editar empleado
       Empleado editarEmpleado = empleadoController.findById(21);
       editarEmpleado.setApellidos("Bonet Ten");
       editarEmpleado.setNombre("Victor");
       empleadoController.updateEmployee(editarEmpleado);

        //buscar por cargo
//        String cargo = "camarero/a";
//        List<Empleado> listaPorCargo = empleadoController.searchByPosition(cargo);
//        for(Empleado porCargos: listaPorCargo){
//            System.out.println(porCargos);
//        }
    }
}

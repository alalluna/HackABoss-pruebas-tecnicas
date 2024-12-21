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
//        Empleado nuevoEmpleado4 = new Empleado(null,"Jose","Garcia Lopez","camarero/a",
//                1200.00, LocalDateTime.of(2023,2,1,0,0,0));
//
//        empleadoController.create(nuevoEmpleado4);
//
//        Empleado nuevoEmpleado3 = new Empleado(null,"Josep","Renau Puig","camarero/a",
//                1200.00, LocalDateTime.of(2023,2,1,0,0,0));
//
//        empleadoController.create(nuevoEmpleado3);
//
//        Empleado nuevoEmpleado5 = new Empleado(null,"Llucia","Albenca Reus","camarero/a",
//                1200.00, LocalDateTime.of(2023,2,1,0,0,0));
//
//        empleadoController.create(nuevoEmpleado5);
//
//        Empleado nuevoEmpleado6 = new Empleado(null,"Romeo","Llores cortes","cocinero",
//                1700.00, LocalDateTime.of(2023,2,1,0,0,0));
//
//        empleadoController.create(nuevoEmpleado6);
//        Empleado nuevoEmpleado7 = new Empleado(null,"Neus","Martí lopez","limpieza",
//                1050.00, LocalDateTime.of(2023,2,1,0,0,0));
//
//        empleadoController.create(nuevoEmpleado7);
//        Empleado nuevoEmpleado8 = new Empleado(null,"Merçe","Pons Martorell","Jefa de sala",
//                1800.00, LocalDateTime.of(2021,2,1,0,0,0));
//
//        empleadoController.create(nuevoEmpleado8);
//        Empleado nuevoEmpleado9 = new Empleado(null,"Mario","Valor" ,"pinche de cocina",
//                1150.00, LocalDateTime.of(2020,2,1,0,0,0));
//
//        empleadoController.create(nuevoEmpleado9);

        //buscar por id
//        Integer idSearch = 4;
//        Empleado empleado = empleadoController.find(idSearch);
//        System.out.println(empleado);

        //eliminar registro por id
//        Integer idDelete = 20;
//        empleadoController.delete(idDelete);

        //leer lista
        List<Empleado> listaEmpleados = empleadoController.read();
        for(Empleado empleados: listaEmpleados){
            System.out.println(empleados);
         }
        //Editar empleado
//        Empleado editarEmpleado = empleadoController.find(1);
//        editarEmpleado.setApellidos("Rodriguez Gimeno");
//        empleadoController.update(editarEmpleado);

        //buscar por cargo
//        String cargo = "camarero/a";
//        List<Empleado> listaPorCargo = empleadoController.searchByCargo(cargo);
//        for(Empleado porCargos: listaPorCargo){
//            System.out.println(porCargos);
//        }
    }
}

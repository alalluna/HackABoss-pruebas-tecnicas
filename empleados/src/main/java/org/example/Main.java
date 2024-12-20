package org.example;

import org.example.controllers.EmpleadoController;
import org.example.entities.Empleado;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        EmpleadoController empleadoController = new EmpleadoController();

        Empleado nuevoEmpleado = new Empleado(null,"Salvador","Gimeno","Gerente",
                2000.00, LocalDateTime.of(2019,2,1,0,0,0));

        empleadoController.create(nuevoEmpleado);
    }


}
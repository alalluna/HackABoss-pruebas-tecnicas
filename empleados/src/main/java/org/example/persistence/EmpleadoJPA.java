package org.example.persistence;

import jakarta.persistence.EntityManager;
import org.example.entities.Empleado;

import java.time.LocalDateTime;
import java.util.ArrayList;


public class EmpleadoJPA {
    //para validar los datos del empleado es bueno confirmar que no se envian datos incorrectos
    // para los string valido que los datos en vacio, blanco o null
    //para el salario que no sea inferior a 0 euros
    //la fecha de inicio que no sea null
    private boolean validarEmpleado(Empleado nuevoEmpleado) {
        if (nuevoEmpleado.getNombre() == null || nuevoEmpleado.getNombre().isBlank() || nuevoEmpleado.getNombre().isEmpty()) {
            System.err.println("Escribe un nombre valido, no se aceptan en blanco o null");
            return false;
        }
        if (nuevoEmpleado.getApellidos() == null || nuevoEmpleado.getApellidos().isBlank()|| nuevoEmpleado.getApellidos().isEmpty()) {
            System.err.println("Escribe uno o dos apellidos, no se aceptan en blanco o null");
            return false;
        }
        if (nuevoEmpleado.getCargo() == null) {
            System.err.println("Escribe un cargo entre los siguientes disponibles: ");
            System.out.println("camarero, cocinero, jefe de cocina, jefe de sala, gerente, limpieza, pinche de cocina.");
            return false;
        }
        if (nuevoEmpleado.getSalario() == null || nuevoEmpleado.getSalario() <= 0) {
            System.err.println("El salario no puede ser nulo o 0");
            return false;
        }
        if (nuevoEmpleado.getFecha_inicio() == null) {
            System.err.println("La fecha de inicio debe ser valida y tiene la siguiente estructura: 2024,12,20,0,0,0");
            return false;
        }
        return true;
    }
    //lista de empleados
    ArrayList<Empleado> empleados = new ArrayList<>();

    //crear un empleado (if else para validar, try finally para guardar en la bbdd)
    public void create(Empleado nuevoEmpleado){
        if(validarEmpleado(nuevoEmpleado)){
            EntityManager em = ConfigJPA.getEntityManager();
            try{
                // guardar en la bbdd
                em.getTransaction().begin(); // Iniciar transaccion
                em.persist(nuevoEmpleado); //persistir la entidad
                em.getTransaction().commit(); //confirmar la transaccion

            }finally {
                em.close();//cerrar la transaccion
            }
        } else {
            //si no se introducen valores correctos
            System.err.println("Estos datos no son correctos para crear un empleado");
        }
    }
}

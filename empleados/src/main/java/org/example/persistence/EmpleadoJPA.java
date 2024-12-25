package org.example.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.entities.Empleado;
import org.example.exceptions.EmployeeValidationException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//aquí desarrollo los metodos
//He renombrado los métodos para que describan mejor su funcion
public class EmpleadoJPA {

    //importo exception para validar los datos del empleado y manejar las excepciones.
    // para los string valido que los datos no esten vacios, blanco o null.
    //edición de validate para poder reutilizarlo correctamente en un nuevo empleado o en un empleado existente

    private boolean validateEmployee(Empleado empleado) throws EmployeeValidationException {
        if (empleado.getNombre() == null || empleado.getNombre().isBlank() || empleado.getNombre().isEmpty()) {
            throw new EmployeeValidationException("Escribe un nombre valido, no se aceptan en blanco o null");
        }
        if (empleado.getApellidos() == null || empleado.getApellidos().isBlank() || empleado.getApellidos().isEmpty()) {
            throw new EmployeeValidationException("Escribe uno o dos apellidos, no se aceptan en blanco o null");
        }
        if (empleado.getCargo() == null || empleado.getCargo().isEmpty() || empleado.getCargo().isBlank()) {
            throw new EmployeeValidationException("Escribe un cargo entre los siguientes disponibles: camarero/a, cocinero/a, jefe de cocina, jefe de sala, gerente, limpieza, pinche de cocina.");
        }
        //el salario no puede ser null y tampoco menor que cero, si puede ser igual a cero por si están en practicas
        if (empleado.getSalario() == null || empleado.getSalario() < 0) {
            throw new EmployeeValidationException("El salario no puede ser nulo o menor que 0");
        }
        //corroboro que la fecha no puede ser null ni inferior a la fecha actual
        //variable fecha actual
        LocalDateTime now = LocalDateTime.now();
        if (empleado.getFecha_inicio() == null|| empleado.getFecha_inicio().isAfter(now)) {
            throw new EmployeeValidationException("La fecha de inicio debe ser valida y tiene la siguiente estructura: 2024,12,20,0,0,0");
        }
        return true;
    }

    //lista de empleados
    ArrayList<Empleado> empleados = new ArrayList<>();

    //crear un empleado (if else para validar, try finally para guardar en la bbdd)
    public void createEmployee(Empleado nuevoEmpleado) {
        EntityManager em = ConfigJPA.getEntityManager();
        try {
            validateEmployee(nuevoEmpleado);
            // guardar en la bbdd
            em.getTransaction().begin(); // Iniciar transaccion
            em.persist(nuevoEmpleado); //persistir la entidad
            em.getTransaction().commit(); //confirmar la transaccion

        } catch (EmployeeValidationException e) {
            System.err.println("Error en la validación del empleado: " + e.getMessage());
        } finally {
            em.close();//cerrar la transaccion
        }
    }
    //para encontrar un empleado por id y poder eliminarlo
    public Empleado findById(Integer idSearch) {
        EntityManager em = ConfigJPA.getEntityManager();
        try{
            return em.find(Empleado.class, idSearch);
        }finally {
            em.close();
        }
    }
    //eliminar un empleado
    public void deleteEmployee(Integer idDelete) {
        EntityManager em = ConfigJPA.getEntityManager();
        try{
            em.getTransaction().begin();
            Empleado empleado = em.find(Empleado.class, idDelete);
            if (empleado != null){
                em.remove(empleado);
            }else{
                System.err.println("El id " + idDelete + " no existe.");
            }
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }

    //leer la lista de Empleados
    public List<Empleado> readEmployees() {
        EntityManager em = ConfigJPA.getEntityManager();
        try {
            //se usa query para la consulta sql y se devuelve la lista de empleados
            TypedQuery<Empleado> query = em.createQuery("SELECT p FROM empleados p", Empleado.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    //editar un registro, es similar a crear pero usando merge
    public void updateEmployee(Empleado editarEmpleado){
        EntityManager em = ConfigJPA.getEntityManager();
        try {
            validateEmployee(editarEmpleado);
            // guardar en la bbdd
            em.getTransaction().begin(); // Iniciar transaccion
            em.merge(editarEmpleado); //merge para editar
            em.getTransaction().commit();

        } catch (EmployeeValidationException e) {
            System.err.println("Error en la validación del empleado: " + e.getMessage());
        } finally {
            em.close();//cerrar la transaccion
        }
    }

    //buscar por cargo
    public List<Empleado> searchByPosition(String cargo) {
        EntityManager em = ConfigJPA.getEntityManager();
        //En este caso es similar a read, pero se debe hacer la consulta por el string cargo
        try {
            String queryString = "SELECT p FROM empleados p WHERE p.cargo = '" + cargo + "'";
            TypedQuery<Empleado> query = em.createQuery(queryString, Empleado.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}

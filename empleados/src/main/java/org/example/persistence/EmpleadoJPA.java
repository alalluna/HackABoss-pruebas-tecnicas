package org.example.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.entities.Empleado;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//aquí desarrollo los metodos
public class EmpleadoJPA {

    //para validar los datos del empleado es bueno confirmar que no se envian datos incorrectos
    // para los string valido que los datos no esten vacios, blanco o null
    private boolean validarEmpleado(Empleado nuevoEmpleado) {
        if (nuevoEmpleado.getNombre() == null || nuevoEmpleado.getNombre().isBlank() || nuevoEmpleado.getNombre().isEmpty()) {
            System.err.println("Escribe un nombre valido, no se aceptan en blanco o null");
            return false;
        }
        if (nuevoEmpleado.getApellidos() == null || nuevoEmpleado.getApellidos().isBlank()|| nuevoEmpleado.getApellidos().isEmpty()) {
            System.err.println("Escribe uno o dos apellidos, no se aceptan en blanco o null");
            return false;
        }
        if (nuevoEmpleado.getCargo() == null || nuevoEmpleado.getCargo().isEmpty()|| nuevoEmpleado.getCargo().isBlank()) {
            System.err.println("Escribe un cargo entre los siguientes disponibles: ");
            System.err.println("camarero, cocinero, jefe de cocina, jefe de sala, gerente, limpieza, pinche de cocina.");
            return false;
        }
        //el salario no puede ser null y tampoco menor que cero, si puede ser igual a cero por si están en practicas
        if (nuevoEmpleado.getSalario() == null || nuevoEmpleado.getSalario() < 0) {
            System.err.println("El salario no puede ser nulo o menor que 0");
            return false;
        }
        //corroboro que la fecha no puede ser null ni inferior a la fecha actual

        //variable fecha actual
        LocalDateTime now = LocalDateTime.now();
        if (nuevoEmpleado.getFecha_inicio() == null|| nuevoEmpleado.getFecha_inicio().isAfter(now)) {
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
    //para encontrar un empleado por id y poder eliminarlo
    public Empleado find(Integer idSearch) {
        EntityManager em = ConfigJPA.getEntityManager();
        try{
            return em.find(Empleado.class, idSearch);
        }finally {
            em.close();
        }
    }
    //eliminar un empleado
    public void delete(Integer idDelete) {
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
    public List<Empleado> read() {
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
    public void update(Empleado editarEmpleado) {
        if(validarEmpleado(editarEmpleado)){
            EntityManager em = ConfigJPA.getEntityManager();
            try{
                em.getTransaction().begin();
                em.merge(editarEmpleado); //update
                em.getTransaction().commit();

            }finally {
                em.close();
            }
        } else {
            //si no se introducen valores correctos
            System.err.println("Estos datos no son correctos para crear un empleado");
        }
    }

    //buscar por cargo
    public List<Empleado> searchByCargo(String cargo) {
        EntityManager em = ConfigJPA.getEntityManager();
        //En este caso es similar a read pero se debe hacer la consulta por el string cargo
        try {
            String queryString = "SELECT p FROM empleados p WHERE p.cargo = '" + cargo + "'";
            TypedQuery<Empleado> query = em.createQuery(queryString, Empleado.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}

package com.egg.persistencia;

import com.egg.entidades.Empleado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EmpleadoDAO {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ViveroPU");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    public void guardarEmpleado(Empleado empleado) throws Exception {
        entityManager.getTransaction().begin();
        entityManager.persist(empleado);
        entityManager.getTransaction().commit();
    }
}

package com.egg.persistencia;

import com.egg.entidades.GamaProducto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class GamaProductoDAO {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ViveroPU");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    public void guardarGamaProducto(GamaProducto gamaProducto){
        entityManager.getTransaction().begin();
        entityManager.persist(gamaProducto);
        entityManager.getTransaction().commit();
    }
}

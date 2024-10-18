package com.egg.persistencia;

import com.egg.entidades.Pago;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PagoDAO {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ViveroPU");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    public void guardarPago(Pago pago) throws Exception {
        entityManager.getTransaction().begin();
        entityManager.persist(pago);
        entityManager.getTransaction().commit();
    }

}

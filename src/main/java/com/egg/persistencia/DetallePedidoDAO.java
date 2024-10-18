package com.egg.persistencia;

import com.egg.entidades.DetallePedido;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DetallePedidoDAO {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ViveroPU");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();


    public void guardarDetallePedido(DetallePedido detallePedido) throws Exception{
        entityManager.getTransaction().begin();
        entityManager.persist(detallePedido);
        entityManager.getTransaction().commit();
    }
}

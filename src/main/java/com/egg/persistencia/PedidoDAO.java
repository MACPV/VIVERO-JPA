package com.egg.persistencia;

import com.egg.entidades.Pedido;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PedidoDAO {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ViveroPU");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    public void guardarPedido(Pedido pedido) throws Exception {
        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.getTransaction().commit();
    }
}

package com.egg.persistencia;

import com.egg.entidades.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ClienteDAO {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ViveroPU");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    public void guardarCliente(Cliente cliente) throws Exception{
        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();
    }
}

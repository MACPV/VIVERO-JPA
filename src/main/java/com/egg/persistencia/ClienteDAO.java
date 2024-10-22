package com.egg.persistencia;

import com.egg.entidades.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ClienteDAO {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ViveroPU");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    public void guardarCliente(Cliente cliente) throws Exception {
        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();
    }

    public Cliente buscarClienteID(Integer idCliente) {
        try {
            return entityManager.find(Cliente.class, idCliente);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void mostrarCliente(Cliente cliente) {
        Cliente cliente1 = entityManager.find(Cliente.class, cliente.getIdCliente());
        System.out.print(cliente1.toString());

    }

    public void actualizarCliente(Cliente cliente) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(cliente);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Error al acualizar Cliente");
        }
    }

    public void eliminarCliente(Cliente cliente) throws Exception {


        entityManager.getTransaction().begin();
        entityManager.remove(cliente);
        entityManager.getTransaction().commit();

    }
}

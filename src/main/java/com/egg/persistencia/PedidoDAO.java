package com.egg.persistencia;

import com.egg.entidades.Cliente;
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

    public Pedido buscarPedidoID(Integer idPedido) {
        try {
            return entityManager.find(Pedido.class, idPedido);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void mostrarPedido(Pedido pedido) {
        Pedido pedido1 = entityManager.find(Pedido.class, pedido.getIdPedido());
        System.out.println(pedido1.toString());
    }

    public void actualizarPedido(Pedido pedido) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(pedido);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Error al acualizar pedido");
        }
    }

    public void eliminarPedido(Pedido pedido) throws Exception {


        entityManager.getTransaction().begin();
        entityManager.remove(pedido);
        entityManager.getTransaction().commit();

    }
}

package com.egg.persistencia;

import com.egg.entidades.Cliente;
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

    public Pago buscarPagoID(Integer idPago) {
        try {
            return entityManager.find(Pago.class, idPago);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void mostrarPago(Pago pago) {
        Pago pago1 = entityManager.find(Pago.class, pago.getIdPago());
        System.out.println(pago1.toString());

    }

    public void actualizarPago(Pago pago) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(pago);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Error al acualizar pago");
        }
    }

    public void eliminarPago(Pago pago) throws Exception {


        entityManager.getTransaction().begin();
        entityManager.remove(pago);
        entityManager.getTransaction().commit();

    }
}

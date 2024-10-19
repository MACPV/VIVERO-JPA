package com.egg.persistencia;

import com.egg.entidades.Oficina;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class OficinaDAO {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ViveroPU");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    public void guardarOficina(Oficina oficina) throws Exception {
        entityManager.getTransaction().begin();
        entityManager.persist(oficina);
        entityManager.getTransaction().commit();
    }

    public Oficina buscarOficinaID(Integer idOficina) {
        try {
            return entityManager.find(Oficina.class, idOficina);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

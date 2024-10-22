package com.egg.persistencia;

import com.egg.entidades.Cliente;
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

    public void mostrarOficina(Oficina oficina){
        Oficina oficina1 = entityManager.find(Oficina.class, oficina.getIdOficina());
        System.out.println(oficina1.toString());

    }

    public void actualizarOficina(Oficina oficina )throws Exception{
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(oficina);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            throw new Exception("Error al acualizar oficina");
        }
    }

    public void eliminarOficina(Oficina oficina) throws Exception{


        entityManager.getTransaction().begin();
        entityManager.remove(oficina);
        entityManager.getTransaction().commit();

    }
}

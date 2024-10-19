package com.egg.persistencia;

import com.egg.entidades.Oficina;
import com.egg.entidades.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ProductoDAO {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU");
    private final EntityManager em = emf.createEntityManager();

    public void guardarProducto(Producto producto) throws Exception {
        em.getTransaction().begin();
        em.persist(producto);
        em.getTransaction().commit();
    }

    public Producto buscarProductoID(Integer idProducto) {
        try {
            return em.find(Producto.class, idProducto);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}


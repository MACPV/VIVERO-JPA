package com.egg.persistencia;

import com.egg.entidades.Cliente;
import com.egg.entidades.Oficina;
import com.egg.entidades.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ProductoDAO {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU");
    private final EntityManager entityManager = emf.createEntityManager();

    public void guardarProducto(Producto producto) throws Exception {
        entityManager.getTransaction().begin();
        entityManager.persist(producto);
        entityManager.getTransaction().commit();
    }

    public Producto buscarProductoID(Integer idProducto) {
        try {
            return entityManager.find(Producto.class, idProducto);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void mostrarProducto(Producto producto) {
        Producto producto1 = entityManager.find(Producto.class, producto.getIdProducto());
        System.out.println(producto1.toString());
    }

    public void actualizarProducto(Producto producto) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(producto);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Error al acualizar Cliente");
        }
    }

    public void eliminarProducto(Producto producto) throws Exception {


        entityManager.getTransaction().begin();
        entityManager.remove(producto);
        entityManager.getTransaction().commit();

    }

}


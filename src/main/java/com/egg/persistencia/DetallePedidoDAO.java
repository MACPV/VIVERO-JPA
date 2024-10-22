package com.egg.persistencia;

import com.egg.entidades.Cliente;
import com.egg.entidades.DetallePedido;
import com.egg.entidades.Pedido;
import com.egg.entidades.Producto;
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
    public DetallePedido buscarDetallePedidoID (Integer idDetallePedido){
        try {
            return entityManager.find(DetallePedido.class,idDetallePedido);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public void mostrarDetallePedido(DetallePedido detallePedido){
        DetallePedido detallePedido1 = entityManager.find(DetallePedido.class,detallePedido.getIdDetallePedido());
        System.out.println(detallePedido1.toString());
    }

    public void actualizarDetallePedido(DetallePedido detallePedido)throws Exception{
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(detallePedido);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            throw new Exception("Error al acualizar Detalle Pedido");
        }
    }

    public void eliminarDetallePedido(DetallePedido detallePedido) throws Exception{


        entityManager.getTransaction().begin();
        entityManager.remove(detallePedido);
        entityManager.getTransaction().commit();

    }


}

package com.egg;

import com.egg.entidades.Empleado;
import com.egg.servicios.ClienteServicio;
import com.egg.servicios.DetallePedidoServicio;
import com.egg.servicios.GamaProductoServicio;
import com.egg.servicios.OficinaServicio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) throws Exception {

        /*EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU");
        EntityManager em = emf.createEntityManager();*/

        DetallePedidoServicio detallePedidoServicio = new DetallePedidoServicio();
        detallePedidoServicio.crearDetallePedido(
                20,
                "14",
                (short) 10,
                4,
                4
        );



      }


}
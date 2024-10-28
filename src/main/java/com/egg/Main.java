package com.egg;

import com.egg.entidades.Empleado;
import com.egg.entidades.Pedido;
import com.egg.persistencia.ClienteDAO;
import com.egg.servicios.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) throws Exception {

        /*EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU");
        EntityManager em = emf.createEntityManager();*/


        OficinaServicio oficinaServicio = new OficinaServicio();
        oficinaServicio.listarOficinas();
      }


}
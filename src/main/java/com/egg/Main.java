package com.egg;

import com.egg.servicios.OficinaServicio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        /*EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU");
        EntityManager em = emf.createEntityManager();*/

        OficinaServicio oficinaServicio = new OficinaServicio();

        oficinaServicio .crearOficina("Chiclayo","14003","CHI-001","Peru","Lambayeque","998844");
    }
}
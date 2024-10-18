package com.egg.servicios;

import com.egg.persistencia.OficinaDAO;

public class ClienteServicio {
    private final OficinaDAO oficinaDAO;

    public ClienteServicio() {
        this.oficinaDAO = new OficinaDAO();
    }
}

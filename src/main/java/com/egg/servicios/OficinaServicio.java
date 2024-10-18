package com.egg.servicios;

import com.egg.entidades.Oficina;
import com.egg.persistencia.OficinaDAO;

public class OficinaServicio {

    private final OficinaDAO oficinaDAO;

    public OficinaServicio() {
        this.oficinaDAO = new OficinaDAO();
    }

    public void crearOficina(String ciudad, String codigoPostal,
                             String codigoOficina, String pais, String region, String telefono) {

        try {
            Oficina oficinaNueva = new Oficina();

            oficinaNueva.setCiudad(ciudad);
            oficinaNueva.setPais(pais);
            oficinaNueva.setCodigoOficina(codigoOficina);
            oficinaNueva.setRegion(region);
            oficinaNueva.setTelefono(telefono);
            oficinaNueva.setCodigoPostal(codigoPostal);

            oficinaDAO.guardarOficina(oficinaNueva);
        } catch (Exception e) {
            System.out.println(e.toString() + "No se guardó la oficina nueva");
        }
    }
}

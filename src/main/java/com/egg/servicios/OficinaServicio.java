package com.egg.servicios;

import com.egg.entidades.Oficina;
import com.egg.persistencia.OficinaDAO;

import java.util.List;

public class OficinaServicio {

    private final OficinaDAO oficinaDAO;

    public OficinaServicio() {
        this.oficinaDAO = new OficinaDAO();
    }

    public void crearOficina(
            String ciudad,
            String codigoPostal,
            String codigoOficina,
            String pais,
            String region,
            String telefono
    ) {

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

    public void buscarOficina(Integer idOficina) {
        Oficina oficina = oficinaDAO.buscarOficinaID(idOficina);
        oficinaDAO.mostrarOficina(oficina);
    }

    public void actualizarOficina(
            Integer idOficina,
            String ciudad,
            String codigoPostal,
            String codigoOficina,
            String pais,
            String region,
            String telefono
    ) throws Exception {

        Oficina oficinaExistente = oficinaDAO.buscarOficinaID(idOficina);
        if (oficinaExistente == null) {
            throw new Exception("No se encontró la oficina con ID: " + idOficina);
        }

        oficinaExistente.setCiudad(ciudad);
        oficinaExistente.setPais(pais);
        oficinaExistente.setCodigoOficina(codigoOficina);
        oficinaExistente.setRegion(region);
        oficinaExistente.setTelefono(telefono);
        oficinaExistente.setCodigoPostal(codigoPostal);

        oficinaDAO.guardarOficina(oficinaExistente);
    }

    public void eliminarOficina(Integer idOficina) throws Exception {
        Oficina oficina = oficinaDAO.buscarOficinaID(idOficina);
        if (oficina == null) {
            throw new Exception("No se encontró la oficina con ID: " + idOficina);
        }
        oficinaDAO.eliminarOficina(oficina);
    }
    public void listarOficinas() throws Exception{
        List<Oficina> todasOficinas = oficinaDAO.listarTodo();
        imprimirLista(todasOficinas);
    }
    public void imprimirLista(List<Oficina> listaRecibida){
        for (Oficina oficina: listaRecibida){
            System.out.println(oficina.toString());
        }
    }
}

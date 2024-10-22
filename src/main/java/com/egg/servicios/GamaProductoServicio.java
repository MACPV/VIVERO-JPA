package com.egg.servicios;

import com.egg.entidades.GamaProducto;
import com.egg.persistencia.GamaProductoDAO;

public class GamaProductoServicio {
    private final GamaProductoDAO gamaProductoDAO;

    public GamaProductoServicio() {
        this.gamaProductoDAO = new GamaProductoDAO();
    }

    public void crearGamaProducto(
            String descripcionHtml,
            String descripcionTexto,
            String gama,
            String imagen
    ) {

        try {

            GamaProducto gamaProductoNuevo = new GamaProducto();

            gamaProductoNuevo.setDescripcionHtml(descripcionHtml);
            gamaProductoNuevo.setDescripcionTexto(descripcionTexto);
            gamaProductoNuevo.setGama(gama);
            gamaProductoNuevo.setImagen(imagen);

            gamaProductoDAO.guardarGamaProducto(gamaProductoNuevo);
        } catch (Exception e) {
            System.out.println(e.toString() + "No se guardo la nueva gama de producto");
        }
    }

    public void buscarGamaProducto(Integer idGama) {
        GamaProducto gamaProducto = gamaProductoDAO.buscarGamaProductoID(idGama);
        gamaProductoDAO.mostrarGamaProducto(gamaProducto);
    }

    public void actualizarGamaProducto(
            Integer idGamaProdcuto,
            String descripcionHtml,
            String descripcionTexto,
            String gama,
            String imagen
    ) throws Exception {

        GamaProducto gamaProductoExistente = gamaProductoDAO.buscarGamaProductoID(idGamaProdcuto);

        if (gamaProductoExistente == null) {
            throw new Exception("No se encontró la Gama Producto con id: " + idGamaProdcuto + " ");
        }

        gamaProductoExistente.setDescripcionHtml(descripcionHtml);
        gamaProductoExistente.setDescripcionTexto(descripcionTexto);
        gamaProductoExistente.setGama(gama);
        gamaProductoExistente.setImagen(imagen);

        gamaProductoDAO.guardarGamaProducto(gamaProductoExistente);

    }

    public void eliminarGamaProducto(Integer idGamaProducto) throws Exception {
        GamaProducto gamaProducto = gamaProductoDAO.buscarGamaProductoID(idGamaProducto);
        if (gamaProducto == null) {
            throw new Exception("No se encontró la Gama Producto con id: " + idGamaProducto + " ");
        }
        gamaProductoDAO.eliminarGamaProducto(gamaProducto);
    }
}

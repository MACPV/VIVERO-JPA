package com.egg.servicios;

import com.egg.entidades.GamaProducto;
import com.egg.persistencia.GamaProductoDAO;

public class GamaProductoServicio {
    private final GamaProductoDAO gamaProductoDAO;

    public GamaProductoServicio() {
        this.gamaProductoDAO = new GamaProductoDAO();
    }

    public void crearGamaProducto(String descripcionHtml,
                                    String descripcionTexto, String gama, String imagen) {

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
}

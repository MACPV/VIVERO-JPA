package com.egg.servicios;

import com.egg.entidades.GamaProducto;
import com.egg.entidades.Producto;
import com.egg.persistencia.GamaProductoDAO;
import com.egg.persistencia.ProductoDAO;

public class ProductoServicio {
    private final ProductoDAO productoDAO;
    private final GamaProductoDAO gamaProductoDAO;

    public ProductoServicio() {
        this.productoDAO = new ProductoDAO();
        this.gamaProductoDAO = new GamaProductoDAO();
    }

    public void crearProducto(
            Integer cantidadEnStock,
            String codigoProducto,
            String descripcion,
            String dimensiones,
            String nombre,
            Integer precioProveedor,
            Integer precioVenta,
            String Proveedor,
            Integer idGamaProducto
    ) throws Exception {

        GamaProducto gamaProducto = gamaProductoDAO.buscarGamaProductoID(idGamaProducto);

        if (gamaProducto == null) {
            throw new Exception("El GamaProducto con id: " + idGamaProducto + " no fue encontrado");
        }

        Producto productoNuevo = new Producto();

        productoNuevo.setCantidadEnStock(cantidadEnStock);
        productoNuevo.setCodigoProducto(codigoProducto);
        productoNuevo.setDescripcion(descripcion);
        productoNuevo.setDimensiones(dimensiones);
        productoNuevo.setNommbre(nombre);
        productoNuevo.setPrecioProveedor(precioProveedor);
        productoNuevo.setPrecioVenta(precioVenta);
        productoNuevo.setProveedor(Proveedor);
        productoNuevo.setGamaProducto(gamaProducto);

        productoDAO.guardarProducto(productoNuevo);

    }
}

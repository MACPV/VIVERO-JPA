package com.egg.servicios;

import com.egg.entidades.Cliente;
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

    public void buscarProducto(Integer idProducto) {
        Producto producto = productoDAO.buscarProductoID(idProducto);
        productoDAO.mostrarProducto(producto);
    }

    public void actualizarProducto(
            Integer idProducto,
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
        Producto productoExistente = productoDAO.buscarProductoID(idProducto);
        if (productoExistente == null) {
            throw new Exception("El Producto con ID " + idProducto + " no existe.");
        }
        GamaProducto gamaProducto = gamaProductoDAO.buscarGamaProductoID(idGamaProducto);

        if (gamaProducto == null) {
            throw new Exception("El GamaProducto con id: " + idGamaProducto + " no fue encontrado");
        }
        productoExistente.setCantidadEnStock(cantidadEnStock);
        productoExistente.setCodigoProducto(codigoProducto);
        productoExistente.setDescripcion(descripcion);
        productoExistente.setDimensiones(dimensiones);
        productoExistente.setNommbre(nombre);
        productoExistente.setPrecioProveedor(precioProveedor);
        productoExistente.setPrecioVenta(precioVenta);
        productoExistente.setProveedor(Proveedor);
        productoExistente.setGamaProducto(gamaProducto);

        productoDAO.guardarProducto(productoExistente);
    }

    public void eliminarProducto(Integer idProducto) throws Exception {
        Producto producto = productoDAO.buscarProductoID(idProducto);
        if (producto == null) {
            throw new Exception("El cliente con ID: " + idProducto + " no existe");
        }
        productoDAO.eliminarProducto(producto);
    }
}

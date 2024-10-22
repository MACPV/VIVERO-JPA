package com.egg.servicios;

import com.egg.entidades.DetallePedido;
import com.egg.entidades.Pedido;
import com.egg.entidades.Producto;
import com.egg.persistencia.DetallePedidoDAO;
import com.egg.persistencia.PedidoDAO;
import com.egg.persistencia.ProductoDAO;

public class DetallePedidoServicio {
    private final DetallePedidoDAO detallePedidoDAO;
    private final ProductoDAO productoDAO;
    private final PedidoDAO pedidoDAO;

    public DetallePedidoServicio() {
        this.detallePedidoDAO = new DetallePedidoDAO();
        this.pedidoDAO = new PedidoDAO();
        this.productoDAO = new ProductoDAO();
    }

    public void crearDetallePedido(
            Integer cantidad,
            String precioUnidad,
            short numeroLinea,
            Integer idProducto,
            Integer idPedido
    ) throws Exception {

        Pedido pedido = pedidoDAO.buscarPedidoID(idPedido);
        Producto producto = productoDAO.buscarProductoID(idProducto);

        if (pedido == null) {
            throw new Exception("El pedido con id " + idPedido + " no existe");
        }
        if (producto == null) {
            throw new Exception("El producto con id " + idProducto + " no existe");
        }
        DetallePedido detallePedidoNuevo = new DetallePedido();

        detallePedidoNuevo.setCantidad(cantidad);
        detallePedidoNuevo.setPrecioUnidad(precioUnidad);
        detallePedidoNuevo.setNumeroLinea(numeroLinea);
        detallePedidoNuevo.setProducto(producto);
        detallePedidoNuevo.setPedido(pedido);

        detallePedidoDAO.guardarDetallePedido(detallePedidoNuevo);
    }

    public void buscarDetallePedido(Integer idDetallePedido) {
        DetallePedido detallePedido = detallePedidoDAO.buscarDetallePedidoID(idDetallePedido);
        detallePedidoDAO.mostrarDetallePedido(detallePedido);
    }

    public void actualizarDetallePedido(
            Integer idDetallePedido,
            Integer cantidad,
            String precioUnidad,
            short numeroLinea,
            Integer idProducto,
            Integer idPedido
    ) throws Exception {

        DetallePedido detallePedidoExistente = detallePedidoDAO.buscarDetallePedidoID(idDetallePedido);
        if (detallePedidoExistente == null) {
            throw new Exception("El Detalle Pedido con id: " + idDetallePedido + " no existe");
        }
        Pedido pedido = pedidoDAO.buscarPedidoID(idPedido);
        Producto producto = productoDAO.buscarProductoID(idProducto);

        if (pedido == null) {
            throw new Exception("El pedido con id " + idPedido + " no existe");
        }
        if (producto == null) {
            throw new Exception("El producto con id " + idProducto + " no existe");
        }

        detallePedidoExistente.setCantidad(cantidad);
        detallePedidoExistente.setPrecioUnidad(precioUnidad);
        detallePedidoExistente.setNumeroLinea(numeroLinea);
        detallePedidoExistente.setProducto(producto);
        detallePedidoExistente.setPedido(pedido);

        detallePedidoDAO.guardarDetallePedido(detallePedidoExistente);
    }

    public void eliminarDetallePedido(Integer idDetallePedido)throws Exception{
        DetallePedido detallePedido = detallePedidoDAO.buscarDetallePedidoID(idDetallePedido);
        if (detallePedido == null){
            throw new Exception("El Detalle Pedido con id: " + idDetallePedido + " no existe");
        }
        detallePedidoDAO.eliminarDetallePedido(detallePedido);
    }
}

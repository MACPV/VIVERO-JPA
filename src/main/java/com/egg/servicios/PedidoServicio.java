package com.egg.servicios;

import com.egg.entidades.Cliente;
import com.egg.entidades.Pedido;
import com.egg.persistencia.ClienteDAO;
import com.egg.persistencia.PedidoDAO;

import java.time.LocalDate;

public class PedidoServicio {
    private final PedidoDAO pedidoDAO;
    private final ClienteDAO clienteDAO;

    public PedidoServicio() {
        this.pedidoDAO = new PedidoDAO();
        this.clienteDAO = new ClienteDAO();
    }

    public void crearPedidoServicio(
            Integer codigoPedido,
            String comentarios,
            String estado,
            LocalDate fechaEntrega,
            LocalDate fechaEsperada,
            Integer idCliente
    ) throws Exception {

        Cliente cliente = clienteDAO.buscarClienteID(idCliente);

        if (cliente == null) {

            throw new Exception("El cliente con id: " + idCliente + " no se encuentra");

        }

        Pedido pedidoNuevo = new Pedido();

        pedidoNuevo.setCodigoPedido(codigoPedido);
        pedidoNuevo.setComentarios(comentarios);
        pedidoNuevo.setEstado(estado);
        pedidoNuevo.setFechaEntrega(fechaEntrega);
        pedidoNuevo.setFechaEsperada(fechaEsperada);
        pedidoNuevo.setCliente(cliente);

        pedidoDAO.guardarPedido(pedidoNuevo);
    }

    public void buscarPedido(Integer idPedido) {
        Pedido pedido = pedidoDAO.buscarPedidoID(idPedido);
        pedidoDAO.mostrarPedido(pedido);
    }

    public void actualizarPedido(
            Integer idPedido,
            Integer codigoPedido,
            String comentarios,
            String estado,
            LocalDate fechaEntrega,
            LocalDate fechaEsperada,
            Integer idCliente
    ) throws Exception {

        Cliente cliente = clienteDAO.buscarClienteID(idCliente);
        if (cliente == null) {
            throw new Exception("El cliente con id: " + idCliente + " no se encuentra");
        }

        Pedido pedidoExistente = pedidoDAO.buscarPedidoID(idPedido);
        if (pedidoExistente == null) {
            throw new Exception("El Pedido con id: " + idPedido + " no se encuentra");
        }

        pedidoExistente.setCodigoPedido(codigoPedido);
        pedidoExistente.setComentarios(comentarios);
        pedidoExistente.setEstado(estado);
        pedidoExistente.setFechaEntrega(fechaEntrega);
        pedidoExistente.setFechaEsperada(fechaEsperada);
        pedidoExistente.setCliente(cliente);

        pedidoDAO.guardarPedido(pedidoExistente);
    }

    public void eliminarPedidoe(Integer idPedido) throws Exception {
        Pedido pedido = pedidoDAO.buscarPedidoID(idPedido);
        if (pedido == null) {
            throw new Exception("El Pedido con ID: " + idPedido + " no existe");
        }
        pedidoDAO.eliminarPedido(pedido);
    }
}

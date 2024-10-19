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
}

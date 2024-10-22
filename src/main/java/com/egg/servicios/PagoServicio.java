package com.egg.servicios;

import com.egg.entidades.Cliente;
import com.egg.entidades.Pago;
import com.egg.persistencia.ClienteDAO;
import com.egg.persistencia.PagoDAO;

import java.time.LocalDate;

public class PagoServicio {

    private final PagoDAO pagoDAO;
    private final ClienteDAO clienteDAO;

    public PagoServicio() {
        this.pagoDAO = new PagoDAO();
        this.clienteDAO = new ClienteDAO();
    }

    public void crearPago(
            LocalDate fechaPago,
            String formasPago,
            String idTransaccion,
            Double total,
            Integer idCliente
    ) throws Exception {
        Cliente cliente = clienteDAO.buscarClienteID(idCliente);

        if (cliente == null) {
            throw new Exception("El cliente con id: " + idCliente + " no existe");
        }

        Pago pagoNuevo = new Pago();

        pagoNuevo.setFechaPago(fechaPago);
        pagoNuevo.setFormasPago(formasPago);
        pagoNuevo.setIdTransaccion(idTransaccion);
        pagoNuevo.setTotal(total);
        pagoNuevo.setCliente(cliente);

        pagoDAO.guardarPago(pagoNuevo);
    }

    public void buscarPago(Integer idPago) {
        Pago pago = pagoDAO.buscarPagoID(idPago);
        pagoDAO.mostrarPago(pago);
    }

    public void actualizarPago(
            Integer idPago,
            LocalDate fechaPago,
            String formasPago,
            String idTransaccion,
            Double total,
            Integer idCliente
    ) throws Exception {
        Cliente cliente = clienteDAO.buscarClienteID(idCliente);

        if (cliente == null) {
            throw new Exception("El cliente con id: " + idCliente + " no existe");
        }

        Pago pagoExistente = pagoDAO.buscarPagoID(idPago);
        if (pagoExistente == null) {
            throw new Exception("El pago con id: " + idPago + " no existe");
        }

        pagoExistente.setFechaPago(fechaPago);
        pagoExistente.setFormasPago(formasPago);
        pagoExistente.setIdTransaccion(idTransaccion);
        pagoExistente.setTotal(total);
        pagoExistente.setCliente(cliente);

        pagoDAO.guardarPago(pagoExistente);
    }

    public void eliminarPago(Integer idPago) throws Exception {
        Pago pago = pagoDAO.buscarPagoID(idPago);
        if (pago == null) {
            throw new Exception("El pago con id: " + idPago + " no existe");
        }
        pagoDAO.eliminarPago(pago);
    }
}

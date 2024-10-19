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
    )throws Exception{
        Cliente cliente = clienteDAO.buscarClienteID(idCliente);

        if(cliente==null){
            throw new Exception("El clinete con id: "+idCliente+" no existe");
        }

        Pago pagoNuevo = new Pago();

        pagoNuevo.setFechaPago(fechaPago);
        pagoNuevo.setFormasPago(formasPago);
        pagoNuevo.setIdTransaccion(idTransaccion);
        pagoNuevo.setTotal(total);
        pagoNuevo.setCliente(cliente);

        pagoDAO.guardarPago(pagoNuevo);
    }

}

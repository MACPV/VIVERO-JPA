package com.egg.servicios;

import com.egg.entidades.Cliente;
import com.egg.entidades.Empleado;
import com.egg.persistencia.ClienteDAO;
import com.egg.persistencia.EmpleadoDAO;
import com.egg.persistencia.OficinaDAO;

import java.math.BigDecimal;

public class ClienteServicio {
    private final ClienteDAO clienteDAO;
    private final EmpleadoDAO empleadoDAO;

    public ClienteServicio() {
        this.clienteDAO = new ClienteDAO();
        this.empleadoDAO = new EmpleadoDAO();
    }

    public void crearCliente(
            int codigoCliente,
            String nombreCliente,
            String nombreContacto,
            String apellidoContacto,
            String telefono,
            String fax,
            String lineaDireccion1,
            String lineaDireccion2,
            String ciudad,
            String region,
            String pais,
            String codigoPostal,
            int idEmpleado,
            BigDecimal limiteCredito) throws Exception {


        Empleado empleado = empleadoDAO.buscarEmpleadoPorId(idEmpleado);

        if (empleado == null) {
            throw new Exception("El empleado con ID " + idEmpleado + " no existe.");
        }

        Cliente clienteNuevo = new Cliente();

        clienteNuevo.setCodigoCliente(codigoCliente);
        clienteNuevo.setNombreCliente(nombreCliente);
        clienteNuevo.setNombreContacto(nombreContacto);
        clienteNuevo.setApellidoContacto(apellidoContacto);
        clienteNuevo.setTelefono(telefono);
        clienteNuevo.setFax(fax);
        clienteNuevo.setLineaDireccion1(lineaDireccion1);
        clienteNuevo.setLineaDireccion2(lineaDireccion2);
        clienteNuevo.setCiudad(ciudad);
        clienteNuevo.setRegion(region);
        clienteNuevo.setPais(pais);
        clienteNuevo.setCodigoPostal(codigoPostal);
        clienteNuevo.setEmpleado(empleado);
        clienteNuevo.setLimiteCredito(limiteCredito);

        clienteDAO.guardarCliente(clienteNuevo);

    }

}

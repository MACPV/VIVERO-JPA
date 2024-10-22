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

    public void buscarCliente(Integer idCliente) {

        Cliente cliente = clienteDAO.buscarClienteID(idCliente);
        clienteDAO.mostrarCliente(cliente);
    }

    public void actualizarCliente(
            Integer idCliente,
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

        Cliente clienteExistente = clienteDAO.buscarClienteID(idCliente);

        if (clienteExistente == null) {
            throw new Exception("El cliente con ID " + idCliente + " no existe.");
        }

        Empleado empleado = empleadoDAO.buscarEmpleadoPorId(idEmpleado);

        if (empleado == null) {
            throw new Exception("El empleado con ID " + idEmpleado + " no existe.");
        }

        clienteExistente.setCodigoCliente(codigoCliente);
        clienteExistente.setNombreCliente(nombreCliente);
        clienteExistente.setNombreContacto(nombreContacto);
        clienteExistente.setApellidoContacto(apellidoContacto);
        clienteExistente.setTelefono(telefono);
        clienteExistente.setFax(fax);
        clienteExistente.setLineaDireccion1(lineaDireccion1);
        clienteExistente.setLineaDireccion2(lineaDireccion2);
        clienteExistente.setCiudad(ciudad);
        clienteExistente.setRegion(region);
        clienteExistente.setPais(pais);
        clienteExistente.setCodigoPostal(codigoPostal);
        clienteExistente.setEmpleado(empleado);
        clienteExistente.setLimiteCredito(limiteCredito);

        clienteDAO.guardarCliente(clienteExistente);

    }

    public void eliminarCliente(Integer idCliente) throws Exception {
        Cliente cliente = clienteDAO.buscarClienteID(idCliente);
        if (cliente == null) {
            throw new Exception("El cliente con ID: " + idCliente + " no existe");
        }
        clienteDAO.eliminarCliente(cliente);
    }
}

package com.egg.servicios;

import com.egg.entidades.Empleado;
import com.egg.entidades.Oficina;
import com.egg.persistencia.EmpleadoDAO;
import com.egg.persistencia.OficinaDAO;

public class EmpleadoServicio {

    private final EmpleadoDAO empleadoDAO;
    private final OficinaDAO oficinaDAO;

    public EmpleadoServicio() {
        this.empleadoDAO = new EmpleadoDAO();
        this.oficinaDAO = new OficinaDAO();
    }

    public void crearEmpleado(
            String nombre,
            String apellido,
            Integer codigoEmpleado,
            String email,
            String extension,
            Integer idJefe,
            String puesto,
            Integer idOficina
    ) throws Exception {

        Oficina oficina = oficinaDAO.buscarOficinaID(idOficina);

        if (oficina == null) {
            throw new Exception("La oficina con id: " + idOficina + " no existe");
        }

        Empleado empleadoNuevo = new Empleado();

        empleadoNuevo.setNombre(nombre);
        empleadoNuevo.setApellido(apellido);
        empleadoNuevo.setCodigoEmpleado(codigoEmpleado);
        empleadoNuevo.setEmail(email);
        empleadoNuevo.setExtension(extension);
        empleadoNuevo.setIdJefe(idJefe);
        empleadoNuevo.setPuesto(puesto);

        empleadoDAO.guardarEmpleado(empleadoNuevo);
    }

    public void buscarEmpleado(Integer idEmpleado) {
        Empleado empleado = empleadoDAO.buscarEmpleadoPorId(idEmpleado);
        empleadoDAO.mostrarEmpleado(empleado);
    }

    public void actualizarEmpleado(
            Integer idEmpleado,
            String nombre,
            String apellido,
            Integer codigoEmpleado,
            String email,
            String extension,
            Integer idJefe,
            String puesto,
            Integer idOficina
    ) throws Exception {
        Empleado empleadoExistente = empleadoDAO.buscarEmpleadoPorId(idEmpleado);
        if (empleadoExistente == null) {
            throw new Exception("El empleado con id: " + idEmpleado + " no existe");
        }

        Oficina oficina = oficinaDAO.buscarOficinaID(idOficina);
        if (oficina == null) {
            throw new Exception("La oficina con id: " + idOficina + " no existe");
        }

        empleadoExistente.setNombre(nombre);
        empleadoExistente.setApellido(apellido);
        empleadoExistente.setCodigoEmpleado(codigoEmpleado);
        empleadoExistente.setEmail(email);
        empleadoExistente.setExtension(extension);
        empleadoExistente.setIdJefe(idJefe);
        empleadoExistente.setPuesto(puesto);

        empleadoDAO.guardarEmpleado(empleadoExistente);
    }

    public void eliminarEmpleado(Integer idEmpleado) throws Exception {
        Empleado empleado = empleadoDAO.buscarEmpleadoPorId(idEmpleado);
        if (empleado == null) {
            throw new Exception("El empleado con id: " + idEmpleado + " no existe");
        }
        empleadoDAO.eliminarEmpleado(empleado);
    }
}

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
            throw new Exception("El empleado con id: " + idOficina + " no existe");
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
}

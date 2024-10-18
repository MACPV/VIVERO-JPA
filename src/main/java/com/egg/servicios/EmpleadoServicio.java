package com.egg.servicios;

import com.egg.entidades.Oficina;
import com.egg.persistencia.EmpleadoDAO;

public class EmpleadoServicio {

    private final EmpleadoDAO empleadoDAO;

    public EmpleadoServicio() {
        this.empleadoDAO = new EmpleadoDAO();
    }

    public void guardarEmpleado(Integer idEmpleado, String nombre, String apellido, Integer codigoEmpleado, String email,
                                String extension, Integer idJefe, String puesto, Oficina oficina) throws Exception {

    }
}

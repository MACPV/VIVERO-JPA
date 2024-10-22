package com.egg.entidades;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Integer idEmpleado;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "codigo_empleado")
    private Integer codigoEmpleado;

    @Column(name = "email")
    private String email;

    @Column(name = "extension")
    private String extension;

    @Column(name = "id_Jefe")
    private Integer idJefe;

    @Column(name = "puesto")
    private String puesto;

    @OneToMany(mappedBy = "empleado", cascade = CascadeType.REMOVE)
    private List<Cliente> clientes;

    @ManyToOne
    @JoinColumn(name = "id_oficina")
    private Oficina oficina;

    public Empleado() {
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(Integer codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Integer getIdJefe() {
        return idJefe;
    }

    public void setIdJefe(Integer idJefe) {
        this.idJefe = idJefe;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }


    public Oficina getOficina() {
        return oficina;
    }

    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("╔════════════════════╦════════════════════════════════════════╗\n");

        sb.append(String.format("║ ID Empleado        ║ %-38d ║\n", idEmpleado));
        sb.append("╠════════════════════╬════════════════════════════════════════╣\n");
        sb.append(String.format("║ Nombre             ║ %-38s ║\n", nombre));
        sb.append("╠════════════════════╬════════════════════════════════════════╣\n");
        sb.append(String.format("║ Apellido           ║ %-38s ║\n", apellido));
        sb.append("╠════════════════════╬════════════════════════════════════════╣\n");
        sb.append(String.format("║ Codigo Empleado    ║ %-38d ║\n", codigoEmpleado));
        sb.append("╠════════════════════╬════════════════════════════════════════╣\n");
        sb.append(String.format("║ email              ║ %-38s ║\n", email));
        sb.append("╠════════════════════╬════════════════════════════════════════╣\n");
        sb.append(String.format("║ Extension          ║ %-38s ║\n", extension));
        sb.append("╠════════════════════╬════════════════════════════════════════╣\n");
        sb.append(String.format("║ Id Jefe            ║ %-38d ║\n", idJefe));
        sb.append("╠════════════════════╬════════════════════════════════════════╣\n");
        sb.append(String.format("║ Puesto             ║ %-38s ║\n", puesto));
        sb.append("╠════════════════════╬════════════════════════════════════════╣\n");

        sb.append(String.format("║ Oficina ID         ║ %-38d ║\n", oficina.getIdOficina()));
        sb.append(String.format("║ Ofician Nombre     ║ %-38s ║\n", oficina.getCodigoOficina()));
        sb.append("╚════════════════════╩════════════════════════════════════════╝");


        return sb.toString();
    }
}

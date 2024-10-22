package com.egg.entidades;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "pago")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago")
    private Integer idPago;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_pago")
    private LocalDate fechaPago;

    @Column(name = "forma_pago")
    private String formasPago;

    @Column(name = "id_transaccion")
    private String idTransaccion;

    @Column(name = "total")
    private Double total;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public Pago() {
    }

    public Integer getIdPago() {
        return idPago;
    }

    public void setIdPago(Integer idPago) {
        this.idPago = idPago;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getFormasPago() {
        return formasPago;
    }

    public void setFormasPago(String formasPago) {
        this.formasPago = formasPago;
    }

    public String getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(String idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Cliente getCliente() {

        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("╔════════════════════╦════════════════════════════════════════╗\n");

        sb.append(String.format("║ ID Pago            ║ %-38d ║\n", idPago));
        sb.append("╠════════════════════╬════════════════════════════════════════╣\n");
        sb.append(String.format("║ Fecha Pago         ║ %-38s ║\n", fechaPago));
        sb.append("╠════════════════════╬════════════════════════════════════════╣\n");
        sb.append(String.format("║ Formas Pago        ║ %-38s ║\n", formasPago));
        sb.append("╠════════════════════╬════════════════════════════════════════╣\n");
        sb.append(String.format("║ ID Transaccion     ║ %-38s ║\n", idTransaccion));
        sb.append("╠════════════════════╬════════════════════════════════════════╣\n");
        sb.append(String.format("║ Total              ║ %-38s ║\n", total));
        sb.append("╠════════════════════╬════════════════════════════════════════╣\n");
        sb.append(String.format("║ Cliente ID         ║ %-38d ║\n", cliente.getIdCliente()));
        sb.append(String.format("║ Cliente Nombre     ║ %-38s ║\n", cliente.getNombreCliente()));
        sb.append("╚════════════════════╩════════════════════════════════════════╝");


        return sb.toString();
    }
}

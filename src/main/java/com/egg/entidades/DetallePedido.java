package com.egg.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "detalle_pedido")
public class DetallePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_pedido")
    private Integer idDetallePedido;


    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "precio_unidad")
    private String precioUnidad;

    @Column(name = "numero_linea")
    private short numeroLinea;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    public DetallePedido() {
    }

    public Integer getIdDetallePedido() {
        return idDetallePedido;
    }

    public void setIdDetallePedido(Integer idDetallePedido) {
        this.idDetallePedido = idDetallePedido;
    }


    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(String precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public short getNumeroLinea() {
        return numeroLinea;
    }

    public void setNumeroLinea(short numeroLinea) {
        this.numeroLinea = numeroLinea;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // Línea superior de la tabla
        sb.append("╔════════════════════╦════════════════════════════════════════╗\n");

        // Datos del detalle pedido
        sb.append(String.format("║ ID Detalle Pedido  ║ %-38d ║\n", idDetallePedido));
        sb.append("╠════════════════════╬════════════════════════════════════════╣\n");
        sb.append(String.format("║ Cantidad           ║ %-38d ║\n", cantidad));
        sb.append("╠════════════════════╬════════════════════════════════════════╣\n");
        sb.append(String.format("║ Precio Unidad      ║ %-38.2s ║\n", precioUnidad));
        sb.append("╠════════════════════╬════════════════════════════════════════╣\n");
        sb.append(String.format("║ Número Línea       ║ %-38d ║\n", numeroLinea));
        sb.append("╠════════════════════╬════════════════════════════════════════╣\n");

        // Información del producto (asumiendo que producto tiene un getId() y getNombre())
        sb.append(String.format("║ Producto ID        ║ %-38d ║\n", producto.getIdProducto()));
        sb.append(String.format("║ Producto Nombre    ║ %-38s ║\n", producto.getNommbre()));
        sb.append("╠════════════════════╬════════════════════════════════════════╣\n");

        // Información del pedido (asumiendo que pedido tiene un getId())
        sb.append(String.format("║ Pedido ID          ║ %-38d ║\n", pedido.getIdPedido()));

        // Línea inferior de la tabla
        sb.append("╚════════════════════╩════════════════════════════════════════╝");

        return sb.toString();
    }
}

package com.egg.entidades;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;

    @Column(name = "cantidad_en_stock")
    private Integer cantidadEnStock;

    @Column(name = "codigo_producto")
    private String codigoProducto;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "dimensiones")
    private String dimensiones;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio_proveedor")
    private Integer precioProveedor;

    @Column(name = "precio_venta")
    private Integer precioVenta;

    @Column(name = "proveedor")
    private String Proveedor;

    @ManyToOne
    @JoinColumn(name = "id_gama")
    private GamaProducto gamaProducto;

    @OneToMany(mappedBy = "producto")
    private List<DetallePedido> detallePedidos;

    public Producto() {
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public List<DetallePedido> getDetallePedidos() {
        return detallePedidos;
    }

    public void setDetallePedidos(List<DetallePedido> detallePedidos) {
        this.detallePedidos = detallePedidos;
    }

    public GamaProducto getGamaProducto() {
        return gamaProducto;
    }

    public void setGamaProducto(GamaProducto gamaProducto) {
        this.gamaProducto = gamaProducto;
    }

    public String getProveedor() {
        return Proveedor;
    }

    public void setProveedor(String proveedor) {
        Proveedor = proveedor;
    }

    public Integer getPrecioProveedor() {
        return precioProveedor;
    }

    public void setPrecioProveedor(Integer precioProveedor) {
        this.precioProveedor = precioProveedor;
    }

    public Integer getCantidadEnStock() {
        return cantidadEnStock;
    }

    public void setCantidadEnStock(Integer cantidadEnStock) {
        this.cantidadEnStock = cantidadEnStock;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public String getNommbre() {
        return nombre;
    }

    public void setNommbre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Integer precioVenta) {
        this.precioVenta = precioVenta;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("╔════════════════════╦════════════════════════════════════════╗\n");

        sb.append(String.format("║ ID Producto        ║ %-38d ║\n", idProducto));
        sb.append("╠════════════════════╬════════════════════════════════════════╣\n");
        sb.append(String.format("║ Cantidad en Stock  ║ %-38d ║\n", cantidadEnStock));
        sb.append("╠════════════════════╬════════════════════════════════════════╣\n");
        sb.append(String.format("║ Codigo Producto    ║ %-38s ║\n", codigoProducto));
        sb.append("╠════════════════════╬════════════════════════════════════════╣\n");
        sb.append(String.format("║ Descripcion        ║ %-38s ║\n", descripcion));
        sb.append("╠════════════════════╬════════════════════════════════════════╣\n");
        sb.append(String.format("║ Dimensiones        ║ %-38s ║\n", dimensiones));
        sb.append("╠════════════════════╬════════════════════════════════════════╣\n");
        sb.append(String.format("║ Nombre             ║ %-38s ║\n", nombre));
        sb.append("╠════════════════════╬════════════════════════════════════════╣\n");
        sb.append(String.format("║ Precio Proveedor   ║ %-38s ║\n", precioProveedor));
        sb.append("╠════════════════════╬════════════════════════════════════════╣\n");
        sb.append(String.format("║ Proveedor          ║ %-38s ║\n", Proveedor));
        sb.append("╠════════════════════╬════════════════════════════════════════╣\n");

        sb.append(String.format("║ Gama Producto ID   ║ %-38d ║\n", gamaProducto.getIdGama()));
        sb.append(String.format("║ Gama Producto      ║ %-38s ║\n", gamaProducto.getDescripcionTexto()));
        sb.append("╚════════════════════╩════════════════════════════════════════╝");


        return sb.toString();
    }
}

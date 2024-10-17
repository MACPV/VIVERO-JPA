package com.egg.entidades;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "gama_producto")
public class GamaProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gama")
    private Integer idGama;

    @Column(name = "descripcion_html",length = 255)
    private String descripcionHtml;

    @Column(name = "descripcion_texto", length = 255)
    private String descripcionTexto;

    @Column(name = "gama",length = 255)
    private String gama;

    @Column(name = "imagen",length = 255)
    private String imagen;

    @OneToMany(mappedBy = "gamaProducto")
    private List<Producto> productos;

    public GamaProducto() {
    }

    public Integer getIdGama() {
        return idGama;
    }

    public void setIdGama(Integer idGama) {
        this.idGama = idGama;
    }

    public String getDescripcionTexto() {
        return descripcionTexto;
    }

    public void setDescripcionTexto(String descripcionTexto) {
        this.descripcionTexto = descripcionTexto;
    }

    public String getDescripcionHtml() {
        return descripcionHtml;
    }

    public void setDescripcionHtml(String descripcionHtml) {
        this.descripcionHtml = descripcionHtml;
    }

    public String getGama() {
        return gama;
    }

    public void setGama(String gama) {
        this.gama = gama;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}

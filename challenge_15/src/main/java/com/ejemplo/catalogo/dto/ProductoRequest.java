package com.ejemplo.catalogo.dto;


import java.math.BigDecimal;
import java.util.List;

/**
 * DTO para la creación o actualización de productos.
 * Representa la estructura que el cliente debe enviar en el body de la petición.
 */
public class ProductoRequest {
    private String nombre;
    private Long categoriaId;
    private BigDecimal precio;
    private boolean disponible;
    private List<String> tags;

    // Getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Long getCategoriaId() { return categoriaId; }
    public void setCategoriaId(Long categoriaId) { this.categoriaId = categoriaId; }

    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }

    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    public List<String> getTags() { return tags; }
    public void setTags(List<String> tags) { this.tags = tags; }
}

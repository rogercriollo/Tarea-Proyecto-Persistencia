package Clases;

public class Producto {
    String id;
    String categoria;
    String nombre;

    public Producto(String id, String categoria, String nombre) {
        this.id = id;
        this.categoria = categoria;
        this.nombre = nombre;
    }
    public Producto() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "Id_Producto='" + id + '\'' +
                ", Categoria='" + categoria + '\'' +
                ", Nombre='" + nombre + '\'' +
                '}';
    }
}


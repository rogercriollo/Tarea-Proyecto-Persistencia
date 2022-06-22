package Clases;

public class CuentaBancaria {
    String nroCuenta;
    String nombre;
    String tipo;

    public CuentaBancaria(String nroCuenta, String nombre, String tipo) {
        this.nroCuenta = nroCuenta;
        this.nombre = nombre;
        this.tipo = tipo;
    }
    public CuentaBancaria() {
    }

    public String getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(String nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "nombre='" + nroCuenta + '\'' +
                ", ruc='" + nombre + '\'' +
                ", ciudad='" + tipo + '\'' +
                '}';
    }
}
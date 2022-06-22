package Logica.producto;


import Archivos.producto.ProductoBinario;
import Clases.Producto;

import java.io.IOException;
import java.util.ArrayList;

public class ControlProductoBin {
    ProductoBinario objProductoBinario = new ProductoBinario();
    public boolean ValidarId(Producto objProducto) throws IOException, ClassNotFoundException {
        ArrayList<Producto> arrayProducto = ListarProductos();
        // Valida si el codigo es correcto
        if (objProducto.getId().length() > 6){
            // Agregar al archivo texto
            arrayProducto.add(objProducto);
            return objProductoBinario.GrabarProductoBinario(objProducto);
        }
        return false;
    }
    public ArrayList<Producto> ListarProductos() throws IOException, ClassNotFoundException {
        return objProductoBinario.ImportarProductoBinario();
    }
}

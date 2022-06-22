package Logica.producto;


import Archivos.producto.ProductoTXT;
import Clases.Producto;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ControlProductoTxt {
    ProductoTXT objProductoTXT = new ProductoTXT();
    public boolean  ValidarId(Producto objProducto) throws IOException {
        // Valida si el codigo es correcto
        if (objProducto.getId().length() > 6){
            // Agregar al archivo texto
            return objProductoTXT.AgregarProducto(objProducto);
        }
        return false;
    }
    public ArrayList<Producto> ListarProductos() throws FileNotFoundException {
        ArrayList<Producto> arrayProducto = objProductoTXT.LeerProcducto();
        return arrayProducto;
    }
}

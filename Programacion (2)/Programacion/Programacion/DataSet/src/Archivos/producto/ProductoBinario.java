package Archivos.producto;

import Clases.Producto;

import java.io.*;
import java.util.ArrayList;

public class ProductoBinario {
    File fichero =new File("Producto.dat");
    public boolean GrabarProductoBinario(Producto producto) throws IOException, ClassNotFoundException {
        ArrayList<Producto> arrayProducto = ImportarProductoBinario();

        FileOutputStream outputStream = new FileOutputStream(fichero, false);
        ObjectOutputStream oos = new ObjectOutputStream(outputStream);
        oos.flush();

        arrayProducto.add(producto);

        oos.writeObject(arrayProducto);

        outputStream.close();
        oos.close();
        return true;
    }

    public ArrayList<Producto> ImportarProductoBinario() throws IOException, ClassNotFoundException {
        FileInputStream input = new FileInputStream(fichero);
        ObjectInputStream ois = new ObjectInputStream(input);

        ArrayList<Producto> arrayProducto = (ArrayList<Producto>) ois.readObject();


        ois.close();
        input.close();

        return arrayProducto;
    }
}

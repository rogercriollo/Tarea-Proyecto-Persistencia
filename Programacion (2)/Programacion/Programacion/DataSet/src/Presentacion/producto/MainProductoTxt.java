package Presentacion.producto;

import Clases.Producto;
import Logica.producto.ControlProductoTxt;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class MainProductoTxt {
    ControlProductoTxt objLogProductoTxt = new ControlProductoTxt();
    public static void main(String[] args) throws IOException {
        MainProductoTxt a = new MainProductoTxt();
        a.AgregarProductoTxt();
        a.ListarProductoTxt();
    }
    void menuArchivoTexto() throws IOException {
        Scanner sc = new Scanner(System.in);
        int op = 0;
        while (op < 4){
            System.out.println("Agregar       1");
            System.out.println("Eliminar      2");
            System.out.println("Listar        3");
            System.out.println("Salir         4");
            op = sc.nextInt();
            switch (op){
                case 1: AgregarProductoTxt(); break;
                case 2: EliminarProductoTxt(); break;
                case 3: ListarProductoTxt(); break;
            }
        }
    }
    private void AgregarProductoTxt() throws IOException{
        Producto objCuenta = new Producto();
        objCuenta.setId("156165165");
        objCuenta.setCategoria("Alimentos");
        objCuenta.setNombre("Papitas");
        if (objLogProductoTxt.ValidarId(objCuenta)){
            System.out.println("Producto Agregado");
        } else {
            System.out.printf("Codigo de Producto No Valido");
        }
    }
    private void EliminarProductoTxt() {
    }
    private void ListarProductoTxt() throws FileNotFoundException {
        ArrayList<Producto> ArrayProductos = objLogProductoTxt.ListarProductos();
        for (Producto tmpProducto : ArrayProductos){
            System.out.println(tmpProducto.toString());
        }
    }
}

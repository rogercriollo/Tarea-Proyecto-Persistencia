package Presentacion.producto;

import Clases.Producto;
import Logica.producto.ControlProductoBin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainProductoBin {
    private static ControlProductoBin objLogProductoBin;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        objLogProductoBin = new ControlProductoBin();
        AgregarProductoBin();
        ListarProductoBin();
    }
    void menuArchivoBin() throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        int op = 0;
        while (op < 4){
            System.out.println("Agregar       1");
            System.out.println("Eliminar      2");
            System.out.println("Listar        3");
            System.out.println("Salir         4");
            op = sc.nextInt();
            switch (op){
                case 1: AgregarProductoBin(); break;
                case 2: EliminarProductoBin(); break;
                case 3: ListarProductoBin(); break;
            }
        }
    }
    private static void AgregarProductoBin() throws IOException, ClassNotFoundException {
        Producto objCuenta = new Producto();
        objCuenta.setId("156165165");
        objCuenta.setCategoria("Alimentos");
        objCuenta.setNombre("Papitas");



        if (objLogProductoBin.ValidarId(objCuenta)){
            System.out.println("Cliente Agregado");
        } else {
            System.out.printf("Codigo Cliente No Valido");
        }
    }
    private void EliminarProductoBin() {
    }
    private static void ListarProductoBin() throws IOException, ClassNotFoundException {
        ArrayList<Producto> ArrayProducto = objLogProductoBin.ListarProductos();
        for (Producto tmpProducto : ArrayProducto){
            System.out.println(tmpProducto.toString());
        }
    }
}

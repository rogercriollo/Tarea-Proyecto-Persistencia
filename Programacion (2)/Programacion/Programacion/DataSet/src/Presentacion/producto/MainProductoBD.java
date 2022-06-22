package Presentacion.producto;

import Clases.Producto;
import Logica.producto.ControlProductoDB;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainProductoBD {
    private static ControlProductoDB objLogProductoDB;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        objLogProductoDB = new ControlProductoDB();
        AgregarProductoBD();
        ListarProductoBD();

    }
    void menuArchivoBin() throws IOException, ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);
        int op = 0;
        while (op < 4){
            System.out.println("Agregar       1");
            System.out.println("Eliminar      2");
            System.out.println("Listar        3");
            System.out.println("Salir         4");
            op = sc.nextInt();
            switch (op){
                case 1: AgregarProductoBD(); break;
                case 2: EliminarProductoBD(); break;
                case 3: ListarProductoBD(); break;
            }
        }
    }
    private static void AgregarProductoBD()throws SQLException, ClassNotFoundException{
        ArrayList<Producto> productos = new ArrayList<Producto>();
        //Entrada de datos
        productos.add(new Producto("156165165", "Alimentos", "Papitas"));
        productos.add(new Producto("615116511", "Alimentos", "Comelon"));
        productos.add(new Producto("486841515", "Ropa", "Victoria"));

        objLogProductoDB.InsertarProductos(productos);
    }
    private static void EliminarProductoBD(){

    }
    private static void ListarProductoBD()throws SQLException, ClassNotFoundException{
        ArrayList<Producto> Productos = objLogProductoDB.RecuperarProductos();
        for (Producto OBJProducto : Productos)
            System.out.println(OBJProducto.toString());

    }
}

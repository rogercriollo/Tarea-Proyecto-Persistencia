package Presentacion;
import Clases.Cliente;
import Logica.LogClienteBin;
import Logica.LogClienteTxt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * @author
 * Fecha: 15-06-2022
 */

public class ArchivoBin {
    private static LogClienteBin objLogClienteBin;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        objLogClienteBin = new LogClienteBin();
        AgregarClienteBin();
        ListarClienteBin();
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
                case 1: AgregarClienteBin(); break;
                case 2: EliminarClienteBin(); break;
                case 3: ListarClienteBin(); break;
            }
        }
    }
    private static void AgregarClienteBin() throws IOException, ClassNotFoundException {
        Cliente objCliente = new Cliente();
        objCliente.setId(5);
        objCliente.setNombre("Rosa Romero");
        objCliente.setFecNac("15062022");


        if (objLogClienteBin.ValidarId(objCliente)){
            System.out.println("Cliente Agregado");
        } else {
            System.out.printf("Codigo Cliente No Valido");
        }
    }
    private void EliminarClienteBin() {
    }
    private static void ListarClienteBin() throws IOException, ClassNotFoundException {
        ArrayList<Cliente> ArrayClientes = objLogClienteBin.ListarClientes();
        for (Cliente tmpCliente : ArrayClientes){
            System.out.println(tmpCliente.toString());
        }
    }
}

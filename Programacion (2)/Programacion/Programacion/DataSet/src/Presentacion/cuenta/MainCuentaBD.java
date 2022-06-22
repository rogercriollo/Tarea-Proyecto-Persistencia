package Presentacion.cuenta;

import Clases.CuentaBancaria;
import Logica.cuenta.ControlCuentaDB;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainCuentaBD {
    private static ControlCuentaDB objLogCuentaDB;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        objLogCuentaDB = new ControlCuentaDB();
        AgregarCuentaBD();
        ListarCuentaBD();

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
                case 1: AgregarCuentaBD(); break;
                case 2: EliminarCuentaBD(); break;
                case 3: ListarCuentaBD(); break;
            }
        }
    }
    private static void AgregarCuentaBD()throws SQLException, ClassNotFoundException{
        ArrayList<CuentaBancaria> cuentaBancarias = new ArrayList<CuentaBancaria>();
        //Entrada de datos
        cuentaBancarias.add(new CuentaBancaria("2205615651", "Maria", "Ahorros"));
        cuentaBancarias.add(new CuentaBancaria("2106565465", "Luz", "Ahorros"));
        cuentaBancarias.add(new CuentaBancaria("1975686334", "Jose", "Ahorros"));

        objLogCuentaDB.InsertarCuentas(cuentaBancarias);
    }
    private static void EliminarCuentaBD(){

    }
    private static void ListarCuentaBD()throws SQLException, ClassNotFoundException{
        ArrayList<CuentaBancaria> cuentaBancarias = objLogCuentaDB.RecuperarCuentas();
        for (CuentaBancaria OBJCuentaBancaria : cuentaBancarias)
            System.out.println(OBJCuentaBancaria.toString());

    }
}

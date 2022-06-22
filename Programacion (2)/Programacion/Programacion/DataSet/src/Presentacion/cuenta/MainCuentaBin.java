package Presentacion.cuenta;


import Clases.CuentaBancaria;
import Logica.cuenta.ControlCuentaBin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainCuentaBin {
    private static ControlCuentaBin objLogCuentaBin;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        objLogCuentaBin = new ControlCuentaBin();
        AgregarCuentaBin();
        ListarCuentaBin();
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
                case 1: AgregarCuentaBin(); break;
                case 2: EliminarCuentaBin(); break;
                case 3: ListarCuentaBin(); break;
            }
        }
    }
    private static void AgregarCuentaBin() throws IOException, ClassNotFoundException {
        CuentaBancaria objCuenta = new CuentaBancaria();
        objCuenta.setNroCuenta("2205615651");
        objCuenta.setNombre("Maria");
        objCuenta.setTipo("Ahorros");


        if (objLogCuentaBin.ValidarId(objCuenta)){
            System.out.println("Cliente Agregado");
        } else {
            System.out.printf("Codigo Cliente No Valido");
        }
    }
    private void EliminarCuentaBin() {
    }
    private static void ListarCuentaBin() throws IOException, ClassNotFoundException {
        ArrayList<CuentaBancaria> ArrayCuenta = objLogCuentaBin.ListarEmpresa();
        for (CuentaBancaria tmpCuenta : ArrayCuenta){
            System.out.println(tmpCuenta.toString());
        }
    }
}

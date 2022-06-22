package Presentacion.cuenta;

import Clases.CuentaBancaria;
import Logica.cuenta.ControlCuentaTxt;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainCuentaTxt {
    ControlCuentaTxt objLogCuentaTxt = new ControlCuentaTxt();
    public static void main(String[] args) throws IOException {
        MainCuentaTxt a = new MainCuentaTxt();
        a.AgregarCuentaTxt();
        a.ListarCuentaTxt();
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
                case 1: AgregarCuentaTxt(); break;
                case 2: EliminarCuentaTxt(); break;
                case 3: ListarCuentaTxt(); break;
            }
        }
    }
    private void AgregarCuentaTxt() throws IOException{
        CuentaBancaria objCuenta = new CuentaBancaria();
        objCuenta.setNroCuenta("2205615651");
        objCuenta.setNombre("Maria");
        objCuenta.setTipo("Ahorros");
        if (objLogCuentaTxt.Validar(objCuenta)){
            System.out.println("Cuenta Agregada");
        } else {
            System.out.printf("Codigo Cuenta No Valida ");
        }
    }
    private void EliminarCuentaTxt() {
    }
    private void ListarCuentaTxt() throws FileNotFoundException {
        ArrayList<CuentaBancaria> ArrayCuenta = objLogCuentaTxt.ListarEmpresas();
        for (CuentaBancaria tmpCluenBancaria : ArrayCuenta){
            System.out.println(tmpCluenBancaria.toString());
        }
    }
}

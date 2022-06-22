package Archivos.cuenta;

import Clases.CuentaBancaria;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CuentaTXT {
    File f = new File("Empresa.txt");

    public boolean AgregarCuenta(CuentaBancaria objCuentaBancaria) throws IOException {

        FileWriter fw = new FileWriter(f,true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.flush();

        bw.append(objCuentaBancaria.getNroCuenta()+",");
        bw.append(objCuentaBancaria.getNombre()  +",");
        bw.append(objCuentaBancaria.getTipo() + "\n");

        bw.close();
        fw.close();

        return true;
    }

    public ArrayList<CuentaBancaria> LeerCuenta() throws FileNotFoundException {
        ArrayList<CuentaBancaria> ArrayClientes = new ArrayList<>();
        StringTokenizer st;

        Scanner entrada = new Scanner("");
        String sCadena;
        try {
            entrada = new Scanner(f);
            while (entrada.hasNext()) {
                sCadena = entrada.nextLine();
                if(sCadena == null) {break;}
                st = new StringTokenizer(sCadena, ",");
                while (st.hasMoreTokens()) {
                    CuentaBancaria Objtmp = new CuentaBancaria(st.nextToken(), st.nextToken(), st.nextToken());
                    ArrayClientes.add(Objtmp);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            entrada.close();
        }
        return ArrayClientes;
    }
}

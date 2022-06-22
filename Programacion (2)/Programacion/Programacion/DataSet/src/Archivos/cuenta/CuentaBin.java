package Archivos.cuenta;

import Clases.CuentaBancaria;

import java.io.*;
import java.util.ArrayList;

public class CuentaBin {
    File fichero =new File("Empresa.dat");
    public boolean GrabarCuentaBinario(CuentaBancaria cuentaBancaria) throws FileNotFoundException, IOException, ClassNotFoundException {
        ArrayList<CuentaBancaria> arrayCuentaBancaria = ImportarCuenta();

        FileOutputStream outputStream = new FileOutputStream(fichero, false);
        ObjectOutputStream oos = new ObjectOutputStream(outputStream);
        oos.flush();

        arrayCuentaBancaria.add(cuentaBancaria);

        oos.writeObject(arrayCuentaBancaria);

        outputStream.close();
        oos.close();  // Se cierra al terminar.
        return true;
    }

    public ArrayList<CuentaBancaria> ImportarCuenta() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream input = new FileInputStream(fichero);
        ObjectInputStream ois = new ObjectInputStream(input);

        ArrayList<CuentaBancaria> arrayCuentaBancaria = (ArrayList<CuentaBancaria>) ois.readObject();


        ois.close();
        input.close();

        return arrayCuentaBancaria;
    }
}

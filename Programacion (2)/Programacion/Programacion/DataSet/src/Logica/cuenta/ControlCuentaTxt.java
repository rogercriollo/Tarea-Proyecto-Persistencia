package Logica.cuenta;

import Archivos.cuenta.CuentaTXT;
import Clases.CuentaBancaria;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ControlCuentaTxt {
    CuentaTXT objCuentaTXT = new CuentaTXT();
    public boolean Validar(CuentaBancaria objCuentaBancaria) throws IOException {
        // Valida si el codigo es correcto
        if (objCuentaBancaria.getNombre().length() == 13){
            // Agregar al archivo texto
            return objCuentaTXT.AgregarCuenta(objCuentaBancaria);
        }
        return false;
    }
    public ArrayList<CuentaBancaria> ListarEmpresas() throws FileNotFoundException {
        ArrayList<CuentaBancaria> arrayCuentaBancaria = objCuentaTXT.LeerCuenta();
        return arrayCuentaBancaria;
    }
}

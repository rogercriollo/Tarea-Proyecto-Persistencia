package Logica.cuenta;

import Archivos.cuenta.CuentaBin;
import Clases.CuentaBancaria;

import java.io.IOException;
import java.util.ArrayList;

public class ControlCuentaBin {
    CuentaBin objCuentaBinario = new CuentaBin();
    public boolean ValidarId(CuentaBancaria objCliente) throws IOException, ClassNotFoundException {
        ArrayList<CuentaBancaria> ArrayClientes = ListarEmpresa();
        // Valida si el codigo es correcto
        if (objCliente.getNombre().length() == 13){
            ArrayClientes.add(objCliente);
            return objCuentaBinario.GrabarCuentaBinario(objCliente);
        }
        return false;
    }
    public ArrayList<CuentaBancaria> ListarEmpresa() throws IOException, ClassNotFoundException {
        return objCuentaBinario.ImportarCuenta();
    }
}

package Logica.cuenta;

import Archivos.cuenta.CuentaBD;
import Clases.CuentaBancaria;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControlCuentaDB {
    CuentaBD objCuentaBD = new CuentaBD();

    public void InsertarCuentas(ArrayList<CuentaBancaria> arrayCuentaBancarias) throws SQLException, ClassNotFoundException {

        for (CuentaBancaria objEmpresa : arrayCuentaBancarias)
            objCuentaBD.InsertarCuenta(objEmpresa);



    }
    public ArrayList<CuentaBancaria> RecuperarCuentas() throws SQLException, ClassNotFoundException {
        ArrayList<CuentaBancaria> ArrayClientes = new ArrayList<>();
        ResultSet rs = objCuentaBD.RecuperarCuenta();
        ResultSetMetaData rm = rs.getMetaData();
        //Recupera los campos de la tabla
        int columnCount = rm.getColumnCount();
        ArrayList<String> columnas = new ArrayList<>();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = rm.getColumnName(i);
            columnas.add(columnName);
        }
        String nombre = null;
        String ruc = null;
        String ciudad = null;
        //Envia los datos a la Clase
        while (rs.next()) {

            for (String columnName : columnas) {
                String value = rs.getString(columnName);
                if (columnName.equals("nombre")) {
                    nombre = value;
                }
                if (columnName.equals("ruc")) {
                    ruc = value;
                }
                if (columnName.equals("ciudad")) {
                    ciudad = value;
                }
            }
            CuentaBancaria objAux = new CuentaBancaria(nombre, ruc, ciudad);
            ArrayClientes.add(objAux);
        }
        return ArrayClientes;
    }
}


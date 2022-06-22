package Logica.producto;


import Archivos.producto.ProductoDB;
import Clases.Producto;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControlProductoDB {
    ProductoDB objProductoDB = new ProductoDB();

    public void InsertarProductos(ArrayList<Producto> arrayProductos) throws SQLException, ClassNotFoundException {
        for (Producto objAvion : arrayProductos)
            objProductoDB.InsertarAvionDB(objAvion);
    }

    public ArrayList<Producto> RecuperarProductos() throws SQLException, ClassNotFoundException {
        ArrayList<Producto> arrayAviones = new ArrayList<>();
        ResultSet rs = objProductoDB.RecuperarAvion();
        ResultSetMetaData rm = rs.getMetaData();
        //Recupera los campos de la tabla
        int columnCount = rm.getColumnCount();
        ArrayList<String> columnas = new ArrayList<>();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = rm.getColumnName(i);
            columnas.add(columnName);
        }
        String matricula = null;
        String modelo = null;
        String nombre = null;
        //Envia los datos a la Clase
        while (rs.next()) {

            for (String columnName : columnas) {
                String value = rs.getString(columnName);
                if (columnName.equals("matricula")) {
                    matricula = value;
                }
                if (columnName.equals("controlador")) {
                    modelo = value;
                }
                if (columnName.equals("nombre")) {
                    nombre = value;
                }
            }
            Producto objAux = new Producto(matricula, modelo, nombre);
            arrayAviones.add(objAux);
        }
        return arrayAviones;
    }
}

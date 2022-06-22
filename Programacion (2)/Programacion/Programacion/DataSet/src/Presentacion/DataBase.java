package Presentacion;
import Clases.Cliente;
import Logica.LogClienteDB;

import java.sql.SQLException;
import java.util.ArrayList;
public class DataBase {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ArrayList<Cliente> ArrayClientes = new ArrayList<Cliente>();
        LogClienteDB objLogClienteDB = new LogClienteDB();

        //Entrada de datos
        ArrayClientes.add(new Cliente(1, "Erika Masa", "15062022"));
        ArrayClientes.add(new Cliente(2, "Manuel Romero", "15062022"));
        ArrayClientes.add(new Cliente(3, "Roger Criollo", "15062022"));
        ArrayClientes.add(new Cliente(3, "Danilo  Jaramillo", "15062022"));

        objLogClienteDB.InsertarClientes(ArrayClientes);
        ArrayClientes = new ArrayList<Cliente>();
        ArrayClientes.removeAll(ArrayClientes);

        objLogClienteDB.RecuperarClientes(ArrayClientes);
        for (Cliente OBJCliente: ArrayClientes)
            System.out.println(objLogClienteDB.toString());

    }
}

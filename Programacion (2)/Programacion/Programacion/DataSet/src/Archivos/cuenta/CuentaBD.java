package Archivos.cuenta;

import Archivos.DATConexion;
import Clases.CuentaBancaria;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CuentaBD {
    DATConexion con = new DATConexion();
    ResultSet rs;
    PreparedStatement ps = null;


    public boolean InsertarCuenta(CuentaBancaria objCuentaBancaria) {
        String sql = "INSERT INTO Cuenta (nrocuenta, nombre, tipo) "
                + "VALUES (?,?,?)";
        try {
            ps = con.AbrirConexion().prepareStatement(sql);
            ps.setString(1, objCuentaBancaria.getNroCuenta());
            ps.setString(2, objCuentaBancaria.getNombre());
            ps.setString(3, objCuentaBancaria.getTipo());
            ps.execute();
            //System.out.println("Empresa insertado");
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.CerrarConexion();
            } catch (SQLException e) {
                System.err.println(3);
            }
        }
    }


    public ResultSet RecuperarCuenta() throws ClassNotFoundException, SQLException {
        java.sql.Statement st = con.AbrirConexion().createStatement();
        String sentencia = "SELECT * FROM Empresa";
        rs = st.executeQuery(sentencia);
        return rs;
    }
}

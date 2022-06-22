package Archivos.producto;

import Archivos.DATConexion;
import Clases.Producto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductoDB {
    DATConexion con = new DATConexion();
    ResultSet rs;
    PreparedStatement ps = null;


    public boolean InsertarAvionDB(Producto objProducto) {
        String sql = "INSERT INTO Producto (id, categoria, nombre) "
                + "VALUES (?,?,?)";
        try {
            ps = con.AbrirConexion().prepareStatement(sql);
            ps.setString(1, objProducto.getId());
            ps.setString(2, objProducto.getCategoria());
            ps.setString(3, objProducto.getNombre());
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


    public ResultSet RecuperarAvion() throws ClassNotFoundException, SQLException {
        java.sql.Statement st = con.AbrirConexion().createStatement();
        String sentencia = "SELECT * FROM Avion";
        rs = st.executeQuery(sentencia);
        return rs;
    }
}

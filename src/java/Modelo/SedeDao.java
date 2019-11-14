package Modelo;

import java.sql.*;
import java.util.ArrayList;

public class SedeDao extends Conexion.CConexion{
    
    public ArrayList<Sede> ListarSede() {

        ArrayList<Sede> lista = new ArrayList<>();

        String sql = "SELECT * FROM SEDE";

        try {
            Connection con = conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Sede oSede= new Sede(
                        rs.getInt("IDSEDE"),
                        rs.getString("NOMBRE"));

                lista.add(oSede);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

}

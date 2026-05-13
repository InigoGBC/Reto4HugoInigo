package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.LineaFactura;
import util.ConexionBD;

public class LineaFacturaDAO implements GenericDAO<LineaFactura>{

	@Override
	public boolean insertar(LineaFactura objeto) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public List<LineaFactura> obtenerTodosPorID() {
		List<LineaFactura> lista = new ArrayList<>();
        String sql = "SELECT * FROM lineafactura where id=?";
        
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
        		ResultSet rs = ps.executeQuery()) {
        	
            while (rs.next()) {
                lista.add(mapear(rs));
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener todos: " + e.getMessage());
        }

        return lista;
	}

	@Override
	public List<LineaFactura> obtenerTodos() {
		List<LineaFactura> lista = new ArrayList<>();
        String sql = "SELECT * FROM lineafactura";

        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(mapear(rs));
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener todos: " + e.getMessage());
        }

        return lista;
	}

	@Override
	public LineaFactura obtenerPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean actualizar(LineaFactura objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	 private LineaFactura mapear(ResultSet rs) throws SQLException {
	        LineaFactura objeto = new LineaFactura();
	        objeto.setId(rs.getInt("id"));
	        objeto.setIdFactura(rs.getInt("id_factura"));
	        objeto.setIdProducto(rs.getInt("id_producto"));
	        objeto.setCantidad(rs.getInt("cantidad"));
	        objeto.setPrecioUnitario(rs.getDouble("precio_unitario"));
	        objeto.setImporte(rs.getDouble("importe"));
	       
	        return objeto;
	    }

}

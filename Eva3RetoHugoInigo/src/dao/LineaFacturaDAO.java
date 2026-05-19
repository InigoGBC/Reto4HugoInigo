package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.LineaFactura;
import util.ConexionBD;

public class LineaFacturaDAO implements GenericDAO<LineaFactura>{

	@Override
	public boolean insertar(LineaFactura objeto) {
		String sql = "INSERT INTO lineafactura (id_factura,id_producto,cantidad,precio_unitario,importe) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, objeto.getIdFactura());
            ps.setInt(2, objeto.getIdProducto());
            ps.setInt(3, objeto.getCantidad());
            ps.setDouble(4, objeto.getPrecioUnitario());
            ps.setDouble(5, objeto.getImporte());
            int filas = ps.executeUpdate();

            if (filas > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    objeto.setId(rs.getInt(1));
                }
                return true;
            }

        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }

        return false;
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
		 String sql = "SELECT id,id_factura,id_producto,cantidad,precio_unitario,importe FROM lineafactura WHERE id = ?";

	        try (Connection con = ConexionBD.getConnection();
	             PreparedStatement ps = con.prepareStatement(sql)) {

	            ps.setInt(1, id);
	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	                return mapear(rs);
	            }

	        } catch (SQLException e) {
	            System.out.println("Error al obtener por id: " + e.getMessage());
	        }

	        return null;
	}

	@Override
	public boolean actualizar(LineaFactura objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(int id) {
		String sql = "DELETE FROM lineafactura WHERE id = ?";

        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }

        return false;
	}
	public LineaFactura copiar(int id,int idfac) {
		 String sql = "SELECT id_factura,id_producto,cantidad,precio_unitario,importe FROM lineafactura WHERE id = ?";

	        try (Connection con = ConexionBD.getConnection();
	             PreparedStatement ps = con.prepareStatement(sql)) {

	            ps.setInt(1, id);
	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	                return mapearCopiar(rs, idfac);
	            }

	        } catch (SQLException e) {
	            System.out.println("Error al obtener por id: " + e.getMessage());
	        }

	        return null;
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
	 private LineaFactura mapearCopiar(ResultSet rss,int idfac) throws SQLException {
	        LineaFactura objeto = new LineaFactura();
	        objeto.setIdFactura(idfac);
	        objeto.setIdProducto(rss.getInt("id_producto"));
	        objeto.setCantidad(rss.getInt("cantidad"));
	        objeto.setPrecioUnitario(rss.getDouble("precio_unitario"));
	        objeto.setImporte(rss.getDouble("importe"));
	        return objeto;
	    }

}

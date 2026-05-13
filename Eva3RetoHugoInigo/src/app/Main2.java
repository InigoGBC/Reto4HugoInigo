package app;

import dao.FacturaDAO;
import dao.LineaFacturaDAO;
import modelo.LineaFactura;

public class Main2 {

	public static void main(String[] args) {
		// Muestra una factura por id junto con todas sus líneas de factura. HUGO ***
		FacturaDAO facturaDAO = new FacturaDAO();
		LineaFacturaDAO lineafacturaDAO = new LineaFacturaDAO();
		System.out.println(facturaDAO.obtenerPorId(1));
		for (LineaFactura lf : lineafacturaDAO.obtenerTodos()) {
			if (lf.getIdFactura() == 1)
			System.out.println(lf);
		}
		
		
		
		
		
		
		
		

	}

}

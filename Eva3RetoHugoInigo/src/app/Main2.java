package app;

import dao.FacturaDAO;

public class Main2 {

	public static void main(String[] args) {
		// Muestra una factura por id junto con todas sus líneas de factura. HUGO ***
		FacturaDAO facturaDAO = new FacturaDAO();
		System.out.println(facturaDAO.obtenerPorId(1));
		
		
		
		
		
		
		
		
		

	}

}

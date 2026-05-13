package app;

import java.util.Locale;
import java.util.Scanner;

import dao.FacturaDAO;
import dao.LineaFacturaDAO;
import modelo.LineaFactura;

public class Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		// Muestra una factura por id junto con todas sus líneas de factura. HUGO ***
		FacturaDAO facturaDAO = new FacturaDAO();
		LineaFacturaDAO lineafacturaDAO = new LineaFacturaDAO();
		System.out.println("Ej1\nEscribe la id de una factura: ");
		String idej1st = sc.nextLine();
		int idej1 = Integer.parseInt(idej1st);
		System.out.println(facturaDAO.obtenerPorId(idej1));
		for (LineaFactura lf : lineafacturaDAO.obtenerTodos()) {
			if (lf.getIdFactura() == idej1)
			System.out.println(lf);
		}
		
		
		
		
		
		
		
		

	}

}

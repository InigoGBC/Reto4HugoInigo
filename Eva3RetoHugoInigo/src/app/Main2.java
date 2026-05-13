package app;

import java.util.Locale;
import java.util.Scanner;

import dao.FacturaDAO;
import dao.LineaFacturaDAO;
import modelo.LineaFactura;

public class Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		
		FacturaDAO facturaDAO = new FacturaDAO();
		LineaFacturaDAO lineafacturaDAO = new LineaFacturaDAO();
		
		// Ej 3 Muestra una factura por id junto con todas sus líneas de factura. 
		System.out.println("Ej3\nEscribe la id de una factura: ");
		String idej1st = sc.nextLine();
		int idej1 = Integer.parseInt(idej1st);
		System.out.println(facturaDAO.obtenerPorId(idej1));
		for (LineaFactura lf : lineafacturaDAO.obtenerTodos()) {
			if (lf.getIdFactura() == idej1)
			System.out.println(lf);
		}
		//Fin Ej 3
		//-----------------------------------------------------------------------
		/* Ej 4 Muestra todas las facturas de un mes, pide el número del mes y 
		   calcula el total facturado ese mes. */
		
		
		
		
		
		//Fin Ej 4
		
		
		
		
		
		

	}

}

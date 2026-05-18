package app;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import dao.ClienteDAO;
import dao.EmpleadoDAO;
import dao.FacturaDAO;
import dao.LineaFacturaDAO;
import dao.ProductoDAO;
import modelo.Cliente;
import modelo.Empleado;
import modelo.Factura;
import modelo.LineaFactura;
import modelo.Producto;

public class Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		FacturaDAO facturaDAO = new FacturaDAO();
		LineaFacturaDAO lineafacturaDAO = new LineaFacturaDAO();
		ClienteDAO clienteDAO = new ClienteDAO();
		EmpleadoDAO empleadoDAO = new EmpleadoDAO();	
		ProductoDAO productoDAO = new ProductoDAO();
		/*
		//Ej 3
		System.out.println("Ej1:");
		for (Cliente p : clienteDAO.obtenerTodos()) {
			System.out.println(p);
		}
		System.out.println("Dime el id de un cliente: ");
		int idcliente = (Integer.parseInt(sc.nextLine()));
		for (Factura lf : facturaDAO.obtenerTodos()) {
			if (lf.getIdCliente() == idcliente)
			System.out.println(lf);
		}
		System.out.println("\n");
		
		
		System.out.println("Ej2: ");
		for (Empleado p : empleadoDAO.obtenerTodos()) {
			System.out.println(p);
		}
		System.out.println("Dime el id de un empleado: ");
		int idempleado = (Integer.parseInt(sc.nextLine()));
		for (Factura lf : facturaDAO.obtenerTodos()) {
			if (lf.getIdEmpleado() == idempleado)
			System.out.println(lf);
		}
		System.out.println("\n");
		
		// Ej 3 Muestra una factura por id junto con todas sus líneas de factura. 
		System.out.println("Ej3");
		for (Factura lf : facturaDAO.obtenerTodos()) {
			System.out.println(lf);
		}
		System.out.println("Escribe la id de la factura para mostrar sus lineas de factura: ");
		String idej1st = sc.nextLine();
		int idej1 = Integer.parseInt(idej1st);
		for (LineaFactura lf : lineafacturaDAO.obtenerTodos()) {
			if (lf.getIdFactura() == idej1)
			System.out.println(lf);
		}
		System.out.println("\n");
		System.out.println("Ej 4 \nEscribe un mes de factura: ");
		double calc = 0;
		String idej4st = sc.nextLine();
		int idej4 = Integer.parseInt(idej4st);
		for (Factura lf : facturaDAO.obtenerTodos()) {
			LocalDate fech = lf.getFecha();
			if (fech.getMonthValue() == idej4) {
			System.out.println(lf);
			calc+=lf.getTotal();
			}
		}
		System.out.println("En total se ha facturado "+calc+"€ este mes");
		System.out.println("\n");
		//Fin Ej 4
		//Ej 5
		System.out.println("Ej 5 \nEscribe una fecha: ");
		String datest = sc.nextLine();
		LocalDate dateej4 = LocalDate.parse(datest);
		for (Factura lf : facturaDAO.obtenerTodos()) {
			LocalDate fech = lf.getFecha();
			if (fech.equals(dateej4)) {
			System.out.println(lf);
			}
		}
		System.out.println("\n");
		//Fin Ej 5
		//Ej 7
		System.out.println("Ej 7 \nEscribe un nombre: ");
		String nuevonombre = sc.nextLine();
		System.out.println("Escribe un precio base: ");
		String nvoprecost = sc.nextLine();
		Double nuevoprecio = Double.parseDouble(nvoprecost);
		System.out.println("Escribe un stock base: ");
		String nvostockst = sc.nextLine();
		int nuevostock = Integer.parseInt(nvostockst);
		boolean esta = false;
		for (Producto prod : productoDAO.obtenerTodos()) {
			if (prod.getNombre().equals(nuevonombre)) {
				esta=true;
			}
		}
		if (!esta) {
			System.out.println(productoDAO.insertar(new Producto(nuevonombre,nuevoprecio,nuevostock)));
		} else {
			System.out.println("El producto ya esta");
		}
		System.out.println("\n");
		//Fin ej 7
		//Ej 8
		System.out.println("Ej 8 \nEscribe la id del producto: ");
		String idej8st = sc.nextLine();
		int idej8 = Integer.parseInt(idej8st);
		System.out.println("Escribe el nuevo precio: ");
		String precioej8st = sc.nextLine();
		Double nuevoprecioej8 = Double.parseDouble(precioej8st);
		System.out.println(productoDAO.actualizarPrecio(idej8, nuevoprecioej8));
		System.out.println("\n");
		// Fin 8
		*/
		/*
		//Ej 9
		System.out.println("Ej 10");
		System.out.println("Clientes:");
		for (Cliente cli : clienteDAO.obtenerTodos()) {
			System.out.println(cli);
		}
		System.out.println("Escribe el id de un cliente: ");
		String idej9st = sc.nextLine();
		int idej9cli = Integer.parseInt(idej9st);
		System.out.println("Empleados:");
		for (Empleado emp : empleadoDAO.obtenerTodos()) {
			System.out.println(emp);
		}
		System.out.println("Escribe el id de un empleado: ");
		idej9st = sc.nextLine();
		int idej9emp = Integer.parseInt(idej9st);
		System.out.println("Productos disponibles:");
		for (Producto prod : productoDAO.obtenerTodos()) {
			System.out.println(prod);
		}
		int idej9prod=0;
		ArrayList<Integer> productos = new ArrayList<Integer>();
		double subtotal = 0;
		do {
			System.out.println("Escribe el id del producto que quieres añadir: ");
			idej9st = sc.nextLine();
			idej9prod = Integer.parseInt(idej9st);
			if ( idej9prod != 0) {
				productos.add(idej9prod);
				
			}
				
		} while (idej9prod!=0);
		for (Integer integer : productos) {
			Producto prod = productoDAO.obtenerPorId(integer);
			subtotal+=prod.getPrecio();
		}
		double iva = subtotal*0.21;
		System.out.println(subtotal);
		double total = subtotal+iva;
		Factura nuevafac = new Factura(LocalDate.now(), idej9cli, idej9emp, subtotal, iva, total);
		System.out.println(facturaDAO.insertar(nuevafac));
		System.out.println(nuevafac);
	
		for (Integer integer : productos) {
			Producto prod = productoDAO.obtenerPorId(integer);
			LineaFactura lf = new LineaFactura(nuevafac.getId(), integer, 1, prod.getPrecio(), prod.getPrecio()*1);

			System.out.println(lineafacturaDAO.insertar(lf));
			System.out.println(lf);
		}
		
		
		*/
		/*
		//Ej 10
		int idfac10 = 0;
		System.out.println("Ej 10");
		for (Producto prod : productoDAO.obtenerTodos()) {
			System.out.println(prod);
		}
		System.out.println("Escribe el id del producto: ");
		String idej10st = sc.nextLine();
		int idej10 = Integer.parseInt(idej10st);
		for (LineaFactura ln : lineafacturaDAO.obtenerTodos()) {
			if (ln.getIdProducto()==idej10) {
				idfac10 = ln.getIdFactura();
				for (Factura fac : facturaDAO.obtenerTodos()) {
					if (fac.getId()==idfac10) {
						System.out.println(fac);
					}
					
				}
				
			}
			
		}
		//Ej11
		System.out.println("\n");
		System.out.println("Ej11");
		boolean esta = false;
		for (Producto prod : productoDAO.obtenerTodos()) {
			System.out.println(prod);
		}
		System.out.println("Escribe el id del producto: ");
		String idej11st = sc.nextLine();
		int idej11 = Integer.parseInt(idej11st);
		for (LineaFactura lf : lineafacturaDAO.obtenerTodos()) {
			if (lf.getIdProducto()==idej11) {
				esta = true;
			}
		}
		if (esta) {
			System.out.println("Este producto tiene lineas de factura");
		} else {
			System.out.println(productoDAO.eliminar(idej11));
		}
		
		//Ej 13
		System.out.println("\n");
		*/
		/*
		System.out.println("Ej13");
		System.out.println("Escribe el id de una factura: ");
		String idej13st = sc.nextLine();
		int idej13 = Integer.parseInt(idej13st);
		Factura copiafac = facturaDAO.copiar(idej13);
		System.out.println("Se han insertado: ");
		System.out.println(facturaDAO.insertar(copiafac));
		System.out.println(copiafac);
		for (LineaFactura lf : lineafacturaDAO.obtenerTodos()) {
			if (lf.getIdFactura()==idej13) {
				LineaFactura copia = lineafacturaDAO.copiar(lf.getId(), copiafac.getId());
				System.out.println(lineafacturaDAO.insertar(copia));
				System.out.println(copia);
			}
		}
		*/
		//Ej 15
		System.out.println("\n");
		System.out.println("Ej15");
		System.out.println("Escribe el numero de mes de la factura: ");
		double totfac = 0;
		String num15sc = sc.nextLine();
		int num15 = Integer.parseInt(num15sc);
		for (Empleado emp : empleadoDAO.obtenerTodos()) {
			System.out.println(emp);
			totfac = 0;
			for (Factura fac : facturaDAO.obtenerTodos()) {
				if (fac.getIdEmpleado()==emp.getId() && fac.getFecha().getMonthValue()==num15) {
					System.out.println(fac);
					totfac+=fac.getTotal();
				}
			}
			System.out.println("Este empleado ha facturado este mes en total: "+totfac+"\n");
		}
		
		
		

	}

}

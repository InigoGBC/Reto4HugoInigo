package app;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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

public class Ejercicios {

	public static void ejercicio1() {
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		ClienteDAO clienteDAO = new ClienteDAO();
		FacturaDAO facturaDAO = new FacturaDAO();
		System.out.println("Ej1:");
		for (Cliente p : clienteDAO.obtenerTodos()) {
			System.out.println(p);
		}
		System.out.println("Dime el id de un cliente: ");
		int idcliente = (Integer.parseInt(sc.nextLine()));
		System.out.println("Facturas: ");
		for (Factura lf : facturaDAO.obtenerTodos()) {
			if (lf.getIdCliente() == idcliente)
				System.out.println(lf);
		}
	}

	public static void ejercicio2() {
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		EmpleadoDAO empleadoDAO = new EmpleadoDAO();
		FacturaDAO facturaDAO = new FacturaDAO();
		for (Empleado p : empleadoDAO.obtenerTodos()) {
			System.out.println(p);
		}
		System.out.println("Dime el id de un empleado: ");
		int idempleado = (Integer.parseInt(sc.nextLine()));
		System.out.println("Facturas:");
		for (Factura lf : facturaDAO.obtenerTodos()) {
			if (lf.getIdEmpleado() == idempleado)
				System.out.println(lf);
		}
	}

	public static void ejercicio3() {
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		FacturaDAO facturaDAO = new FacturaDAO();
		LineaFacturaDAO lineafacturaDAO = new LineaFacturaDAO();
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
	}

	public static void ejercicio4() {
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		FacturaDAO facturaDAO = new FacturaDAO();
		System.out.println("Ej 4 \nEscribe un mes de factura: ");
		double calc = 0;
		String idej4st = sc.nextLine();
		int idej4 = Integer.parseInt(idej4st);
		for (Factura lf : facturaDAO.obtenerTodos()) {
			LocalDate fech = lf.getFecha();
			if (fech.getMonthValue() == idej4) {
				System.out.println(lf);
				calc += lf.getTotal();
			}
		}
		System.out.println("En total se ha facturado " + calc + "€ este mes");
	}

	public static void ejercicio5() {
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		FacturaDAO facturaDAO = new FacturaDAO();
		System.out.println("Ej 5 \nEscribe una fecha: ");
		String datest = sc.nextLine();
		LocalDate dateej4 = LocalDate.parse(datest);
		System.out.println("Facturas: ");
		for (Factura lf : facturaDAO.obtenerTodos()) {
			LocalDate fech = lf.getFecha();
			if (fech.equals(dateej4)) {
				System.out.println(lf);
			}
		}
	}

	public static void ejercicio6() {
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente c = new Cliente("12345675Z", "Pepe Carrera", "Plaza Mozart 3");
		System.out.println(clienteDAO.insertar(c));
		System.out.println("Insertado");
	}

	public static void ejercicio7() {
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		ProductoDAO productoDAO = new ProductoDAO();
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
				esta = true;
			}
		}
		if (!esta) {
			System.out.println(productoDAO.insertar(new Producto(nuevonombre, nuevoprecio, nuevostock)));
		} else {
			System.out.println("Producto insertado");
		}
		System.out.println("\n");
	}

	public static void ejercicio8() {
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		ProductoDAO productoDAO = new ProductoDAO();
		System.out.println("Ej 8 \nEscribe la id del producto: ");
		String idej8st = sc.nextLine();
		int idej8 = Integer.parseInt(idej8st);
		System.out.println("Escribe el nuevo precio: ");
		String precioej8st = sc.nextLine();
		Double nuevoprecioej8 = Double.parseDouble(precioej8st);
		System.out.println(productoDAO.actualizarPrecio(idej8, nuevoprecioej8));
		System.out.println("\n");
	}

	public static void ejercicio9() {
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		LineaFacturaDAO lineafacturaDAO = new LineaFacturaDAO();
		ProductoDAO productoDAO = new ProductoDAO();
		ClienteDAO clienteDAO = new ClienteDAO();
		EmpleadoDAO empleadoDAO = new EmpleadoDAO();
		FacturaDAO facturaDAO = new FacturaDAO();
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
		int idej9prod = 0;
		ArrayList<Integer> productos = new ArrayList<Integer>();
		double subtotal = 0;
		do {
			System.out.println("Escribe el id del producto que quieres añadir: ");
			idej9st = sc.nextLine();
			idej9prod = Integer.parseInt(idej9st);
			if (idej9prod != 0) {
				productos.add(idej9prod);

			}

		} while (idej9prod != 0);
		for (Integer integer : productos) {
			Producto prod = productoDAO.obtenerPorId(integer);
			subtotal += prod.getPrecio();
		}
		double iva = subtotal * 0.21;
		System.out.println(subtotal);
		double total = subtotal + iva;
		Factura nuevafac = new Factura(LocalDate.now(), idej9cli, idej9emp, subtotal, iva, total);
		System.out.println(facturaDAO.insertar(nuevafac));
		System.out.println(nuevafac);

		for (Integer integer : productos) {
			Producto prod = productoDAO.obtenerPorId(integer);
			LineaFactura lf = new LineaFactura(nuevafac.getId(), integer, 1, prod.getPrecio(), prod.getPrecio() * 1);

			System.out.println(lineafacturaDAO.insertar(lf));
			System.out.println(lf);
		}
	}

	public static void ejercicio10() {
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		ProductoDAO productoDAO = new ProductoDAO();
		LineaFacturaDAO lineafacturaDAO = new LineaFacturaDAO();
		FacturaDAO facturaDAO = new FacturaDAO();
		int idfac10 = 0;
		System.out.println("Ej 10");
		for (Producto prod : productoDAO.obtenerTodos()) {
			System.out.println(prod);
		}
		System.out.println("Escribe el id del producto: ");
		String idej10st = sc.nextLine();
		int idej10 = Integer.parseInt(idej10st);
		for (LineaFactura ln : lineafacturaDAO.obtenerTodos()) {
			if (ln.getIdProducto() == idej10) {
				idfac10 = ln.getIdFactura();
				for (Factura fac : facturaDAO.obtenerTodos()) {
					if (fac.getId() == idfac10) {
						System.out.println(fac);
					}

				}

			}

		}
	}

	public static void ejercicio11() {
		System.out.println("Ej11");
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		ProductoDAO productoDAO = new ProductoDAO();
		LineaFacturaDAO lineafacturaDAO = new LineaFacturaDAO();
		boolean esta = false;
		for (Producto prod : productoDAO.obtenerTodos()) {
			System.out.println(prod);
		}
		System.out.println("Escribe el id del producto: ");
		String idej11st = sc.nextLine();
		int idej11 = Integer.parseInt(idej11st);
		for (LineaFactura lf : lineafacturaDAO.obtenerTodos()) {
			if (lf.getIdProducto() == idej11) {
				esta = true;
			}
		}
		if (esta) {
			System.out.println("Este producto tiene lineas de factura");
		} else {
			System.out.println(productoDAO.eliminar(idej11));
		}

	}

	public static void ejercicio12() {
		ClienteDAO clienteDAO = new ClienteDAO();
		System.out.println("ejercicio 12: ");
		guardarFichero(clienteDAO.obtenerTodos());
		mostrarFichero();

	}

	public static void ejercicio13() {
		System.out.println("Ej13");
		System.out.println("Escribe el id de una factura: ");
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		FacturaDAO facturaDAO = new FacturaDAO();
		LineaFacturaDAO lineafacturaDAO = new LineaFacturaDAO();
		String idej13st = sc.nextLine();
		int idej13 = Integer.parseInt(idej13st);
		Factura copiafac = facturaDAO.copiar(idej13);
		System.out.println("Se han insertado: ");
		System.out.println(facturaDAO.insertar(copiafac));
		System.out.println(copiafac);
		for (LineaFactura lf : lineafacturaDAO.obtenerTodos()) {
			if (lf.getIdFactura() == idej13) {
				LineaFactura copia = lineafacturaDAO.copiar(lf.getId(), copiafac.getId());
				System.out.println(lineafacturaDAO.insertar(copia));
				System.out.println(copia);
			}
		}
	}

	public static void ejercicio14() {

	}

	public static void ejercicio15() {
		System.out.println("Ej15");
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		EmpleadoDAO empleadoDAO = new EmpleadoDAO();
		FacturaDAO facturaDAO = new FacturaDAO();
		System.out.println("Escribe el numero de mes de la factura: ");
		double totfac = 0;
		String num15sc = sc.nextLine();
		int num15 = Integer.parseInt(num15sc);
		for (Empleado emp : empleadoDAO.obtenerTodos()) {
			System.out.println(emp);
			totfac = 0;
			for (Factura fac : facturaDAO.obtenerTodos()) {
				if (fac.getIdEmpleado() == emp.getId() && fac.getFecha().getMonthValue() == num15) {
					System.out.println(fac);
					totfac += fac.getTotal();
				}
			}
			System.out.println("Este empleado ha facturado este mes en total: " + totfac + "\n");
		}

	}

	public static void guardarFichero(List<Cliente> clientes) {

		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("clientes.dat"))) {
			out.writeObject(clientes);
			System.out.println("clientes guardados.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void mostrarFichero() {

		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("clientes.dat"))) {

			ArrayList<Cliente> clientes = (ArrayList<Cliente>) in.readObject();

			for (Cliente c : clientes) {
				System.out.println(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

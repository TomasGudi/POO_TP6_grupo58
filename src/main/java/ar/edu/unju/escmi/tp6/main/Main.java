package ar.edu.unju.escmi.tp6.main;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.escmi.tp6.collections.CollectionCliente;
import ar.edu.unju.escmi.tp6.collections.CollectionFactura;
import ar.edu.unju.escmi.tp6.collections.CollectionProducto;
import ar.edu.unju.escmi.tp6.collections.CollectionStock;
import ar.edu.unju.escmi.tp6.collections.CollectionTarjetaCredito;
import ar.edu.unju.escmi.tp6.dominio.Cliente;
import ar.edu.unju.escmi.tp6.dominio.Factura;
import ar.edu.unju.escmi.tp6.dominio.Producto;
import ar.edu.unju.escmi.tp6.dominio.Stock;

public class Main {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		LocalDate FECHA_LIMITE = LocalDate.of(LocalDate.now().getYear(), 12, 22);
		if (FECHA_LIMITE.isBefore(LocalDate.now())) {
			System.out.println("Ya finalizo la promoción");
			return;
		} else {
			CollectionTarjetaCredito.precargarTarjetas();
			CollectionCliente.precargarClientes();
			CollectionProducto.precargarProductos();
			CollectionStock.precargarStocks();
			long dniCliente;
			int opcion = 0;
			do {
				System.out.println("\n====== Menu Principal =====");
				System.out.println("1- Realizar una venta");
				System.out.println("2- Revisar compras realizadas por el cliente (debe ingresar el DNI del cliente)");
				System.out.println("3- Mostrar lista de los electrodomésticos");
				System.out.println("4- Consultar stock");
				System.out.println("5- Revisar creditos de un cliente (debe ingresar el DNI del cliente)");
				System.out.println("6- Salir");

				System.out.println("Ingrese su opcion: ");
				opcion = scanner.nextInt();

				switch (opcion) {
				case 1:
					/*
					 * System.out.print("Ingresa DNI del cliente: "); dniCliente =
					 * scanner.nextLong(); System.out.print("Ingresa nombre del producto: "); String
					 * nombreProducto = scanner.next(); sistema.realizarVenta(dniCliente,
					 * nombreProducto); 
					 */
					break;
				case 2:
					System.out.print("Ingresa DNI del cliente: ");
					dniCliente = scanner.nextLong();
					Cliente aux = CollectionCliente.buscarCliente(dniCliente);
					if (aux != null) {
						List<Factura> compras = aux.consultarCompras();
						if (compras != null && !compras.isEmpty()) {
							System.out.println("Compras realizadas por " + aux.getNombre() + ":");
							for (Factura factura : compras) {
								System.out.println(factura);
							}
						} else {
							System.out.println("El cliente no tiene compras registradas.");
						}
					} else {
						System.out.println("Cliente con DNI " + dniCliente + " no encontrado.");
					}
					break;
				case 3:
					for (Stock st : CollectionStock.stocks) {
						if(st.getCantidad() > 0) {
							System.out.println(st.getProducto());
						}
					}
					break;
				case 4:
					for (Stock st : CollectionStock.stocks) {
						System.out.println("Producto: " + st.getProducto().getDescripcion() + "Stock: " + st.getCantidad());
					}
					break;
				case 5:
					/*
					 * System.out.print("Ingrese el DNI del cliente: "); String dni =
					 * scanner.nextLine(); Cliente cliente =
					 * sistemaCreditos.buscarClientePorDni(dni); if (cliente != null) {
					 * sistemaCreditos.revisarCreditosCliente(cliente); } else {
					 System.out.println("Cliente no encontrado."); } break; 
					 */
				case 6:
					 System.out.println("Saliendo del sistema..."); 
					 break; 
				default:
					 System.out.println("Opción no válida, por favor seleccione nuevamente.");
					 break;
				}

			} while (opcion != 6);
			scanner.close();

		}
	}
}

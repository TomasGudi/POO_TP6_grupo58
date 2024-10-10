package ar.edu.unju.escmi.tp6.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp6.collections.CollectionPromocionAhoraTreinta;

public class PromocionAhoraTreinta {

	// Fecha límite de la promoción
	private static final LocalDate FECHA_LIMITE_PROMOCION = LocalDate.of(LocalDate.now().getYear(), 12, 22);

	// Límites de precios
	private static final double LIMITE_GENERAL = 1_500_000.0;
	private static final double LIMITE_TELEFONO = 800_000.0;

	private long nroFactura = 0;

	public void realizarCompraAhora30(TarjetaCredito tarjetaCredito, Stock stock) {

		LocalDate hoy = LocalDate.now();
		double creditoDisponible = tarjetaCredito.getLimiteCompra();
		double precio = stock.getProducto().getPrecioUnitario();

		//filtros
		if (hoy.isAfter(FECHA_LIMITE_PROMOCION)) {
			System.out.println("Ya finalizo la promoción");
			return;
		}
		if (stock.getCantidad() == 0) {
			System.out.println("No existe stock del producto");
			return;
		}
		if (creditoDisponible < precio) {
			System.out.println("El credito disponible es menor al precio del producto");
			return;
		}
		if (!(stock.getProducto().getDescripcion().equalsIgnoreCase("televisor")
				|| stock.getProducto().getDescripcion().equalsIgnoreCase("lavarropa")
				|| stock.getProducto().getDescripcion().equalsIgnoreCase("heladera")
				|| stock.getProducto().getDescripcion().equalsIgnoreCase("celular")
				|| (stock.getProducto().getDescripcion().toLowerCase().startsWith("aire acondicionado")
						&& stock.getProducto().getConsumo() > 3000))) {
			System.out.println("El producto no pertenece a la promocion");
			return;
		}
		if (stock.getProducto().getPrecioUnitario() > LIMITE_GENERAL) {
			System.out.println("El limite del producto es de: $" + LIMITE_GENERAL);
			return;
		}
		if (stock.getProducto().getDescripcion().equalsIgnoreCase("celular")
				&& stock.getProducto().getPrecioUnitario() > LIMITE_TELEFONO) {
			System.out.println("El limite en celulares es de: $" + LIMITE_TELEFONO);
			return;
		}

		// registrar
		nroFactura++;
		Cliente cliente = tarjetaCredito.getCliente();
		List<Detalle> detalles = new ArrayList<>();
		Factura factura = new Factura(hoy, nroFactura, cliente, detalles);
		List<Cuota> cuotas = new ArrayList<>();
		Credito credito = new Credito(tarjetaCredito, factura, cuotas);

		CollectionPromocionAhoraTreinta.agregarCredito(credito);

		System.out.println("Compra registrada exitosamente con factura nro: " + nroFactura);
	}
}

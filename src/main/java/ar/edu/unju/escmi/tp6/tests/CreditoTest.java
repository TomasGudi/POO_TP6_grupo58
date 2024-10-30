package ar.edu.unju.escmi.tp6.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ar.edu.unju.escmi.tp6.dominio.*;

import java.time.LocalDate;
import java.util.List;

public class CreditoTest {

    private Credito credito;
    private Factura factura;

    @BeforeEach
    public void setUp() {
        credito = new Credito();
        factura = new Factura();
    }

    @Test
    public void testMontoTotalCreditoNoSupereLimite() {
        credito.setMontoTotal(1600000);
        assertTrue(credito.getMontoTotal() <= 1500000, "El monto total del crédito no debe superar 1.500.000$");
    }

    @Test
    public void testSumaDetallesIgualTotalFactura() {
        Detalle detalle1 = new Detalle(2, 30000);
        Detalle detalle2 = new Detalle(1, 50000);
        factura.agregarDetalle(detalle1);
        factura.agregarDetalle(detalle2);
        double totalCalculado = factura.calcularTotal();
        assertEquals(factura.getTotal(), totalCalculado, "La suma de los importes de los detalles debe ser igual al total de la factura");
    }

    @Test
    public void testMontoCompraNoSupereLimiteNiTarjeta() {
        TarjetaCredito tarjeta = new TarjetaCredito(123456789L, LocalDate.of(2025, 12, 31), 1200000);
        credito.setMontoTotal(1600000);
        assertTrue(credito.getMontoTotal() <= 1500000, "El monto total no debe superar 1.500.000$");
        assertTrue(credito.getMontoTotal() <= tarjeta.getLimiteCompra(), "El monto total no debe superar el límite disponible en la tarjeta");
    }
}

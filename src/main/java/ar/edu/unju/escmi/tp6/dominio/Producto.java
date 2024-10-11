package ar.edu.unju.escmi.tp6.dominio;

public class Producto {

	private long codigo;
    private String descripcion;
    private double precioUnitario;
    private String origenFabricacion;
    private int consumo;

    public Producto() {
    	
    }

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public String getOrigenFabricacion() {
		return origenFabricacion;
	}

	public void setOrigenFabricacion(String origenFabricacion) {
		this.origenFabricacion = origenFabricacion;
	}

	public int getConsumo() {
		return consumo;
	}

	public void setConsumo(int consumo) {
		this.consumo = consumo;
	}

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", descripcion=" + descripcion + ", precioUnitario=" + precioUnitario
				+ ", origenFabricacion=" + origenFabricacion + ", consumo=" + consumo + "]";
	}

	public Producto(long codigo, String descripcion, double precioUnitario, String origenFabricacion, int consumo) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.origenFabricacion = origenFabricacion;
		this.consumo = consumo;
	}

   
}

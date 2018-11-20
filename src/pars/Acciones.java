package pars;

public class Acciones {
	
	private String nombre, tipo;
	private int cantidad, precio;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	public void mostrar() {
		System.out.println("Nombre: "+nombre);
		System.out.println("Operaciones:");
		System.out.println("Compras: ");
	}
	
	
	
	
	

}

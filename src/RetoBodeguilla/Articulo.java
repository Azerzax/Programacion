package RetoBodeguilla;

public abstract class Articulo {
	
	private String codigo;
	private String nombre;
	private String marca;
	private Double precio;
	private int stock;
	
	public Articulo(String codigo, String nombre,String marca, Double precio, int stock) {
		
		this.codigo=codigo;
		this.nombre=nombre;
		this.precio=precio;
		this.stock=stock;
		this.marca=marca;
	}

	
	
	public String getMarca() {
		return marca;
	}



	public void setMarca(String marca) {
		this.marca = marca;
	}



	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public void aumentarStock(int valor) {
		this.stock+=valor;
	}
	
	public void disminuirStock(int valor) {
		this.stock-=valor;
	}
	
	public abstract void verCaracteristicas();
	
	public abstract boolean saludable();
	
	public boolean equivalentes(Articulo art) {
		boolean equi=false;
		
		return equi;
	}
}

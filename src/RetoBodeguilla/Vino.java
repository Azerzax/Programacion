package RetoBodeguilla;

public class Vino extends Articulo{
	
	private String color;
	private String origen;
	private int anio;
	private String uva;
	private int alcohol;

	public Vino(String codigo, String nombre,String marca, Double precio, int stock, String color, String origen, int anio, String uva,int alcohol){		
		super(codigo, nombre,marca, precio, stock);
		this.color=color;
		this.origen=origen;
		this.anio=anio;
		this.uva=uva;
		this.alcohol=alcohol;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getUva() {
		return uva;
	}

	public void setUva(String uva) {
		this.uva = uva;
	}
	
		
	public int getAlcohol() {
		return alcohol;
	}

	public void setAlcohol(int alcohol) {
		this.alcohol = alcohol;
	}

	public String getCodigo() {
		return super.getCodigo();
	}

	public void setCodigo(String codigo) {
		super.setCodigo(codigo);;
	}

	public String getNombre() {
		return super.getNombre();
	}

	public void setNombre(String nombre) {
		super.setNombre(nombre);
	}

	public Double getPrecio() {
		return super.getPrecio();
	}

	public void setPrecio(Double precio) {
		super.setPrecio(precio);
	}

	public int getStock() {
		return super.getStock();
	}

	public void setStock(int stock) {
		super.setStock(stock);;
	}
	
	public void muyAlcoholico() {
		if(this.alcohol>6) {
			this.setPrecio((this.getPrecio()*1.05));
		}
	}

	@Override
	public void verCaracteristicas() {
		// TODO Auto-generated method stub
		
		System.out.println("\r\n---------------------------\r\n"
				+ "Codigo: "+getCodigo()+"\r\n"
				+ "Nombre: "+getNombre()+"\r\n"
				+ "Marca: "+getMarca()+"\r\n"
				+ "Stock---> "+getStock()+"\r\n"
				+ "Origen---> "+getOrigen()+"\r\n"
				+ "Año---> "+getAnio()+"\r\n"
				+ "Uva---> "+getUva()+"\r\n"
				+ "Alcohol---> "+getAlcohol()+"\r\n"
				+ "Precio: "+getPrecio()+"€ \r\n");
	}

	@Override
	public boolean saludable() {
		// TODO Auto-generated method stub
		if(this.origen.equalsIgnoreCase("rioja")) {
			return true;
		}else {
			return false;
		}
	}

}

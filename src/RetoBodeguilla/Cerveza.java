package RetoBodeguilla;

import java.util.Arrays;

public class Cerveza extends Articulo {
	
	private String origen;
	private String[] cereales;
	private int alcohol;
	

	public Cerveza(String codigo, String nombre,String marca, Double precio, int stock, String origen, String[] cereales,int alcohol) {

		super(codigo, nombre,marca, precio, stock);
		this.origen = origen;
		this.cereales = cereales;
		this.alcohol = alcohol;
	}
	
	
	public String getOrigen() {
		return origen;
	}


	public void setOrigen(String origen) {
		this.origen = origen;
	}


	public String[] getCereales() {
		return cereales;
	}


	public void setCereales(String[] cereales) {
		this.cereales = cereales;
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
		String cerealesS=Arrays.toString(getCereales()).replace("[", "").replace("]", "");
		
		System.out.println("\r\n---------------------------\r\n"
				+ "Codigo: "+getCodigo()+"\r\n"
				+ "Nombre: "+getNombre()+"\r\n"
				+ "Marca: "+getMarca()+"\r\n"
				+ "Stock---> "+getStock()+"\r\n"
				+ "Origen---> "+getOrigen()+"\r\n"
				+ "Cereales---> "+cerealesS+"\r\n"
				+ "Alcohol---> "+getAlcohol()+"\r\n"
				+ "Precio: "+getPrecio()+"€ \r\n");
	}

	
	@Override
	public boolean saludable() {
		// TODO Auto-generated method stub
		if(this.origen.equalsIgnoreCase("belgium")) {
			return true;
		}else {
			return false;
		}
	}

}

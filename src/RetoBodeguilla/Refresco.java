package RetoBodeguilla;

public class Refresco extends Articulo {
	
	private String sabor;
	private boolean zumo;
	private boolean gas;
	private int azucar;

	public Refresco(String codigo, String nombre, String marca, Double precio, int stock, String sabor, boolean zumo, boolean gas, int azucar) {
		super(codigo, nombre,marca,precio, stock);
		this.sabor=sabor;
		this.zumo=zumo;
		this.gas=gas;
		this.azucar=azucar;
	}
		


	public String getSabor() {
		return sabor;
	}


	public void setSabor(String sabor) {
		this.sabor = sabor;
	}


	public boolean isZumo() {
		return zumo;
	}


	public void setZumo(boolean zumo) {
		this.zumo = zumo;
	}


	public boolean isGas() {
		return gas;
	}


	public void setGas(boolean gas) {
		this.gas = gas;
	}


	public int getAzucar() {
		return azucar;
	}


	public void setAzucar(int azucar) {
		this.azucar = azucar;
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
	
	
	@Override
	public void verCaracteristicas() {
		// TODO Auto-generated method stub
		String tipo;
		String gas;
		
		if(isGas()==true) {
			gas="Si";
		}else {
			gas="No";
		}
		
		if(isZumo()==true) {
			tipo="Zumo";
		}else {
			tipo="Refresco";
		}
		
		System.out.println("\r\n---------------------------\r\n"
				+ "Codigo: "+getCodigo()+"\r\n"
				+ "Nombre: "+getNombre()+"\r\n"
				+ "Marca: "+getMarca()+"\r\n"
				+ "Stock---> "+getStock()+"\r\n"
				+ "Sabor---> "+getSabor()+"\r\n"
				+ "Tipo---> "+tipo+"\r\n"
				+ "Gas---> "+gas+"\r\n"
				+ "Azucar---> "+getAzucar()+"\r\n"
				+ "Precio: "+getPrecio()+"€ \r\n");
	}

	
	@Override
	public boolean saludable() {
		// TODO Auto-generated method stub
		if(this.azucar<25) {
			return true;
		}else {
			return false;
		}
		
	}

}


package RetoBodeguilla;

import java.util.*;
import java.io.*;
public class ListaArticulos {

	private ArrayList<Articulo> lista = new ArrayList<Articulo>();
	
	
	public ArrayList<Articulo> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Articulo> lista) {
		this.lista = lista;
	}
	
	Articulo articulopointer;
	
	public ListaArticulos() {
		try {
			BufferedReader reader = new BufferedReader (new FileReader(new File("E:\\DAW\\Programacion\\JavaEclipse\\KlaseAriketakClassAbstract\\src\\RetoBodeguilla\\articulos")));
			String readline;
			String[] data;
			
			readline = reader.readLine();
			
			while(readline != null) {
				data = readline.split("::");
				
				data[0].substring(0, 4);
				
				
				switch (data[0].substring(0, 4)){
				case "FRES": {
					lista.add(new Refresco(data[0], data[1], data[2],Double.parseDouble(data[3]),
							Integer.parseInt(data[4]), data[5], Boolean.parseBoolean(data[6]),
							Boolean.parseBoolean(data[7]), Integer.parseInt(data[8])));
				} break;
				
				case "WINE": {
					lista.add(new Vino(data[0], data[1], data[2], Double.parseDouble(data[3]),
							Integer.parseInt(data[4]), data[5], data[6], 
							Integer.parseInt(data[7]), data[8], Integer.parseInt(data[9])));
				} break;
				
				case "BEER": {
					lista.add(new Cerveza(data[0], data[1], data[2], Double.parseDouble(data[3]), 
							Integer.parseInt(data[4]), data[5], data[6].split(","), 
							(int)Math.round(Double.parseDouble((data[7])))));
				} break;
				
				}
				readline = reader.readLine();		
				
			}
			
		}
		catch(Exception e) {
			System.out.println("Errore bat egon da kargatzerako orduan");
			System.out.println(e.getMessage());
		}
	}
	
	public String[] Reponer(){
		
		Iterator <Articulo> iteratorArticulo = lista.iterator();
		String [] aReponer = new String[50];
		Articulo articuloTemp;
		int i = 0;
		
		
		while (iteratorArticulo.hasNext()) {
			articuloTemp = iteratorArticulo.next();
		
			if(articuloTemp.getStock() < 50 && articuloTemp!=null) {
				aReponer[i] = articuloTemp.getCodigo();
				i++;
			}
		}
		return aReponer;
	}
	
	public Articulo masCaro() {
		Iterator <Articulo> iteratorArticulo = lista.iterator();
		Articulo articuloTemp;
		Articulo masCaro = null;
		
		while(iteratorArticulo.hasNext()) {
			articuloTemp = iteratorArticulo.next();
			
			if(masCaro == null || masCaro.getPrecio() < articuloTemp.getPrecio()) {
				masCaro = articuloTemp;
			}
		}
		return masCaro;
	}
	
	public double precio (String codigo) {
		Scanner input = new Scanner(System.in);
		
		Iterator<Articulo> iteratorArticulo = lista.iterator();
		Articulo articuloTemp;
		double precio=0;
		
		while(iteratorArticulo.hasNext()) {
			articuloTemp = iteratorArticulo.next();
		
		if (codigo.contentEquals(articuloTemp.getCodigo())) {
			precio = articuloTemp.getPrecio();
			
		}
		}
		return precio;
	}
}

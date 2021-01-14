package RetoBodeguilla;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class KudeatzaileBodeguilla {
	
	ListaArticulos articulos=new ListaArticulos();
	ArrayList<Articulo> lista =articulos.getLista();
	Factura factura;
	
	public void menuaikusi() {
		System.out.println	("\r\n+==========================GESTION VENTA DE ARTICULOS=========================+\r\n"
				+           "|                                                                             |\r\n"
				+		   	"|	1. Hacer una venta (crear factura)			              |\r\n"
				+ 			"|	2. Listar todos los productos		                              |\r\n"
				+ 			"|	3. Ver los articulos saludables		                              |\r\n"
				+ 			"|	4. Sacar una lista de articulos con precio equivalente		      |\r\n"
				+ 			"|	5. Ver el articulo mas caro 		                              |\r\n"
				+ 			"|	6. Ver los articulos con poco stock 		                      |\r\n"
				+ 			"|	0. Salir		                                              |\r\n"
				+		    "|	············································		              |\r\n"
				+		    "|	Tu opcion (1-6) Salir-0		                                      |\r\n"
				+		    "|	············································		              |\r\n"
				+           "|                                                                             |\r\n"
				+ 			"+=============================================================================+\r\n");
	}
	
	public void venta_1() {
		Scanner entrada=new Scanner(System.in);
		
		int numfact=0, cantidad;
		double totalLinea;
		String nombre, apellido,codigo_cant,codigo;
		String[] data;
		boolean aurkituta=false;
		
		
		System.out.println("Escribe el numero de la factura");
		numfact=Integer.parseInt(entrada.nextLine());
					
		System.out.println("Escribe el nombre del cliente");
		nombre=entrada.nextLine().toUpperCase();
		
		System.out.println("Escribe el apellido del cliente");
		apellido=entrada.nextLine().toUpperCase();
		
		factura=new Factura(numfact, nombre, apellido);
		
		do {
			System.out.println("Escribe el codigo y cantidad del articulo (ejemplo: WIN01->2)");
			codigo_cant=entrada.nextLine();
			if(!codigo_cant.equalsIgnoreCase("end")) {
				data=codigo_cant.split("->");
				cantidad=Integer.parseInt(data[1]);
				codigo=data[0].toUpperCase();
				
				Iterator<Articulo> iarticulo=lista.iterator();
				Articulo articuloTemp;
				
				while(iarticulo.hasNext() && !aurkituta) {
					articuloTemp=iarticulo.next();
					if(codigo.equalsIgnoreCase(articuloTemp.getCodigo()) ) {
						if(articuloTemp.getStock()>=cantidad) {
							totalLinea=articuloTemp.getPrecio()*cantidad;
							articuloTemp.setStock(articuloTemp.getStock()-cantidad);
							factura.aniadirLinea(codigo, cantidad, totalLinea);
						}else {
							System.out.println("No hay stock suficiente de ese articulo.");
						}
						aurkituta=true;
					}
				}
				if(aurkituta==false) {
					System.out.println("No hay ningun articulo con ese codigo");
				}
				aurkituta=false;
				iarticulo=lista.iterator();
			}	
		
		}while(!codigo_cant.equalsIgnoreCase("end"));
		
		
		factura.print();
		
	}
	
	public void todosArticulos_2() {
		Iterator<Articulo> iteradorArticulos=lista.iterator();
		Articulo articuloTemp;
		
		while(iteradorArticulos.hasNext()) {
			articuloTemp=iteradorArticulos.next();
			articuloTemp.verCaracteristicas();
		}	
	}
	
	public void articulosSaludables_3() {
		Iterator<Articulo> iteradorArticulos=lista.iterator();
		Articulo articuloTemp;
		
		while(iteradorArticulos.hasNext()) {
			articuloTemp=iteradorArticulos.next();
			if(articuloTemp.saludable()==true) {
				articuloTemp.verCaracteristicas();
			}
		}
	}
	
	public void precioEquivalente_4() {
		
		Scanner entrada= new Scanner(System.in);
		String codigo;
		double precio;
		Articulo articuloTemp;
		boolean aurkitutaCod=false;
		boolean aurkitutaEqui=false;
		
		System.out.println("Introduce codigo del producto.");
		codigo=entrada.nextLine();
		
		Iterator<Articulo> iteradorArticulos= lista.iterator();
		
		while(iteradorArticulos.hasNext() && !aurkitutaCod) {
			articuloTemp=iteradorArticulos.next();
			if(articuloTemp.getCodigo().equalsIgnoreCase(codigo)) {
				precio=articuloTemp.getPrecio();
				iteradorArticulos= lista.iterator();
				
				while(iteradorArticulos.hasNext()) {
					articuloTemp=iteradorArticulos.next();
					if(articuloTemp.getPrecio()==precio && !articuloTemp.getCodigo().equalsIgnoreCase(codigo)) {
						articuloTemp.verCaracteristicas();
						aurkitutaEqui=true;
					}
				}
				
				aurkitutaCod=true;
			}
		}
		
		if(aurkitutaCod==false) {
			System.out.println("No existe ningun producto con ese codigo.");
		}else {
			if(aurkitutaEqui==false) {
				System.out.println("No existe ningun producto con el mismo precio.");
			}
		}
		
	}
	
	public void masCaro_5() {
		System.out.println("    ARTICULO MAS CARO   ");
		articulos.masCaro().verCaracteristicas();
	}
	
	public void pocoStock_6() {

		Iterator<Articulo> iteratorArticulo= lista.iterator();
		Articulo articuloTemp;
		
		int i =0;
		String[] aReponer;
		aReponer = articulos.Reponer();
		boolean aurkituta=false;
		
		while(aReponer[i]!=null) {
			aurkituta=false;
			while(iteratorArticulo.hasNext() && !aurkituta) {
				articuloTemp=iteratorArticulo.next();
				if(articuloTemp.getCodigo().contentEquals(articulos.Reponer()[i])) {
					articuloTemp.verCaracteristicas();
					aurkituta=true;
				}
			}
			i++;
		}
	}
	
}

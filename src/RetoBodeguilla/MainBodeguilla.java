package RetoBodeguilla;

import java.util.Scanner;

public class MainBodeguilla {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int aukera;
		Scanner entrada=new Scanner(System.in);
		KudeatzaileBodeguilla kude =new KudeatzaileBodeguilla();
		
		do {
			kude.menuaikusi();
			aukera=entrada.nextInt();
			
			switch(aukera) {
				case 1: kude.venta_1();break;
				case 2: kude.todosArticulos_2();break;
				case 3: kude.articulosSaludables_3();break;
				case 4: kude.precioEquivalente_4();break;
				case 5: kude.masCaro_5();break;
				case 6: kude.pocoStock_6(); break;
				default: if(aukera!=0) {
					System.out.println("Aukera desegokia");
				}
			}
			
		}while(aukera!=0);
	
		System.out.println("Programa itxi da");
	}
}

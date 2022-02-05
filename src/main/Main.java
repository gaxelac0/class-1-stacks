package main;

import main.impl.diccionario.DiccionarioMultipleEstatico;
import main.interfaces.DiccionarioMultipleTDA;
import main.utils.DiccionarioUtils;

public class Main {

	public static void main(String[] args) {
		
		
		DiccionarioMultipleTDA dict = 
				new DiccionarioMultipleEstatico();
		
		dict.agregar(1, 1);
		dict.agregar(7, 7);
		dict.agregar(3, 3);
		dict.agregar(1, 0);
		
		
		DiccionarioUtils.mostrarDiccionario(dict);
		dict.eliminarValor(7, 7);
		System.out.println("");
		DiccionarioUtils.mostrarDiccionario(dict);
		
		
	}


}

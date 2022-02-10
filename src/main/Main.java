package main;

import main.impl.diccionario.DiccionarioMultipleDinamico;
import main.utils.DiccionarioUtils;

public class Main {

	public static void main(String[] args) {
		
		DiccionarioMultipleDinamico m = new DiccionarioMultipleDinamico();
		m.agregar(4, 1);
		m.agregar(4, 1);
		m.agregar(4, 2);
		
		m.agregar(7, 3);
		
		m.eliminarValor(4, 1);
		
		DiccionarioUtils.mostrarDiccionario(m);

	}
}

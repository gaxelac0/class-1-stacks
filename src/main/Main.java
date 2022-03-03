package main;

import main.utils.ListaDinamicaUtils;
import main.utils.Nodo;

public class Main {

	public static void main(String[] args) {
				
		Nodo n1 = new Nodo();
		n1.valor = 3;
		
		n1 = ListaDinamicaUtils.agregarAdelante(n1, 2);
		n1 = ListaDinamicaUtils.agregarAdelante(n1, 1);
		
		Nodo n2 = new Nodo();
		n2.valor = 9;
		
		n2 = ListaDinamicaUtils.agregarAdelante(n2, 8);
		n2 = ListaDinamicaUtils.agregarAdelante(n2, 7);
		
		ListaDinamicaUtils.mostrarLista(n1);
		ListaDinamicaUtils.mostrarLista(n2);
		
		Nodo concat = ListaDinamicaUtils.concatenarRecursiva(n1, n2);
		
		ListaDinamicaUtils.mostrarLista(concat);
		
		
	}
}

package main;

import main.exercises.EjercicioArboles;
import main.impl.arbol.ABB;

public class Main {

	public static void main(String[] args) {
		
		ABB arbol = new ABB();
		arbol.agregarElem(52);
		arbol.agregarElem(44);
		arbol.agregarElem(77);
		arbol.agregarElem(3);
		arbol.agregarElem(45);
		arbol.agregarElem(102);
		arbol.agregarElem(96);
				
		System.out.println(EjercicioArboles.cantNodosNivelN(arbol, 3));
	}
}

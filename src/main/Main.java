package main;

import main.exercises.EjercicioArboles;
import main.impl.arbol.ABB;
import main.interfaces.ABBTDA;

public class Main {

	public static void main(String[] args) {
				
		ABBTDA a = new ABB();
		a.agregarElem(7);
		a.agregarElem(8);
		a.agregarElem(4);
		a.agregarElem(9);
		
		
		ABBTDA b = new ABB();
		b.agregarElem(7);
		b.agregarElem(8);
		b.agregarElem(4);
		b.agregarElem(9);
		
		System.out.println(EjercicioArboles.sonIguales(a, b));
	}
}

package main;

import main.exercises.EjercicioArboles;
import main.impl.arbol.ABB;
import main.interfaces.ABBTDA;
import main.utils.ArbolUtils;

public class Main {

	public static void main(String[] args) {
				
		ABBTDA a = new ABB();
		a.agregarElem(46);
		a.agregarElem(25);
		a.agregarElem(73);
		a.agregarElem(36);
		a.agregarElem(90);
		a.agregarElem(62);
		a.agregarElem(12);
		a.agregarElem(30);
		a.agregarElem(70);
		a.agregarElem(54);
		
		
		ABBTDA nw = EjercicioArboles.eliminarHojas(a);
		
		ArbolUtils.inOrder(nw);
	}
}

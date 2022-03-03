package main;

import main.exercises.EjercicioGrafos;
import main.impl.grafo.GrafoDinamico;
import main.interfaces.DiccionarioSimpleTDA;
import main.interfaces.GrafoTDA;
import main.utils.DiccionarioUtils;

public class Main {

	public static void main(String[] args) {
				
		GrafoTDA g = new GrafoDinamico();
		g.agregarVertice(1);
		g.agregarVertice(2);
		g.agregarVertice(3);
		g.agregarVertice(4);
		g.agregarVertice(5);
		
		
		g.agregarArista(1, 2, -4);
		g.agregarArista(1, 3, 1);
		g.agregarArista(1, 4, 1);
		
		g.agregarArista(2, 1, 1);
		g.agregarArista(2, 1, 7);
		
		DiccionarioSimpleTDA d = EjercicioGrafos.convertirDictSimple(g);
		
		DiccionarioUtils.mostrarDiccionario(d);
	}
}

package main;

import main.impl.grafo.GrafoEstatico;
import main.interfaces.GrafoTDA;
import main.utils.GrafoUtils;

public class Main {

	public static void main(String[] args) {
		
		GrafoTDA grafo = new GrafoEstatico();
		grafo.agregarVertice(1);
		grafo.agregarVertice(2);
		grafo.agregarArista(1, 2, -1);
		System.out.println(grafo.existeArista(1, 2));
		System.out.println(grafo.pesoArista(1, 2));
		GrafoUtils.mostrarGrafo(grafo);
		
	}
}

package main.utils;

import main.impl.cola.ColaEstatica;
import main.interfaces.ColaTDA;

public class ColaUtils {
	
	public static void mostrarCola(ColaTDA cola) {
		ColaTDA copia = copiarCola(cola);
		while(!copia.colaVacia()) {
			System.out.print(copia.primero());
			copia.desacolar();
		}
		System.out.println("");
	}
	
	public static ColaTDA copiarCola(ColaTDA cola) {
		ColaTDA copia = new ColaEstatica();
		ColaTDA aux = new ColaEstatica();
		
		while(!cola.colaVacia()) {
			aux.acolar(cola.primero());
			cola.desacolar();
		}
		
		while(!aux.colaVacia()) {
			cola.acolar(aux.primero());
			copia.acolar(aux.primero());
			aux.desacolar();
		}
		
		return copia;
	}

	public static boolean sonIguales(ColaTDA cola, ColaTDA invertida) {
		
		ColaTDA copia = copiarCola(cola);
		ColaTDA copiaInvertida = copiarCola(invertida);
		
		boolean iguales = true;
		while(iguales && !copia.colaVacia() ) {
			iguales = copia.primero()==copiaInvertida.primero();
			copia.desacolar();
			copiaInvertida.desacolar();
		}
		
		
		return (iguales&&copiaInvertida.colaVacia());
	}

}

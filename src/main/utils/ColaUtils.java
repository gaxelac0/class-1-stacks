package main.utils;

import main.impl.cola.ColaDinamica;
import main.impl.cola.ColaEstatica;
import main.interfaces.ColaTDA;

public class ColaUtils {
	
	/**
	 * mostrar cola dinamica
	 * @param cola
	 */
	public static void mostrarCola(ColaDinamica cola) {
		ColaTDA copia = copiarCola(cola);
		while(!copia.colaVacia()) {
			System.out.print(copia.primero());
			copia.desacolar();
		}
		System.out.println("");
	}
	
	/**
	 * copiar cola dinamica
	 * @param cola
	 */
	public static ColaDinamica copiarCola(ColaDinamica cola) {
		ColaDinamica copia = new ColaDinamica();
		ColaDinamica aux = new ColaDinamica();
		
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
	
	/**
	 * mostrar cola estatica
	 * @param cola
	 */
	public static void mostrarCola(ColaEstatica cola) {
		ColaTDA copia = copiarCola(cola);
		while(!copia.colaVacia()) {
			System.out.print(copia.primero());
			copia.desacolar();
		}
		System.out.println("");
	}
	
	/**
	 * copiar cola estatica
	 * @param cola
	 */
	public static ColaEstatica copiarCola(ColaEstatica cola) {
		ColaEstatica copia = new ColaEstatica();
		ColaEstatica aux = new ColaEstatica();
		
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

	public static boolean sonIguales(ColaDinamica cola, ColaDinamica invertida) {
		
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

	public static int cantidadElementos(ColaDinamica cola) {
		
		int n = 0;
		
		ColaTDA copia = copiarCola(cola);
		while(!copia.colaVacia()) {
			n++;
			copia.desacolar();
		}
		
		
		return n;
	}

}

package main.exercises;

import main.impl.cola.ColaDinamica;
import main.impl.cola.ColaEstatica;
import main.impl.pila.PilaEstaticaTopeFinal;
import main.interfaces.ColaTDA;
import main.interfaces.PilaTDA;
import main.utils.ColaUtils;

public class EjercicioColas {
	
	// (4.a) Pasar una Cola a otra
	public static void pasarCola(ColaEstatica cola) {
		
		ColaEstatica nueva = new ColaEstatica();
		ColaEstatica copia = ColaUtils.copiarCola(cola);
		while(!copia.colaVacia()) {
			nueva.acolar(copia.primero());
			copia.desacolar();
		}
		
		ColaUtils.mostrarCola(nueva);
	}
	
	// (4.b) Invertir el contenido de una Cola (pueden usarse Pilas auxiliares)
	public static ColaTDA invertirColaAux(ColaDinamica cola) {
		
		PilaTDA pila = new PilaEstaticaTopeFinal();
		ColaDinamica copia = ColaUtils.copiarCola(cola);
		while(!copia.colaVacia()) {
			pila.apilar(copia.primero());
			copia.desacolar();
		}
		
		
		ColaDinamica aux = new ColaDinamica();
		while(!pila.pilaVacia()) {
			aux.acolar(pila.tope());
			pila.desapilar();
		}
				
		return aux;
	}
	
	// (4.b) Invertir el contenido de una Cola (NO usar Pilas auxiliares)
	public static ColaDinamica invertirCola(ColaDinamica cola) {

		if(cola.colaVacia()) {
			return cola;
		}
		else {
			int x = cola.primero();
			cola.desacolar();
			
			ColaDinamica invertida = invertirCola(cola);
			invertida.acolar(x);
			return invertida;
		}
	}

	// Determinar si el final de la Cola C1 coincide o no con la Cola C2.
	public static boolean esFinalIdentico(ColaDinamica cola, ColaDinamica cola2) {
		ColaDinamica invertida = invertirCola(cola);
		ColaDinamica invertida2 = invertirCola(cola2);
		return (invertida.primero()==invertida2.primero());
		
	}
	
	//Determinar si una Cola es capicúa o no. Para ser capicúa debe cumplir
	// que el primer elemento es igual al último, el segundo igual al penúltimo, etc.
	public static boolean esCapicua(ColaDinamica cola) {
		ColaDinamica invertida = invertirCola(cola);
		return ColaUtils.sonIguales(cola, invertida);
	}
	
	// Determinar si la Cola C1 es la inversa de la Cola C2. Dos Colas serán
	// inversas, si tienen los mismos elementos pero en orden inverso
	public static boolean esInversa(ColaDinamica cola, ColaDinamica cola2) {
		ColaDinamica invertida = invertirCola(cola);
		return ColaUtils.sonIguales(invertida, cola2);
	}
	
	
	// Repartir una Cola C en dos mitades M1 y M2 de elementos consecutivos,
	// respetando el orden. Asumir que la cantidad de elementos de C es par.
	public static void mainRepartirColaEnMitades() {
		
		ColaDinamica cola = new ColaDinamica();
		cola.acolar(0);
		cola.acolar(1);
		cola.acolar(2);
		cola.acolar(3);
		cola.acolar(4);
		cola.acolar(5);
		cola.acolar(6);
		cola.acolar(7);
		cola.acolar(8);
		cola.acolar(9);
		
		// necesito saber cuantos elementos tiene la cola
		int cant = ColaUtils.cantidadElementos(cola);

		// repartir en dos mitades y mostrar
		ColaDinamica m1 = new ColaDinamica();
		ColaDinamica m2 = new ColaDinamica();
		for(int i = 1; i <= cant; i++) {
			
			int p = cola.primero();
			cola.desacolar();
			
			if(i <= cant/2) {
				m1.acolar(p);
			}
			else {
				m2.acolar(p);
			}
		}
		
		ColaUtils.mostrarCola(m1);
		System.out.println("==");
		ColaUtils.mostrarCola(m2);
	}

}

package main.exercises;

import main.impl.cola.ColaEstatica;
import main.impl.pila.PilaEstaticaTopeFinal;
import main.interfaces.ColaTDA;
import main.interfaces.PilaTDA;
import main.utils.ColaUtils;

public class EjercicioColas {
	
	// (4.a) Pasar una Cola a otra
	public static void pasarCola(ColaTDA cola) {
		
		ColaTDA nueva = new ColaEstatica();
		ColaTDA copia = ColaUtils.copiarCola(cola);
		while(!copia.colaVacia()) {
			nueva.acolar(copia.primero());
			copia.desacolar();
		}
		
		ColaUtils.mostrarCola(nueva);
	}
	
	// (4.b) Invertir el contenido de una Cola (pueden usarse Pilas auxiliares)
	public static ColaTDA invertirColaAux(ColaTDA cola) {
		
		PilaTDA pila = new PilaEstaticaTopeFinal();
		ColaTDA copia = ColaUtils.copiarCola(cola);
		while(!copia.colaVacia()) {
			pila.apilar(copia.primero());
			copia.desacolar();
		}
		
		
		ColaTDA aux = new ColaEstatica();
		while(!pila.pilaVacia()) {
			aux.acolar(pila.tope());
			pila.desapilar();
		}
				
		return aux;
	}
	
	// (4.b) Invertir el contenido de una Cola (NO usar Pilas auxiliares)
	public static ColaTDA invertirCola(ColaTDA cola) {

		if(cola.colaVacia()) {
			return cola;
		}
		else {
			int x = cola.primero();
			cola.desacolar();
			
			ColaTDA invertida = invertirCola(cola);
			invertida.acolar(x);
			return invertida;
		}
	}

	// Determinar si el final de la Cola C1 coincide o no con la Cola C2.
	public static boolean esFinalIdentico(ColaTDA cola, ColaTDA cola2) {
		ColaTDA invertida = invertirCola(cola);
		ColaTDA invertida2 = invertirCola(cola2);
		return (invertida.primero()==invertida2.primero());
		
	}
	
	//Determinar si una Cola es capicúa o no. Para ser capicúa debe cumplir
	// que el primer elemento es igual al último, el segundo igual al penúltimo, etc.
	public static boolean esCapicua(ColaTDA cola) {
		ColaTDA invertida = invertirCola(cola);
		return ColaUtils.sonIguales(cola, invertida);
	}
	
	// Determinar si la Cola C1 es la inversa de la Cola C2. Dos Colas serán
	// inversas, si tienen los mismos elementos pero en orden inverso
	public static boolean esInversa(ColaTDA cola, ColaTDA cola2) {
		ColaTDA invertida = invertirCola(cola);
		return ColaUtils.sonIguales(invertida, cola2);
	}

}

package main.exercises;

import main.impl.conjunto.ConjuntoDinamico;
import main.impl.pila.PilaDinamica;
import main.interfaces.PilaTDA;
import main.utils.ConjuntoUtils;
import main.utils.PilaUtils;

public class EjercicioPilas {
		
	public static void promedioPila(PilaTDA pila) {
		
		int avg = 0;
		int qt = 0;
		PilaTDA copia = PilaUtils.copiarPila(pila);
		while(!copia.pilaVacia()) {
			qt++;
			avg += copia.tope();
			copia.desapilar();
		}
		System.out.println("Promedio: " + avg/qt);
	}
	
	// TP3 1)a) Comprobar si una Pila P es capicúa (el elemento del tope es igual al de la base,
	// el segundo igual al anteúltimo, etc.)
	public static void mainEsCapicua() {
		
		PilaTDA pila = new PilaDinamica();
		pila.apilar(1);
		pila.apilar(2);
		pila.apilar(1);
		System.out.println(PilaUtils.esCapicua(pila));
		
		
		PilaTDA pila2 = new PilaDinamica();
		pila2.apilar(1);
		pila2.apilar(2);
		pila2.apilar(3);
		System.out.println(PilaUtils.esCapicua(pila2));
	}
	
	
	/* TP3 1)b)
	 * Eliminar de una Pila P las repeticiones de elementos, dejando un representante
		de cada uno de los elementos presentes originalmente. Se deberá respetar el
		orden original de los elementos, y en el caso de los repetidos se conservará el
		primero que haya ingresado en P.
	 */
	public static void mainEliminarRepetidos() {
		PilaTDA pila = new PilaDinamica();
		pila.apilar(1);
		pila.apilar(2);
		pila.apilar(2);
		pila.apilar(7);
		pila.apilar(6);
		pila.apilar(7);
		PilaUtils.mostrarPila(pila);
		System.out.println("====");
		PilaUtils.mostrarPila(PilaUtils.eliminarDuplicados(pila));
	}
	
	
	/**
	 * TP3 1)d)
	 * Generar el conjunto de elementos que se repiten en una Pila.
	 */
	public static void mainConjuntoElementosRepetidos() {
		
		PilaTDA pila = new PilaDinamica();
		pila.apilar(1);
		pila.apilar(2);
		pila.apilar(2);
		pila.apilar(7);
		pila.apilar(6);
		pila.apilar(7);
		PilaUtils.mostrarPila(pila);
		
		System.out.println("Elementos repetidos: ");
		ConjuntoUtils.mostrarConjunto((ConjuntoDinamico)PilaUtils.obtenerElementosRepetidos(pila));
		
	}

}

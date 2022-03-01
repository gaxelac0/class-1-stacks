package main.exercises;

import main.impl.conjunto.ConjuntoDinamico;
import main.impl.pila.PilaDinamica;
import main.impl.pila.PilaLimitada;
import main.interfaces.ConjuntoTDA;
import main.interfaces.PilaLimitadaTDA;
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
	
	
	/**
	 * Implementación de Pila Limitada
	 * Ejercicio Final
	 * 
	 * (30 p) Queremos un tipo abstracto de datos PilaLimitadaTDA que repre-
			senta una pila de un tamaño limitado. El límite se especifica en el momento
			ele la inicialización. Este TDA debe permitir efectuar las siguie nt es opera-
			ciones:
			• inicializarPila, que genera una pila vacía li sta para ser usada. La pila
			tendrá el tamaño indicado por un número entero positivo pasarlo
			como parámetro.
			• Apilar, que agrega un entero pasado a la pila. Si el tamaño máximo
			se excede, se produce un corrinúento, de manera que el elemento más
			antiguo de la pila (el fondo) se elimina. Por ejemplo, si tenemos una
			pila inicialmente vacía con capacidad máxima 3 apilamos 1, 2. 3 y 4 en ese orden,
			la pila limitada contendrá sucesivamente (siempre el tope hacia la izquierda): [1.] , [2. 1.], (3. 2. 1.] y [4. 3. 2.]
			Observe que, al final, el elemento más antiguo (el 1) se eliminó para hacer
			lugar al nuevo (el 4)
			• Desapilar, que funciona como en las pilas normales.
			• pilaVacia, que funciona como en las pilas normales.
			• tope, que funciona como en las pilas normal es.
			Se pide:
			a) Defina la interfaz de este TDA y las precondiciones es correspondientes.
			b) Implemente la interfaz anterior. Puede hacerlo de manera dinámica
			o estática.
			e) Prueba su programa con algunos datos.
			d) Calcule los costos de los métodos implementados.
	 * 
	 */
	public static void pilaLimitadataImplTest() {
		
		final int lim = 3;
		
		PilaLimitadaTDA pl = new PilaLimitada();
		pl.inicializarPila(lim);
		pl.apilar(1);
		pl.apilar(2);
		pl.apilar(3);
		pl.apilar(4);

		PilaUtils.mostrarPila(pl, lim);
	}
	
	/*
	 * (30 p] Introducción. Tenemos dos pilas y queremos determinar si contie-
		nen los mismos elementos, sin que nos importe ni el orden ni las posibles
		repeticion es . Esto se debe r ealiz ar a través de un método externo.
		Se pide entonces:
		a) Explique la estrategia (es decir, los pasos que planea seguir para
		resolver el ejercicio) con sus palabras.
		b) Escriba un método en Java que resuelva el problema. Las dos pilas
		que se reciben como parámetro deben preservarse.
		e) Prueba su programa conalgunos datos.
		d) Calcule el costo de su método y explique su resultado.
	 */
	public static boolean sonIguales(PilaTDA p1, PilaTDA p2) {
				
		ConjuntoTDA e1 = PilaUtils.elementos(p1);
		ConjuntoTDA e2 = PilaUtils.elementos(p2);
		
		while(!e1.conjuntoVacio()) {
			
			int e = e1.elegir();
			e1.quitar(e);
			if(!e2.pertenece(e)) {
				return false;
			}
			e2.quitar(e);
		}
		
		return e1.conjuntoVacio() && e2.conjuntoVacio();
	}
	
}

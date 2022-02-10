package main.exercises;

import main.impl.pila.PilaDinamica;
import main.interfaces.PilaTDA;
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

}

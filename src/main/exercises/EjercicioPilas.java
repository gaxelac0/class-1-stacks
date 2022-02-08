package main.exercises;

import main.impl.pila.PilaEstaticaTopeFinal;
import main.interfaces.PilaTDA;
import main.utils.PilaUtils;

public class EjercicioPilas {
	
	// Pasar una Pila a otra (dejándola en orden inverso) 1.a
	public static void invertirPila(PilaTDA pila) {
		
		System.out.println("Pila Original: ");
		PilaUtils.mostrarPila(pila);
		System.out.println("==============================");
		PilaTDA copia = PilaUtils.copiarPila(pila);
		PilaTDA invertida = new PilaEstaticaTopeFinal();
		while(!copia.pilaVacia()) {
			invertida.apilar(copia.tope());
			copia.desapilar();
		}
		System.out.println("Pila Invertida: ");
		PilaUtils.mostrarPila(invertida);
		System.out.println("==============================");
	}
	
	
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
	


}

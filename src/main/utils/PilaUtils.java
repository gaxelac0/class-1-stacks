package main.utils;

import main.impl.pila.PilaDinamica;
import main.impl.pila.PilaEstaticaTopeInicial;
import main.interfaces.PilaTDA;

public class PilaUtils {
	
	// Pasar una Pila a otra (dejándola en orden inverso) 1.a
	public static PilaTDA invertirPila(PilaTDA pila) {

		PilaTDA copia = PilaUtils.copiarPila(pila);
		PilaTDA invertida = new PilaDinamica();
		while(!copia.pilaVacia()) {
			invertida.apilar(copia.tope());
			copia.desapilar();
		}
		return invertida;
	}
	
	/**
	 * verifica si una pila es capicua
	 * @param pila
	 * @return
	 */
	public static boolean esCapicua(PilaTDA pila) {
		
		// start thinking its a match
		boolean bCapicua = true;
		
		PilaTDA copia = PilaUtils.copiarPila(pila);
		PilaTDA invertida = invertirPila(copia);
		while(bCapicua && !copia.pilaVacia()) {
			bCapicua = (copia.tope()==invertida.tope());
			copia.desapilar();
			invertida.desapilar();
		}
		return bCapicua;
	}
	
	public static void pilaTest() {
		PilaTDA pila = new PilaEstaticaTopeInicial();
		pila.apilar(1);
		pila.apilar(2);
		pila.apilar(3);
		pila.apilar(4);
		pila.apilar(5);
		mostrarPila(pila);
		
	}
	
	public static void mostrarPila(PilaTDA pila) {
		
		PilaTDA aux = copiarPila(pila);
		while(!aux.pilaVacia()) {
			System.out.println(aux.tope());
			aux.desapilar();
		}
		
	}
	
	public static PilaTDA copiarPila(PilaTDA pila) {
		PilaTDA copia = new PilaEstaticaTopeInicial();
		PilaTDA aux = new PilaEstaticaTopeInicial();
		while(!pila.pilaVacia()) {
			aux.apilar(pila.tope());
			pila.desapilar();
		}
		
		while(!aux.pilaVacia()) {
			pila.apilar(aux.tope());
			copia.apilar(aux.tope());
			aux.desapilar();
		}
		return copia;
	}

}

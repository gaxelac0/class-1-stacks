package main.utils;

import main.impl.conjunto.ConjuntoDinamico;
import main.impl.pila.PilaDinamica;
import main.impl.pila.PilaEstaticaTopeInicial;
import main.interfaces.ConjuntoTDA;
import main.interfaces.PilaTDA;

public class PilaUtils {
	
	// Pasar una Pila a otra (dejŠndola en orden inverso) 1.a
	public static PilaTDA invertirPila(PilaTDA pila) {

		PilaTDA copia = PilaUtils.copiarPila(pila);
		PilaTDA invertida = new PilaDinamica();
		while(!copia.pilaVacia()) {
			invertida.apilar(copia.tope());
			copia.desapilar();
		}
		return invertida;
	}
	
	public static PilaTDA eliminarDuplicados(PilaTDA pila) {
		
		ConjuntoTDA existentes = new ConjuntoDinamico();
		PilaTDA resultado = new PilaDinamica();
		
	
		PilaTDA invertida = PilaUtils.invertirPila(PilaUtils.copiarPila(pila));
		while(!invertida.pilaVacia()) {
			
			int t = invertida.tope();
			if(!existentes.pertenece(t)) {
				resultado.apilar(t);
				existentes.agregar(t);
			}
			invertida.desapilar();
		}
		
		return resultado;
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
	
	public static ConjuntoTDA obtenerElementosRepetidos(PilaTDA pila) {
		
		ConjuntoTDA elementos = new ConjuntoDinamico();
		ConjuntoTDA repetidos = new ConjuntoDinamico();
		
		PilaTDA copia = PilaUtils.copiarPila(pila);
		while(!copia.pilaVacia()) {
			
			int t = copia.tope();
			if(elementos.pertenece(t)) {
				repetidos.agregar(t);
			}
			else {
				elementos.agregar(t);
			}
			copia.desapilar();
		}

		return repetidos;
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

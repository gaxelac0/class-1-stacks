package main.impl.cola;

import main.interfaces.ColaPrioridadTDA;

/**
 * TODO: comparar con implementacion del profesor
 * @author alu702
 *
 */
public class ColaPrioridadDinamica implements ColaPrioridadTDA {
	
	class Nodo {
		int valor;
		int prioridad;
		Nodo sig;
	}
	Nodo primero;
	
	public ColaPrioridadDinamica() {
		this.inicializarCola();
	}

	@Override
	public void inicializarCola() {
		primero = null;
	}

	@Override
	public void acolarPrioridad(int valor, int prioridad) {
		
		Nodo nuevo = new Nodo();
		nuevo.valor = valor;
		nuevo.prioridad = prioridad;
		if(primero == null) {
			primero = nuevo;
		}
		else {
			
			if(primero.prioridad < prioridad) {
				nuevo.sig = primero;
				primero = nuevo;
			}
			else {
				
				// TODO resta revisar esta parte (revisar Diagrama2)
				Nodo aux = primero;
				while(aux.sig != null && aux.sig.prioridad > prioridad) {
					aux = aux.sig;
				}
				
				nuevo.sig = aux.sig;
				aux.sig = nuevo;
			}
		}
	}

	@Override
	public void desencolar() {
		primero = primero.sig;
	}

	@Override
	public boolean colaVacia() {
		return (primero == null);
	}

	@Override
	public int primero() {
		return primero.valor;
	}

	@Override
	public int prioridad() {
		return primero.prioridad;
	}

}

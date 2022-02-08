package main.impl.pila;

import main.interfaces.PilaTDA;

public class PilaDinamica implements PilaTDA {
	
	class Nodo {
		int valor;
		Nodo sig;
	}
	Nodo primero;

	public PilaDinamica() {
		this.inicializarPila();
	}
	
	
	@Override
	public void inicializarPila() {
		primero = null;
	}

	@Override
	public void apilar(int x) {
		
		Nodo nuevo = new Nodo();
		nuevo.valor = x;
		nuevo.sig = primero;
		primero = nuevo;
	}

	@Override
	public void desapilar() {
		primero = primero.sig;
	}

	@Override
	public int tope() {
		return primero.valor;
	}

	@Override
	public boolean pilaVacia() {
		return primero == null;
	}
	
}
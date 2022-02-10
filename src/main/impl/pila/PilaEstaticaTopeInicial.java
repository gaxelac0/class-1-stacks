package main.impl.pila;

import main.interfaces.PilaTDA;

public class PilaEstaticaTopeInicial implements PilaTDA {
	
	int indice;
	private int[] elems;
	
	public PilaEstaticaTopeInicial() {
		this.inicializarPila();
	}
	
	@Override
	public boolean pilaVacia() {
		return indice == 0;
	}

	@Override
	public void inicializarPila() {
		elems = new int[100];
		indice = 0;
	}

	@Override
	public void apilar(int x) {
		
		for(int i = indice-1; i >= 0; i--) {
			elems[i+1] = elems[i];
		}
		elems[0] = x;
		indice++;
	}

	@Override
	public void desapilar() {
		indice--;
		for(int i = 0; i < indice; i++) {
			elems[i] = elems[i+1];
		}
	}

	@Override
	public int tope() {
		return elems[0];
	}
}

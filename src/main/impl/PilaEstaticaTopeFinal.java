package main.impl;

import main.interfaces.PilaTDA;

public class PilaEstaticaTopeFinal implements PilaTDA {
	
	int tope;
	private int[] elems;
	
	public PilaEstaticaTopeFinal() {
		this.inicializarPila();
	}
	
	@Override
	public boolean pilaVacia() {
		return tope == 0;
	}

	@Override
	public void inicializarPila() {
		elems = new int[10];
		tope = 0;
	}

	@Override
	public void apilar(int x) {
		elems[tope] = x;
		tope++;
	}

	@Override
	public void desapilar() {
		if(tope>=0) { 
			elems[tope] = 0;
			tope--;
		}
	}

	@Override
	public int tope() {
		if(tope>0) {
			return elems[tope-1];
		}
		return -1;
	}
}

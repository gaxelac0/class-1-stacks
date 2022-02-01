package main.impl;

import java.util.ArrayList;

import main.interfaces.PilaTDA;

public class PilaDinamica implements PilaTDA {
	
	private int idxTope;
	private ArrayList<Element> elems;
	
	public PilaDinamica() {
		this.inicializarPila();
	}

	@Override
	public void apilar(int x) {
		Element e = new Element();
		e.valor = x;
		
		if (idxTope != -1) {
			e.ant = elems.get(idxTope);
		}
		elems.add(e);
		idxTope++; 
	}

	@Override
	public void desapilar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int tope() {
		return idxTope == -1 ? -1 : elems.get(idxTope).valor;
	}

	@Override
	public boolean pilaVacia() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void inicializarPila() {
		elems = new ArrayList<>();
		idxTope = -1;
	}
	
	@SuppressWarnings("unused")
	private class Element {
		private int valor;
		private Element ant;
	}
	
}
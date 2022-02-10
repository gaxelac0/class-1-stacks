package main.impl.cola;

import main.interfaces.ColaPrioridadTDA;

public class ColaPrioridadEstatica implements ColaPrioridadTDA {
	
	private class Element {
		int valor;
		int prioridad;
	}
	
	private Element[] elementos;
	private int indice;
	
	public ColaPrioridadEstatica() {
		this.inicializarCola();
	}
	
	@Override
	public void inicializarCola() {
		elementos = new Element[100];
		indice = 0;
	}

	@Override
	public void acolarPrioridad(int prioridad, int valor) {

		int j = indice;
		while(j > 0 && elementos[j-1].prioridad >= prioridad) {
			elementos[j] = elementos[j-1];
			j--;
		}
		
		Element newElem = new Element();
		newElem.valor = valor;
		newElem.prioridad = prioridad;
		elementos[j] = newElem;
		indice++;
	}

	@Override
	public void desencolar() {
		indice--;
	}

	@Override
	public boolean colaVacia() {

		return indice == 0;
	}

	@Override
	public int primero() {
		return elementos[indice-1].valor;
	}

	@Override
	public int prioridad() {
		return elementos[indice-1].prioridad;
	}

}

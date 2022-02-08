package main.impl.cola;

import main.interfaces.ColaTDA;

public class ColaDinamica implements ColaTDA {
	
	class Nodo {
		int valor;
		Nodo sig;
	}
	Nodo primero, ultimo;

	@Override
	public void inicializarCola() {
		primero = ultimo = null;
	}

	@Override
	public void acolar(int x) {
		Nodo nuevo = new Nodo();
		nuevo.valor = x;
		
		if(ultimo != null) {
			ultimo.sig = nuevo;
		}
		
		ultimo = nuevo;
		if(primero == null) {
			primero = ultimo;
		}
	}

	@Override
	public void desacolar() {
		primero = primero.sig;
		if(primero == null) {
			ultimo = null;
		}
	}

	@Override
	public int primero() {
		// TODO Auto-generated method stub
		return primero.valor;
	}

	@Override
	public boolean colaVacia() {
		return primero==null;
	}

}

package main.impl.cola;

import main.interfaces.ColaParcialTDA;

// TODO esta implementación no está bien. Se deben ir insertando a la derecha o a la izquierda
// no hacia el centro.
// insertarizq(1)
// insertarizq(2)
// insertarizq(3)
// resultado [1, 2, 3]
// Implementar una cola que se pueda sacar desde la izquiera y desde la derecha
// tambien se puede insertar a la izquierda o a la derecha
public class ColaParcialDinamica implements ColaParcialTDA {
	
	private class Nodo {
		private int valor;
		private Nodo sig;
	}
	private Nodo izquierda;
	private Nodo derecha;
	
	public ColaParcialDinamica() {
		this.inicializarCola();
	}

	@Override
	public void inicializarCola() {
		izquierda = derecha = null;
	}

	@Override
	public void acolarIzquierda(int x) {
		
		Nodo nuevo = new Nodo();
		nuevo.valor = x;
		
		if(izquierda==null) {
			izquierda = derecha = nuevo;
		}
		else {
			nuevo.sig = izquierda.sig;
			izquierda.sig = nuevo;
			
			if(derecha==null) {
				derecha = izquierda;
			}
			else {
				derecha = nuevo;
			}
		}	
	}

	@Override
	public void acolarDerecha(int x) {
		
		Nodo nuevo = new Nodo();
		nuevo.valor = x;
		
		if(derecha==null) {
			izquierda = derecha = nuevo;
		}
		else {
			nuevo.sig = derecha.sig;
			derecha.sig = nuevo;
			derecha = nuevo;
		}
	}

	@Override
	public void desacolarIzquierda() {
		izquierda = izquierda.sig;
	}

	// Esta implementación posee derecha como el anteúltimo y no el ultimo.
	// esto hace que no pueda desacolar por la derecha apropiadamente, referirse a .\Diagramas\Diagrama-1.png
	@Override
	public void desacolarDerecha() {
		derecha = derecha.sig;
	}

	@Override
	public int izquierda() {
		return izquierda.valor;
	}

	@Override
	public int derecha() {
		return derecha.valor;
	}

	@Override
	public boolean colaVacia() {
		return (izquierda==null);
	}
}

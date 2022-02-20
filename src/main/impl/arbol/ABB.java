package main.impl.arbol;

import main.interfaces.ABBTDA;

public class ABB implements ABBTDA {
	
	class Nodo {
		int valor;
		ABBTDA hijoIzq;
		ABBTDA hijoDer;
	}
	
	Nodo raiz;
	
	public ABB() {
		this.inicializarArbol();
	}

	@Override
	public void inicializarArbol() {
		raiz = null;
	}

	@Override
	public int raiz() {
		// TODO Auto-generated method stub
		return raiz.valor;
	}

	@Override
	public ABBTDA hijoIzq() {
		// TODO Auto-generated method stub
		return raiz.hijoIzq;
	}

	@Override
	public ABBTDA hijoDer() {
		// TODO Auto-generated method stub
		return raiz.hijoDer;
	}

	@Override
	public void agregarElem(int x) {
				
		if(raiz == null) {
			raiz = new Nodo();
			raiz.valor = x;
			raiz.hijoIzq = new ABB();
			raiz.hijoDer = new ABB();
		}
		else if(raiz.valor > x) {
			raiz.hijoIzq.agregarElem(x);
		}
		// a derecha
		else {
			raiz.hijoDer.agregarElem(x);
		}
		
	}

	@Override
	public void eliminarElem(int x) {
		
		if(raiz != null) {
			
			if(raiz.valor == x && hijoIzq().arbolVacio() && hijoDer().arbolVacio()) {
				raiz = null;
			}
			else if (raiz.valor == x && !hijoIzq().arbolVacio()) {
				raiz.valor = mayor(raiz.hijoIzq);
				raiz.hijoIzq.eliminarElem(raiz.valor);
			}
			else if (raiz.valor == x && hijoIzq().arbolVacio()) {
				raiz.valor = menor(raiz.hijoDer);
				raiz.hijoDer.eliminarElem(raiz.valor);
			}
			else if (raiz.valor > x) {
				raiz.hijoIzq.eliminarElem(x);
			}
			else {
				raiz.hijoDer.eliminarElem(x);
			}
		}
	}

	@Override
	public boolean arbolVacio() {
		// TODO Auto-generated method stub
		return (raiz == null);
	}
	
	private int mayor(ABBTDA a) {
				
		if(a.hijoDer().arbolVacio()) {
			return a.raiz();
		}
		else {
			return mayor(a.hijoDer());
		}
		
	}
	
	private int menor(ABBTDA a) {
		
		if(a.hijoIzq().arbolVacio()) {
			return a.raiz();
		}
		else {
			return menor(a.hijoIzq());
		}
		
	}
}

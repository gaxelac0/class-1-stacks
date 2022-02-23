package main.utils;

import main.interfaces.ABBTDA;

public class ArbolUtils {

	public static void preOrder(ABBTDA a) {

		if(!a.arbolVacio()) {
			System.out.print(a.raiz()  + " ");
			preOrder(a.hijoIzq());
			preOrder(a.hijoDer());	
		}
	}

	public static void inOrder(ABBTDA a) {
		if(!a.arbolVacio()) {
			inOrder(a.hijoIzq());
			System.out.print(a.raiz() + " ");
			inOrder(a.hijoDer());
		}
	}

	public static void postOrder(ABBTDA a) {
		if(!a.arbolVacio()) {
			postOrder(a.hijoIzq());
			postOrder(a.hijoDer());
			System.out.print(a.raiz()  + " ");
		}
	}
}

package main.exercises;

import main.impl.conjunto.ConjuntoDinamico;
import main.interfaces.ABBTDA;
import main.interfaces.ConjuntoTDA;

public class EjercicioArboles {
	
	
	/**
	 * cuenta la cantidad de elementos presentes en el arbol
	 * @param a
	 * @return
	 */
	public static int contarCantidad(ABBTDA a) {
		
		if (a.arbolVacio()) {
			return 0;
		}
		else {
			return 1 + contarCantidad(a.hijoIzq()) + contarCantidad(a.hijoDer());
		}
	}
	
	/**
	 * suma los valores de todos los nodos
	 * @param a
	 * @return
	 */
	public static int sumarValores(ABBTDA a) {
		
		if(a.arbolVacio()) {
			return 0;
		}
		else {
			return a.raiz() + sumarValores(a.hijoIzq()) + sumarValores(a.hijoDer());
		}
		
	}
	
	/*
	 * determina la altura de un arbol.
	 * 
	 * 	 * (40 p) Un ejercicio tomado de la gu� a. La altura de un �rbol se definecomo la m�xima distancia medida de
	 * 	 "saltos" cutre la ra�z y la hoja m�s distante.
		Se pide:
		a) Defina y <'xpliqne uua estrategia para encontrar la al tma <l e un �rhol
		binario de b�squeda, es decir, un objeto de tipo ABBTDA.
		b) Escriba un m�todo externo en Java que reciba el �rbol y devuel va
		su al tura . Obser ve que un �rbol vac�o debe tener altura I para
		distinguirlo de un �rbol co n un �nico nodo, que tiene altura ll.
	 */
	public static int altura(ABBTDA a) {
		
		if(a.arbolVacio()) {
			return -1;
		}
		else {
			int izq = 1 + altura(a.hijoIzq());
			int der = 1 + altura(a.hijoDer());
			return (izq > der) ? izq : der;
		}	
	}
	
	/**
	 * precondicion: el elemento debe existir
	 * Determina cu�n profundo en niveles est� ubicado el elemento enviado por parametro
	 * @param a arbol en cuestion
	 * @param x elemento a calcular su profundidad
	 * @return profundidad
	 */
	public static int profundidadElemento(ABBTDA a, int x) {
		
		if(a.arbolVacio()) {
			return 0;
		}
		else if (a.raiz() == x) {
			return 0;
		}
		else if (a.raiz() > x)  {
			return 1 + profundidadElemento(a.hijoIzq(), x);
		}
		else {
			return 1 + profundidadElemento(a.hijoDer(), x);
		}
	}
	
	/**
	 * Metodo que verifica si un elemento existe o no
	 * @param a
	 * @param x
	 * @return
	 */
	public static boolean existeElemento(ABBTDA a, int x) {
		
		if(a.arbolVacio()) {
			return false;
		}
		else if (a.raiz() == x) {
			return true;
		}
		else if (a.raiz() > x) {
			return existeElemento(a.hijoIzq(), x);
		}
		else {
			return existeElemento(a.hijoDer(), x);
		}
	}
	
	/**
	 * Metodo que recorre el arbol obtiendo los elementos pares en un conjunto
	 * @param a arbol
	 * @return conjunto de elementos pares
	 */
	public static ConjuntoTDA devolverElementosPares(ABBTDA a) {
		
		ConjuntoTDA c = new ConjuntoDinamico();
		
		if(!a.arbolVacio()) {
			
			if(a.raiz() % 2 == 0) {
				c.agregar(a.raiz());
			}
			
			ConjuntoTDA cizq = devolverElementosPares(a.hijoIzq());
			ConjuntoTDA cder = devolverElementosPares(a.hijoDer());
			
			while(!cizq.conjuntoVacio()) {
				int e = cizq.elegir();
				cizq.quitar(e);
				c.agregar(e);
			}
			
			while(!cder.conjuntoVacio()) {
				int e = cder.elegir();
				cder.quitar(e);
				c.agregar(e);
			}
		}
		
		return c;
	}
	
	/**
	 * Dado un elemento, determinar si es una hoja de un ABB.
	 * @param a arbol
	 * @param x elem
	 * @return es hoja o no
	 */
	public static boolean esHoja(ABBTDA a, int x) {
		
		if(a.arbolVacio()) {
			return false;
		}
		else if(a.raiz() == x && a.hijoIzq().arbolVacio() && a.hijoDer().arbolVacio()) {
			return true;
		}
		else if (a.raiz() > x) {
			return esHoja(a.hijoIzq(), x);
		}
		else {
			return esHoja(a.hijoDer(), x);
		}
	}
	
	/**
	 * Obtener el valor del menor elemento de un ABB.
	 * @param a arbol
	 * @return int menor elemento
	 */
	public static int menor(ABBTDA a) {
		
		if(a.arbolVacio()) {
			return 0;
		}
		
		if (a.hijoIzq().arbolVacio()) {
			return a.raiz();
		}
		else {
			return menor(a.hijoIzq());
		}
	}
	
	/**
	 * Calcular el cantidad de hojas de un ABB
	 * @param a
	 * @return
	 */
	public static int cantHojas(ABBTDA a) {
		
		if(a.arbolVacio()) {
			return 0;
		}
		else {
			
			if(a.hijoDer().arbolVacio() && a.hijoIzq().arbolVacio()) {
				return 1;
			}
			else {
				return cantHojas(a.hijoIzq()) + cantHojas(a.hijoDer());
			}	
		}
	}
	
	/**
	 * Comprobar si dos ABBs tienen la misma forma.
	 * @param a1 arbol 1
	 * @param a2 arbol 2
	 * @return tienen misma forma
	 */
	public static boolean mismaForma(ABBTDA a1, ABBTDA a2) {
		
		if(a1.arbolVacio() && a2.arbolVacio()) {
			return true;
		}
		else if (a1.arbolVacio() || a2.arbolVacio()) {
			return false;
		}
		else {
			return mismaForma(a1.hijoIzq(), a2.hijoIzq()) && mismaForma(a1.hijoDer(), a2.hijoDer());
		}
	}
	
	/**
	 * Comprobar si dos ABBs son iguales.
	 * @param a1 arbol1
	 * @param a2 arbol2
	 * @return son iguales o no
	 */
	public static boolean sonIguales(ABBTDA a1, ABBTDA a2) {
		
		if(a1.arbolVacio() && a2.arbolVacio()) {
			return true;
		}
		else if (a1.arbolVacio() || a2.arbolVacio()) {
			return false;
		}
		else if (a1.raiz() != a2.raiz()) {
			return false;
		}
		else 
			return sonIguales(a1.hijoIzq(), a2.hijoIzq()) && sonIguales(a1.hijoDer(), a2.hijoDer());
	}
	
	/**
	 * Calcula la cantidad de elementos posee en el nivel N enviado por parametro.
	 * @param a arbol
	 * @param n nivel del arbol
	 * @return cantidad de elementos en el nivel n en el arbol a
	 */
	public static int cantNodosNivelN(ABBTDA a, int n) {
		if (a.arbolVacio())
			return 0;
		else if (n == 0)
			return 1;
		else
			return cantNodosNivelN(a.hijoIzq(), n - 1) + 
					cantNodosNivelN(a.hijoDer(), n - 1);
	}
}

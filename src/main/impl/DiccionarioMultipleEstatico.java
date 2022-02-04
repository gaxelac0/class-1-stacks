package main.impl;

import main.interfaces.ConjuntoTDA;
import main.interfaces.DiccionarioMultipleTDA;

public class DiccionarioMultipleEstatico implements DiccionarioMultipleTDA {
	
	class Elemento {
		int clave;
		int[] valores;
		int cantValores;
		
		Elemento() {
			valores = new int[100];
			cantValores = 0;
		}
	}
	
	private Elemento[] elementos;
	private int cantClaves;
	
	public DiccionarioMultipleEstatico() {
		this.inicializarDiccionario();
	}
	
	@Override
	public void inicializarDiccionario() {
		elementos = new Elemento[100];
		cantClaves = 0;
	}
	@Override
	public void agregar(int key, int value) {
		// clave2Indice
		// if pos == -1 genero un nuevo elemento
				// pos = cantClaves
		
		
		// valor2Indice
		// 
		//cantClaves++
		
	}
	
	@Override
	public void eliminarClave(int key) {
		// elimina la clave completamente
		
	}
	
	@Override
	public void eliminarValor(int key, int value) {
		// elimina el valor si existe. Si la clave no tiene mas valores, eliminar clave.
		
	}
	
	@Override
	public ConjuntoTDA recuperar(int key) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ConjuntoTDA claves() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * obtiene el indice de la posicion de la clave en el array. 
	 * si no existe devuelve -1
	 * @return
	 */
	private int clave2Indice(int key) {
		
		int i = cantClaves-1;
		while(i>= 0 && elementos[i].clave != key)
			i++;
			
		return i;
	}
	
	/**
	 * obtiene el indice de la posicion del valor en el array de valores del elemento
	 * si no existe devuelve -1
	 * @return
	 */
	private int value2Indice(Elemento e, int val) {
		
		int i = e.cantValores-1;
		while(i>= 0 && e.valores[i] != val)
			i++;
			
		return i;
	}
}

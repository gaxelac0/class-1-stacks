package main.impl.diccionario;

import main.impl.conjunto.ConjuntoEstatico;
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
		
		int posC = clave2Indice(key);
		if(posC == -1) {
			posC = cantClaves;
			
			elementos[posC] = new Elemento();
			elementos[posC].clave = key;
			cantClaves++;
		}
		
		Elemento e = elementos[posC];
		int posV = value2Indice(e, value);
		if(posV == -1) {
			e.valores[e.cantValores] = value;
			e.cantValores++;
		}
	}
	
	@Override
	public void eliminarClave(int key) {
		
		
		// elimina la clave completamente
		int pos = clave2Indice(key);
		if(pos != -1) {
			elementos[pos] = elementos[cantClaves-1];
			cantClaves--;
		}
		
	}
	
	@Override
	public void eliminarValor(int key, int value) {
		// elimina el valor si existe. Si la clave no tiene mas valores, eliminar clave.
		int posC = clave2Indice(key);
		if(posC != -1) {
			
			Elemento e = elementos[posC];
			int posV = value2Indice(e, value);
			if(posV != -1) {
				e.valores[posV] = e.valores[e.cantValores-1];
				e.cantValores--;
				
				if(e.cantValores == 0) {
					eliminarClave(key);
				}
			}
		}
		
	}
	
	@Override
	public ConjuntoTDA recuperar(int key) {

		ConjuntoTDA c = new ConjuntoEstatico();
		int pos = clave2Indice(key);
		if(pos != -1) {
			
			Elemento e = elementos[pos];
			for(int i = 0; i < e.cantValores; i++) {
				c.agregar(e.valores[i]);
			}
			
		}
		
		return c;
	}
	
	@Override
	public ConjuntoTDA claves() {
		
		ConjuntoTDA c = new ConjuntoEstatico();
		for(int i = 0; i < cantClaves; i++) {
			c.agregar(elementos[i].clave);
		}
		
		return c;
	}
	
	/**
	 * obtiene el indice de la posicion de la clave en el array. 
	 * si no existe devuelve -1
	 * @return
	 */
	private int clave2Indice(int key) {
		
		int i = cantClaves-1;
		while(i>= 0 && elementos[i].clave != key)
			i--;
			
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
			i--;
			
		return i;
	}
}

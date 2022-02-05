package main.impl.diccionario;

import main.impl.conjunto.ConjuntoEstatico;
import main.interfaces.ConjuntoTDA;
import main.interfaces.DiccionarioSimpleTDA;

public class DiccionarioSimpleEstatico implements DiccionarioSimpleTDA {
	
	class Elemento {
		int key;
		int valor;
	}
	
	private Elemento[] elems;
	private int cantClaves;
	
	public DiccionarioSimpleEstatico() {
		this.inicializarDiccionario();
	}

	@Override
	public void inicializarDiccionario() {
		elems = new Elemento[100];
		cantClaves = 0;
	}

	@Override
	public void agregar(int key, int valor) {

		// pos = clave 2 indice, devuelve -1 si no encuentra sino el indice.
		int pos = clave2Indice(key);
		if(pos == -1) {
			
			pos = cantClaves;
			
			elems[pos] = new Elemento();
			elems[pos].key = key;
			
			cantClaves++;
		}
		// pisamos el valor de pos ya que no es -1, la clave existe
		// lo pisamos tambien aca para cuando no existe, ya se genero previamente.
		elems[pos].valor = valor;
	}

	@Override
	public void eliminar(int key) {

		// recupero la posicion con clave2indice, si no existe no hago nada
		// si existe, lo piso con el ultimo y deremento
		int pos = clave2Indice(key);
		if (pos != -1) {
			elems[pos] = elems[cantClaves-1];
			cantClaves--;
		}
	}

	// Precondicion: la clave debe existir
	@Override
	public int recuperar(int key) {
		//obtengo la posicion con la clave, si existe devuelve le valor
		return elems[clave2Indice(key)].valor;
	}

	@Override
	public ConjuntoTDA claves() {
	
		ConjuntoTDA c = new ConjuntoEstatico();
		for(int i = 0; i < cantClaves; i++) {
			c.agregar(elems[i].key);
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
		while(i>= 0 && elems[i].key != key)
			i--;
			
		return i;
	}
}

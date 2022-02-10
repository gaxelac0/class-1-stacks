package main.impl.diccionario;

import main.impl.conjunto.ConjuntoDinamico;
import main.interfaces.ConjuntoTDA;
import main.interfaces.DiccionarioSimpleTDA;

// Diagrama 4
public class DiccionarioSimpleDinamico implements DiccionarioSimpleTDA {
	
	class Nodo {
		int value;
		int key;
		Nodo sig;
	}
	Nodo inicio;
	
	public DiccionarioSimpleDinamico() {
		this.inicializarDiccionario();
	}

	@Override
	public void inicializarDiccionario() {
		inicio = null;
	}

	@Override
	public void agregar(int key, int value) {
		
		Nodo nodoClave = clave2Nodo(key);
		if(nodoClave != null) {
			nodoClave.value = value;
		}
		else {
			
			Nodo nuevo = new Nodo();
			nuevo.key = key;
			nuevo.value = value;
			nuevo.sig = inicio;
			inicio = nuevo;
		}	
	}

	@Override
	public void eliminar(int key) {

		if(inicio != null && inicio.key == key) {
			inicio = inicio.sig;
		}
		else {
			
			Nodo viajero = inicio;
			while(viajero.sig != null && viajero.sig.key != key) {
				viajero = viajero.sig;
			}
			
			if(viajero.sig != null) {
				viajero.sig = viajero.sig.sig;
			}
		}
	}

	@Override
	public int recuperar(int key) {
		return clave2Nodo(key).value;
	}

	@Override
	public ConjuntoTDA claves() {
		
		ConjuntoTDA claves = new ConjuntoDinamico();
		
		Nodo aux = inicio;
		while(aux != null) {
			
			claves.agregar(aux.key);
			aux = aux.sig;
		}
		
		
		return claves;
	}
	
	private Nodo clave2Nodo(int key) {
		
		Nodo aux = inicio;
		while(aux != null && aux.key != key) {
			aux = aux.sig;
		}
		
		return aux;
	}


}

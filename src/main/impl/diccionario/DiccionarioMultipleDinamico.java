package main.impl.diccionario;

import main.impl.conjunto.ConjuntoDinamico;
import main.interfaces.ConjuntoTDA;
import main.interfaces.DiccionarioMultipleTDA;

public class DiccionarioMultipleDinamico implements DiccionarioMultipleTDA {
	
	class NodoValor {
		int value;
		NodoValor sig;
	}
	
	class NodoClave {
		int key;
		NodoValor values;
		NodoClave sig;
	}
	NodoClave inicio;
	
	public DiccionarioMultipleDinamico() {
		this.inicializarDiccionario();
	}
	

	@Override
	public void inicializarDiccionario() {
		inicio = null;
	}

	@Override
	public void agregar(int key, int value) {
		
		NodoValor nuevo = new NodoValor();
		nuevo.value = value;
		
		NodoClave nc = clave2NodoClave(key);
		if (nc != null) {
			
			NodoValor nv = value2NodoValor(nc, value);
			if(nv == null) {
				nuevo.sig = nc.values;
				nc.values = nuevo;
			}
		}
		else {
			
			nc = new NodoClave();
			nc.key = key;
			nc.values = nuevo;
			
			nc.sig = inicio;
			inicio = nc;
		}	
	}

	// inicializado y no vacio
	@Override
	public void eliminarClave(int key) {
		
		if(inicio.key == key) {
			inicio = inicio.sig;
		}
		else {
			
			NodoClave aux = inicio;
			while(aux.sig != null && aux.sig.key != key) {
				aux = aux.sig;
			}
			
			if(aux.sig != null) {
				aux.sig = aux.sig.sig;
			}
		}
	}

	@Override
	public void eliminarValor(int key, int value) {
		
		NodoClave nc = clave2NodoClave(key);
		if(nc != null) {
			
			if(nc.values.value == value) {
				
				nc.values = nc.values.sig;
				if(nc.values == null) {
					eliminarClave(key);
				}
			}
			else {
				
				NodoValor aux = nc.values;
				while(aux.sig != null && aux.sig.value != value) {
					aux = aux.sig;
				}
				
				if(aux.sig != null) {
					aux.sig = aux.sig.sig;
				}
			}
		}
	}

	@Override
	public ConjuntoTDA recuperar(int key) {
		
		ConjuntoTDA valores = new ConjuntoDinamico();
		
		NodoClave nc = clave2NodoClave(key);
		NodoValor aux = nc.values;
		while(aux != null) {
			valores.agregar(aux.value);
			aux = aux.sig;
		}
		
		return valores;
	}

	@Override
	public ConjuntoTDA claves() {

		ConjuntoTDA claves = new ConjuntoDinamico();
		
		NodoClave aux = inicio;
		while(aux != null) {
			claves.agregar(aux.key);
			aux = aux.sig;
		}
		
		return claves;
	}
	
	private NodoClave clave2NodoClave(int key) {
		
		NodoClave aux = inicio;
		while(aux != null && aux.key != key) {
			aux = aux.sig;
		}
		
		return aux;
	}
	
	private NodoValor value2NodoValor(NodoClave c, int value) {
		
		NodoValor aux = c.values;
		while(aux != null && aux.value != value) {
			aux = aux.sig;
		}
		
		return aux;
	}

}

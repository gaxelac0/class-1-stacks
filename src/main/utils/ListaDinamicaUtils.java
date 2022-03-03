package main.utils;

public class ListaDinamicaUtils {
	

		@SuppressWarnings("unused")
		public static Nodo agregarAdelante(Nodo origen, int x) {
			Nodo nuevo = new Nodo();
			nuevo.valor = x;
			nuevo.sig = origen;
			origen = nuevo;
			
			return origen;

		}
		
		/**
		 * Muestra la lista dinamica
		 * @param origen
		 */
		@SuppressWarnings("unused")
		public static void mostrarListaRecursiva(Nodo origen) {
			
			if(origen != null) {
				System.out.print(origen.valor + " ");
				mostrarListaRecursiva(origen.sig);
			}
			System.out.println("");
		}
		
		/**
		 * Muestra la lista dinamica
		 * @param origen
		 */
		@SuppressWarnings("unused")
		public static void mostrarLista(Nodo origen) {
			
			Nodo aux = origen;
			while(aux != null) {
				System.out.print(aux.valor + " ");
				aux = aux.sig;
			}
			System.out.println("");
		}
		
	
		/**
		 * Concatena las dos listas dejando la primera delante
		 * Estrategia Iterativa
		 * @return
		 */
		public static Nodo concatenarIterativa(Nodo n1, Nodo n2) {
			
			if(n1 == null)
				return n2;
			
			Nodo aux = n1;
			while(aux.sig != null) {
				aux = aux.sig;
			}
			
			aux.sig = n2;
			
			return n1;
		}
		
		/**
		 * Concatena las dos listas dejando la primera delante
		 * Estrategia Recursiva
		 * @return
		 */
		public static Nodo concatenarRecursiva(Nodo n1, Nodo n2) {
			
			Nodo aux = new Nodo();
			
			if(n1 == null) {
				return n2;
			}
			else if(n1.sig == null) {
				n1.sig = n2;
			}
			else {
				aux = concatenarRecursiva(n1.sig, n2);
				aux = agregarAdelante(aux, n1.valor);
				n1 = aux;
			}
			
			return n1;
		}
}

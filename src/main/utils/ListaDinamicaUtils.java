package main.utils;

public class ListaDinamicaUtils {
	

		private static Nodo agregarAdelante(Nodo origen, int x) {
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
		private static void mostrarListaRecursiva(Nodo origen) {
			
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
		private static void mostrarLista(Nodo origen) {
			
			Nodo aux = origen;
			while(aux != null) {
				System.out.print(aux.valor + " ");
				aux = aux.sig;
			}
			System.out.println("");
		}
}

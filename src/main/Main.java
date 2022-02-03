package main;

import main.impl.ColaPrioridadEstatica;
import main.interfaces.ColaPrioridadTDA;
import main.utils.ColaPrioridadUtils;

public class Main {

	public static void main(String[] args) {
		
		ColaPrioridadTDA cola = new ColaPrioridadEstatica();
		cola.acolarPrioridad(3, 4);
		cola.acolarPrioridad(1, 2);
		cola.acolarPrioridad(6, 6);
		cola.acolarPrioridad(4, 5);
		cola.acolarPrioridad(2, 3);

		
		ColaPrioridadUtils.mostrarCola(cola);
	}
}

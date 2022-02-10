package main;

import main.impl.cola.ColaPrioridadDinamica;
import main.interfaces.ColaPrioridadTDA;
import main.utils.ColaPrioridadUtils;


public class Main {

	public static void main(String[] args) {
		
		// TODO luego del desencolar la prioridad y el valor se invierten, revisar.
		ColaPrioridadTDA cola = new ColaPrioridadDinamica();
		cola.acolarPrioridad(0, 2);
		cola.acolarPrioridad(0, 1);
		cola.acolarPrioridad(0, -2);
		cola.acolarPrioridad(0, -7);
		
		System.out.println("");
		ColaPrioridadUtils.mostrarCola(cola);
		
		cola.desencolar();
		System.out.println("");
		ColaPrioridadUtils.mostrarCola(cola);
		

		// TODO probar y corregir esto
//		ColaPrioridadTDA c1 = new ColaPrioridadEstatica();
//		c1.acolarPrioridad(8, 11);
//		c1.acolarPrioridad(7, 22);
//		c1.acolarPrioridad(6, 11);
//		c1.acolarPrioridad(6, 7);
//		
//		ColaPrioridadTDA c2 = new ColaPrioridadEstatica();
//		c2.acolarPrioridad(9, 9);
//		c2.acolarPrioridad(8, 13);
//		c2.acolarPrioridad(7, 15);
//		c2.acolarPrioridad(6, 7);
//		
//		ColaPrioridadTDA res = EjecicioColaPrioridad.mergeColas(c1, c2);
//		ColaPrioridadUtils.mostrarCola(res);
	}
}

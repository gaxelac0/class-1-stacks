package main.exercises;

import main.impl.cola.ColaPrioridadEstatica;
import main.interfaces.ColaPrioridadTDA;
import main.utils.ColaPrioridadUtils;

public class EjecicioColaPrioridad {
	
	/*
	 * A partir del TDA Cola con prioridades definido, escribir un método que permita
		a) Combinar dos colas con prioridades CP1 y CP2, generando una nueva 
		cola con prioridades. Considerar que a igual prioridad, los elementos de la CP1 
		son más prioritarios que los de la CP2. 
	 */
	public static ColaPrioridadTDA mergeColas(ColaPrioridadTDA cola1, ColaPrioridadTDA cola2) {
		
		ColaPrioridadTDA res = new ColaPrioridadEstatica();
		ColaPrioridadTDA c1 = ColaPrioridadUtils.copiarCola(cola1);
		ColaPrioridadTDA c2 = ColaPrioridadUtils.copiarCola(cola2);
		
		int prioridadBase = c2.prioridad();
		while(!c2.colaVacia()) {
			res.acolarPrioridad(c2.primero(), c2.prioridad());
			c2.desencolar();
		}
		
		while(!c1.colaVacia()) {
			res.acolarPrioridad(c1.primero(), c1.prioridad() + prioridadBase);
			c1.desencolar();
		}
		
		return res;
	}

}

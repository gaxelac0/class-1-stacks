package main.exercises;

import main.impl.cola.ColaPrioridadEstatica;
import main.interfaces.ColaPrioridadTDA;
import main.utils.ColaPrioridadUtils;

public class EjecicioColaPrioridad {
	
	// TODO Debuggear este metodo para corregir el pequeño error
	// TODO revisar foto de la galeria para ver como correr el ejemplo
	/*
	 * A partir del TDA Cola con prioridades definido, escribir un método que permita
		a) Combinar dos colas con prioridades CP1 y CP2, generando una nueva 
		cola con prioridades. Considerar que a igual prioridad, los elementos de la CP1 
		son más prioritarios que los de la CP2.
		b) Determinar si dos Colas con prioridad son idénticas
	 */
	public static ColaPrioridadTDA mergeColas(ColaPrioridadTDA cola1, ColaPrioridadTDA cola2) {
		
		ColaPrioridadTDA res = new ColaPrioridadEstatica();
		ColaPrioridadTDA c1 = ColaPrioridadUtils.copiarCola(cola1);
		ColaPrioridadTDA c2 = ColaPrioridadUtils.copiarCola(cola2);
		
		int prio = 5;
		
		while(!c1.colaVacia()) {
			if(c1.prioridad() > c2.prioridad()) {
				
				res.acolarPrioridad(prio, c1.primero());
				prio--;
				c1.desencolar();
			}
			else if (c1.prioridad() < c2.prioridad()) {
				
				res.acolarPrioridad(prio, c2.primero());
				c2.desencolar();
				prio--;
				
				res.acolarPrioridad(prio, c1.primero());
				c1.desencolar();
			}
			else if (c1.prioridad() == c2.prioridad()) {
				
				res.acolarPrioridad(prio, c1.primero());
				c1.desencolar();
				prio--;
				
				res.acolarPrioridad(prio, c2.primero());
				c2.desencolar();
			}
		}
		
		while(!c2.colaVacia()) {
			res.acolarPrioridad(prio, c2.primero());
			prio--;
			c2.desencolar();
		}
		
		return res;
	}

}

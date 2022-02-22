package main.exercises;

import main.impl.cola.ColaPrioridadDinamica;
import main.utils.ColaPrioridadUtils;

public class EjercicioColaPrioridad {
	
	// TODO Debuggear este metodo para corregir el pequeño error
	// TODO revisar foto de la galeria para ver como correr el ejemplo
	/*
	 * A partir del TDA Cola con prioridades definido, escribir un método que permita
		a) Combinar dos colas con prioridades CP1 y CP2, generando una nueva 
		cola con prioridades. Considerar que a igual prioridad, los elementos de la CP1 
		son más prioritarios que los de la CP2.
	 */
	public static ColaPrioridadDinamica mergeColas(ColaPrioridadDinamica cola1, ColaPrioridadDinamica cola2) {
		
		ColaPrioridadDinamica res = new ColaPrioridadDinamica();
		ColaPrioridadDinamica c1 = ColaPrioridadUtils.copiarCola(cola1);
		ColaPrioridadDinamica c2 = ColaPrioridadUtils.copiarCola(cola2);
		
		int prio = 5;
		
		while(!c1.colaVacia() && !c2.colaVacia()) {
			if(c1.prioridad() > c2.prioridad()) {
				
				res.acolarPrioridad(c1.primero(), prio);
				c1.desencolar();
				prio--;
			}
			else if (c1.prioridad() < c2.prioridad()) {
				
				res.acolarPrioridad(c2.primero(), prio);
				c2.desencolar();
				prio--;
			}
			else if (c1.prioridad() == c2.prioridad()) {
				
				res.acolarPrioridad(c1.primero(), prio);
				c1.desencolar();
				prio--;
				
				res.acolarPrioridad(c2.primero(), prio);
				c2.desencolar();
				prio--;
			}
		}
		
		while(!c1.colaVacia()) {
			res.acolarPrioridad(c1.primero(), prio);
			prio--;
			c1.desencolar();
		}
		
		while(!c2.colaVacia()) {
			res.acolarPrioridad(c2.primero(), prio);
			prio--;
			c2.desencolar();
		}
		
		return res;
	}
	
	public static void mainMergeColas() {
		ColaPrioridadDinamica c1 = new ColaPrioridadDinamica();
		c1.acolarPrioridad(11, 8);
		c1.acolarPrioridad(22, 7);
		c1.acolarPrioridad(11, 6);
		c1.acolarPrioridad(7, 6);
		
		ColaPrioridadDinamica c2 = new ColaPrioridadDinamica();
		c2.acolarPrioridad(9, 9);
		c2.acolarPrioridad(13, 8);
		c2.acolarPrioridad(15, 7);
		c2.acolarPrioridad(7, 6);
		
		ColaPrioridadDinamica res = mergeColas(c1, c2);
		ColaPrioridadUtils.mostrarCola(res);
	}
	
	
	
//	6) A partir del TDA Cola con prioridades definido, escribir un método que permita	
//	b) Determinar si dos Colas con prioridad son idénticas
	public static void mainColasIdenticas() {
		
		ColaPrioridadDinamica c1 = new ColaPrioridadDinamica();
		c1.acolarPrioridad(1, 2);
		c1.acolarPrioridad(1, 3);
		
		ColaPrioridadDinamica c2 = new ColaPrioridadDinamica();
		c2.acolarPrioridad(1, 2);
		c2.acolarPrioridad(1, 3);
		
		System.out.println(ColaPrioridadUtils.sonIguales(c1, c2));
	}

}

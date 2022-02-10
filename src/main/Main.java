package main;

import main.exercises.EjercicioDiccionarios;
import main.impl.diccionario.DiccionarioMultipleEstatico;
import main.interfaces.DiccionarioMultipleTDA;
import main.utils.DiccionarioUtils;


public class Main {

	public static void main(String[] args) {
		
		DiccionarioMultipleTDA m = new DiccionarioMultipleEstatico();
		m.agregar(1, 2);
		m.agregar(1, 3);
		m.agregar(2, 3);
		m.agregar(2, 1);
		m.agregar(2, -4);
		m.agregar(3, 1);
		m.agregar(3, -4);
		DiccionarioUtils.mostrarDiccionario(EjercicioDiccionarios.m2s(m));
		

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

package main;

import main.exercises.EjercicioColas;
import main.impl.cola.ColaEstatica;
import main.interfaces.ColaTDA;

public class Main {

	public static void main(String[] args) {
		
		ColaTDA cola = new ColaEstatica();
		cola.acolar(1);
		cola.acolar(2);
		cola.acolar(3);
		cola.acolar(4);
		cola.acolar(5);
		cola.acolar(6);
		
		ColaTDA cola2 = new ColaEstatica();
		cola2.acolar(6);
		cola2.acolar(5);
		cola2.acolar(4);
		cola2.acolar(3);
		cola2.acolar(2);
		cola2.acolar(1);
		System.out.println(EjercicioColas.esInversa(cola, cola2));
		
	}


}

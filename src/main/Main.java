package main;

import main.exercises.EjercicioPilas;
import main.impl.pila.PilaDinamica;
import main.interfaces.PilaTDA;

public class Main {

	public static void main(String[] args) {
				
		PilaTDA p1 = new PilaDinamica();
		p1.apilar(1);
		p1.apilar(2);
		p1.apilar(3);
		p1.apilar(4);
		
		
		PilaTDA p2 = new PilaDinamica();
		p2.apilar(1);
		p2.apilar(2);
		p2.apilar(3);
		p2.apilar(4);
		p2.apilar(5);

		
		System.out.println(EjercicioPilas.sonIguales(p1, p2));
	}
}

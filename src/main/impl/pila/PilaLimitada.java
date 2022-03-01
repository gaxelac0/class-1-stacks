package main.impl.pila;

import main.interfaces.PilaLimitadaTDA;

public class PilaLimitada implements PilaLimitadaTDA {
	
	int limite = 0;
	int[] a;
	int cant;

	// cte
	@Override
	public void inicializarPila(int lim) {
		limite = lim;
		a = new int[lim];
		cant = 0;
	}

	// lineal en el peor de los casos
	@Override
	public void apilar(int x) {
		
		if(cant + 1 > limite) {
			
			for(int i = 0; i < cant-1; i++) {
				a[i] = a[i+1];
			}
			a[cant-1] = x;
		}
		else {
			
			a[cant] = x;
			cant++;
		}
	}

	@Override
	public void desapilar() { // cte
		cant--;
	}

	@Override
	public int tope() { // cte
		return a[cant-1];
	}

	@Override
	public boolean pilaVacia() { // cte
		return (cant==0);
	}

}

package main.interfaces;

public interface PilaLimitadaTDA {
	
	// precondicion: limite >= 1
	public void inicializarPila(int limite);
	
	// precondicion: pila inicializada
	public void apilar(int x);
	
	// precondicion: pila inicializada y no vacia
	public void desapilar();
	
	// precondicion: pila inicializada y no vacia
	public int tope();
	
	// precondicion: pila inicializada
	public boolean pilaVacia();

}

package main.interfaces;

public interface PilaTDA {
	
	public void apilar(int x); // req. pila inicializada
	public void desapilar();  // req. pila inicializada y no vacia
	public int tope();  // req. pila inicializada y no vacia
	public boolean pilaVacia();  // req. pila inicializada
	public void inicializarPila(); // sin precondiciones

}

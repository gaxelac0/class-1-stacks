package main.interfaces;

public interface ColaPrioridadTDA {
	
	public void inicializarCola();
	public void acolarPrioridad(int prioridad, int valor);
	public void desencolar();
	public boolean colaVacia();
	public int primero();
	public int prioridad();

}

package main.interfaces;

public interface ColaPrioridadTDA {
	
	public void inicializarCola();
	public void acolarPrioridad(int x, int prioridad);
	public void desencolar();
	public boolean colaVacia();
	public int primero();
	public int prioridad();

}

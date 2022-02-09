package main.interfaces;

public interface ColaParcialTDA {
	
	public void inicializarCola();
	public void acolarIzquierda(int x);
	public void acolarDerecha(int x);
	public void desacolarIzquierda();
	public void desacolarDerecha();
	public int izquierda();
	public int derecha();
	public boolean colaVacia();

}

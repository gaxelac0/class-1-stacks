package main.interfaces;

public interface ConjuntoTDA {
	
	public void inicializarConjunto();
	public void agregar(int x);
	public void quitar(int x);
	public int elegir();
	public boolean conjuntoVacio();
	public boolean pertenece(int x);

}

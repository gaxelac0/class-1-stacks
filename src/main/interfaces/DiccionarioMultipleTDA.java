package main.interfaces;

public interface DiccionarioMultipleTDA {
	
	public void inicializarDiccionario();
	public void agregar(int key, int value);
	public void eliminarClave(int key);
	public void eliminarValor(int key, int value);
	public ConjuntoTDA recuperar(int key);
	public ConjuntoTDA claves();

}

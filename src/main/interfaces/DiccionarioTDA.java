package main.interfaces;

public interface DiccionarioTDA {
	
	public void inicializarDiccionario();
	public void agregar(int key, int valor);
	public void eliminar(int key);
	public int recuperar(int key);
	public ConjuntoTDA claves();
}

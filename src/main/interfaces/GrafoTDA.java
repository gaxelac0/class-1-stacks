package main.interfaces;

public interface GrafoTDA {
	
	public void inicializarGrafo();
	public void agregarVertice(int valor);
	public void eliminarVertice(int valor);
	public void agregarArista(int v1, int v2, int peso);
	public void eliminarArista(int v1, int v2);
	public ConjuntoTDA vertices();
	public boolean existeArista();
	public void grafoVacio();
}

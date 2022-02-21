package main.interfaces;

public interface GrafoTDA {
	
	public void inicializarGrafo(); // ninguna
	public void agregarVertice(int valor); // grafo inicializado, vertice no existe
	public void eliminarVertice(int valor); // grafo inicializado, existe el vertice
	public void agregarArista(int v1, int v2, int peso); // grafo inicializado existen las dos vertices y no exista ya la arista
	public void eliminarArista(int v1, int v2); // grafo inicializado existe la arista
	public ConjuntoTDA vertices(); // grafo inicializado
	public boolean existeArista(int v1, int v2); // grafo inicializado
	public int pesoArista(int v1, int v2);
}

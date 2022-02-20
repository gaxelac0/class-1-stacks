package main.interfaces;

public interface ABBTDA {
	
	public void inicializarArbol();
	public int raiz();
	public ABBTDA hijoIzq();
	public ABBTDA hijoDer();
	public void agregarElem(int x);
	public void eliminarElem(int x);
	public boolean arbolVacio();

}

package main;

import main.impl.conjunto.ConjuntoDinamico;
import main.impl.diccionario.DiccionarioSimpleDinamico;
import main.interfaces.DiccionarioSimpleTDA;
import main.utils.ConjuntoUtils;
import main.utils.DiccionarioUtils;

public class Main {

	public static void main(String[] args) {
		
		DiccionarioSimpleTDA d = new DiccionarioSimpleDinamico();
		d.agregar(101, 0);
		d.agregar(44, 30);
		d.agregar(-22, 66);
		d.agregar(8, 34);
		
		d.eliminar(-22);
		
		DiccionarioUtils.mostrarDiccionario(d);
		
		ConjuntoUtils.mostrarConjunto((ConjuntoDinamico)d.claves());

	}
}

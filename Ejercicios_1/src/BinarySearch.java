/*
 Autor: Linda Nayeli Abundis Lopez   A01636416
 Nombre de la clase: BinarySearch.java
 Fecha: 09 de enero de 2020
 Comentarios: Pensar recursivamente todavia me toma un tiempo considerable
 */


public class BinarySearch{

//--------------------------------------------------------------------------------------- BinarySearch
	public static <E extends Comparable<E>>int binarySearch(E[] arreglo, E valor) {
		int min = 0,
		    max = arreglo.length-1,
		    avg;
		
		while(min <= max) {
			avg = (min + max)/2;
			if(valor.equals(arreglo[avg])) {
				return avg;
			}else if(valor.compareTo(arreglo[avg])<0) {    // < es solo para primitivos        compareTo   es para objetos
				max = avg - 1;
			}else {
				min = avg + 1;
			}
		}
		return -1;
	}
	
//--------------------------------------------------------------------------------------- BinarySearch	RECURSIVO
	
	public static <E extends Comparable<E>> int binarySearchRec(E[ ] valores,E valor) {                                     // Funcion de preparacion
		return binarySearchRec(valores, 0, valores.length-1, valor);
	}
	
	private static <E extends Comparable<E>> int binarySearchRec(E[ ] valores,int min,int max,E valor) {                    //Funcion recursiva
		if(min <= max) {
			int avg = (min + max)/2;
			if(valor.equals(valores[avg])) {
				return avg;
			}else if(valor.compareTo(valores[avg])<0) {
				return binarySearchRec(valores,  min, avg - 1, valor);
			}else{
				return binarySearchRec(valores, avg + 1, max, valor);
			}
		}else {
			return -1;
		}
	}

	
//-------------------------------------------------------------------------------------- MAIN
	public static void main(String[] args) {
		Integer[] arreglo = {10,15,19,31,33,35,50,53,63,75,79,90,99};                // Si le pongo static en public static int binSearchRec, ya no neceito crae una indtancia (OBJETO)
		Double[] arreglo2 = {10.0,15.0,19.0,31.0};
		String[] arreglo3 = {"Abundis", "Becerra", "Cardenas", "Fernandez"};
		//System.out.println(binarySearch(arreglo, 79));                              // Genericos solo trabaja con tipos de datos referenciados (Objetos)
		//System.out.println(binarySearch(arreglo2, 19.0));
		//System.out.println(binarySearch(arreglo3, "Fernandez"));
		
		System.out.println(binarySearchRec(arreglo, 79));
		System.out.println(binarySearchRec(arreglo2, 19.0));
		System.out.println(binarySearchRec(arreglo3, "Fernandez"));
		
	}
	
}

//si regreso un generico y no lo encuentra se le pone return "null"


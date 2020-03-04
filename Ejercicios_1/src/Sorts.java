import java.nio.channels.Pipe;

public class Sorts {
	
//------------------------------------------------------------------------------------------------------------------------ BUBBLE SORT
	public static <E extends Comparable<E>> void blubbleSort(E[] valores) {
		for(int i=0; i<valores.length-1; i++) {
			for(int j=0; j<valores.length-1-i; j++) {                          // -i    porque nos vamos deteniendo donde ya tenemos los ordenados
				if(valores[j].compareTo(valores[j+1])>0) {
					swap(valores, j, j+1);
				}
			}
		}
	}
	
	
	public static <E> void imprimeArreglo(E[] arreglo) {
		for(E tmp: arreglo) {
			System.out.print(tmp + ",");
		}
		System.out.println();
	}
	
	
	private static <E> void swap(E[] arreglo, int i, int j) {
		E tmp = arreglo[i];
		arreglo[i] = arreglo[j];
		arreglo[j] = tmp;
	}
	
//------------------------------------------------------------------------------------------------------------------------ MERGE SORT

	public static <E extends Comparable <E>> void mergesort(E[] arreglo) {
		mergesort(arreglo, 0, arreglo.length-1);
	}
	
	
	private static <E extends Comparable <E>> void mergesort(E[] arreglo, int inicio, int fin) {
		if(inicio < fin) {
			int central = (inicio + fin) / 2;
			mergesort(arreglo, inicio, central);
			mergesort(arreglo,central + 1, fin);
			mezcla(arreglo, inicio, fin);
		}
		
		
	}
	
	private static <E extends Comparable <E>> void mezcla(E[] arreglo, int inicio, int fin) {
		int central = (inicio + fin) / 2,
			i = inicio,
			j = central + 1;
		E[] temp = (E[]) new Comparable[fin - inicio + 1];  //    E[] temp = (E[]) new Object[arreglo.length];     Si no tuviera el <E extends Comparable <E>>
		
		for(int a=0; a<temp.length; a++) {
			if(arreglo[i].compareTo(arreglo[j])<=0 ) {
				temp[a] = arreglo[i];
				i++;
				if(i>central-inicio+1) {
					a++;
					for(int b=0; b<fin-central+2-j; b++) {
						temp[a] = arreglo[j];
						j++;
						a++;
					}
				}
			}else {
				temp[a] = arreglo[j];
				j++;
				if(j>fin-central+2) {
					a++;
					for(int b=0; b<central-inicio+1-i; b++) {
						temp[a] = arreglo[i];
						i++;
						a++;
					}
			}
		}
	}
}

	
//------------------------------------------------------------------------------------------------------------------------ QUICK SORT	
	
	
    public static <E extends Comparable<E>> void quicksort(E[] arreglo) {
		quicksort(arreglo, 0, arreglo.length-1);
	}


	private static <E extends Comparable<E>> void quicksort(E[] arreglo, int inicio, int fin) {
		if(inicio < fin) {
			int posPivote = particionar(arreglo, inicio, fin);
			quicksort(arreglo, inicio, posPivote);
			quicksort(arreglo, posPivote+1, fin);
		}
	}
	
	private static <E extends Comparable<E>> int particionar(E[] arreglo, int inicio, int fin) {
		//Regresa la poscision donde quedo el pivote
		
		E pivote = arreglo[inicio];
		int i = inicio+1;
		boolean bandera = false;
	
		for(int j=inicio+1; j<fin;j++) {
			if(arreglo[j].compareTo(pivote)<0) {
				bandera = true;
				swap(arreglo, j, i);
				i++;
			}
		}
		if(bandera) {
			swap(arreglo, inicio, i-1);
		}
		return i-1;
	}
		
		
		
		

	

	
	
//------------------------------------------------------------------------------------------------------------------------ MAIN
	public static void main(String[] args) {
		//Integer[] arreglo = {10,150,19,31,33,350,500,53,63,7500,79,990,99};  
		Integer[] arreglo = {3,8,2,5,1,4,7,6}; 
		Double[] arreglo2 = {100.0,15.0,190.0,31.0,1.0};
		String[] arreglo3 = {"Nabundis", "Becerra", "Ardenas", "Fernandez"};
		//blubbleSort(arreglo); 
		//imprimeArreglo(arreglo);
		//blubbleSort(arreglo2); 
		//imprimeArreglo(arreglo2);
		//blubbleSort(arreglo3); 
		//imprimeArreglo(arreglo3);
		
		//mergesort(arreglo); 
		//imprimeArreglo(arreglo);
		//mergesort(arreglo2); 
		//imprimeArreglo(arreglo2);
		//mergesort(arreglo3); 
		//imprimeArreglo(arreglo3);
		
		quicksort(arreglo); 
		imprimeArreglo(arreglo);
		//quicksort(arreglo2); 
		//imprimeArreglo(arreglo2);
		//quicksort(arreglo3); 
		//imprimeArreglo(arreglo3);
		
		
		
	}
	

}

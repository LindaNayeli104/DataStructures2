/*
 Autor: Linda Nayeli Abundis Lopez   A01636416
 Nombre de la clase: MyHeap.java
 Fecha: 28 de enero de 2020
 Comentarios: No supe porqué me mandaba la excepción "java.lang.ClassCastException: [Ljava.lang.Comparable; cannot be cast to [Ljava.lang.Integer;"
                 cuando quería imprimir el heap después de hacer un push, sin embargo al hacer la impresión directamente en la función
                 "push" todo se imprimía perfectamente .
 */


public class MyHeap <E extends Comparable<E>> {

	private E[] heap;
	private int size;

	public MyHeap() {
		this.heap = (E[]) new Comparable[20];
		this.size = 0;
	}

	public MyHeap(E[] datos) {  
		//hacer heapify
		this.heap=datos;
		this.size = datos.length;   //suponemos que siempre nos pasan el arreglo lleno
		heapify(heap);

	}

	private void heapify(E[] datos) {                                 // padre: (pos-1)/2       hijo:  2 * pos + (left ? 1: 2)
		//poner el arreglo con las condiciones de heap
		int current = this.size / 2 - 1;
		int left;
		int right;
		while(current >= 0) {
			left = 2 * current + 1;
			right = 2 * current + 2;
			if(left < this.size && right < this.size) {
				if(heap[current].compareTo(heap[left])<0 || heap[current].compareTo(heap[right])<0) {
					if(heap[left].compareTo(heap[right])>0) {
						swap(left, current);
						fixBelow(left);
					}
					else{
						swap(right, current);
						fixBelow(right);	
					}
				}
			}
			else if(left < this.size && right >= this.size) {
				if(heap[current].compareTo(heap[left])<0) {
					swap(left, current);
					fixBelow(left);
				}
			}
			current--;
		}

	}

	private void fixBelow(int current) {
		int left;
		int right;
		boolean bandera = true;
		while(heap[current] != null && bandera != false) {
			bandera = false;
			left = 2 * current + 1;
			right = 2 * current + 2;

			if(left < this.size && right < this.size) {
				if(heap[current].compareTo(heap[left])<0 || heap[current].compareTo(heap[right])<0) {
					if(heap[left].compareTo(heap[right])>0) {
						swap(left, current);
						current = left;
						bandera = true;
					}
					else{
						swap(right, current);
						current = right ;
						bandera = true;
					}
				}
			}
			else if(left < this.size && right >= this.size) {
				if(heap[current].compareTo(heap[left])<0) {
					swap(left, current);
					current = left;
					bandera = true;
				}
			}
		}
		return;
	}       

	private void fixAbow(int current) {
		int parent;
		boolean bandera = true;
		while(current > 0 && bandera != false) {
			bandera = false;
			parent = (current-1)/2 ;

			if(heap[parent].compareTo(heap[current]) < 0) {
				swap(parent, current);
				bandera = true;
			}
			current = parent;
		}
		return;
	} 

	public void push(E dato) {
		if(this.size == this.heap.length) {   //Crecer el arreglo
			E[] aux = (E[]) new Comparable[this.heap.length + 20];

			for (int i = 0; i < this.size; i++) {
				aux[i] = this.heap[i];
			}
			this.heap = aux;
		}
		this.heap[this.size] = dato;  
		fixAbow(size);
		this.size++;
	}

	private void swap(int pos1, int pos2) {
		E aux = this.heap[pos1];
		this.heap[pos1] = this.heap[pos2];
		this.heap[pos2] = aux;
	}

	public E pop() {
		E res = this.heap[0];
		this.heap[0] = heap[this.size-1];   
		heap[this.size-1] = res;
		this.size--;
		fixBelow(0);
		/*
		for (int i = 0; i < size; i++) {
			System.out.println(heap[i]);
		}
		 */
		return res;
	}

	public static void main(String[] args) {
		//Integer[] datos = {12,3,8,15,20,1};
		Integer[] datos = {15,60,72,70,56,32,62,92,49,30,71,100,45,79};
		//Integer[] datos = {44,42,35,33,31,19,27,10,26,14};
		MyHeap<Integer> heap_1 = new MyHeap<Integer>(datos);
		for (int i = 0; i < heap_1.size; i++) {
			System.out.println(heap_1.heap[i]);
		}
	
		//heap.push(38);
		//heap.push(20);

		//heap_1.push(25);


		//System.out.println("size aaaaa= " + heap_1.heap.length);
		/*
		heap_1.push(38);
		 */
		/*

		System.out.println("size= " + heap_1.size);
		System.out.println("--------------------------------------------");

		heap_1.push(25);

		for (int i = 0; i < heap_1.size; i++) {
			System.out.println(heap_1.heap[i]);
		}
		System.out.println("size= " + heap_1.size);

		 */
		/*
		heap_1.pop();

		for (int i = 0; i < heap_1.size; i++) {
			System.out.println(heap_1.heap[i]);
		}
		System.out.println("size= " + heap_1.size);
		 */
	}
}

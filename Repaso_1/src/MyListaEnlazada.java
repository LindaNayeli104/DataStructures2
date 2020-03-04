/*
 Autor: Linda Nayeli Abundis Lopez   A01636416
 Nombre de la clase: MyListaEnlazada.java
 Fecha: 15 de enero de 2020
 Comentarios: Me gustó aclarar la parte de la complejidad computacional
 */


import java.util.NoSuchElementException;

public class MyListaEnlazada<E> {

	protected MyNodo<E> first;

	protected MyNodo<E> last;

	protected int size;

	public MyListaEnlazada() {
		this.first = this.last = null;
		this.size = 0;
	}

	public MyListaEnlazada(E[] datos) {                                            
		for(int i=0; i<datos.length; i++) {
			insertLast(datos[i]);
		}
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.first == null;
	}

	public E first() {
		return this.first.valor;
	}

	public E last() {
		return this.last.valor;
	}

	public void insertFirst(E valor) {
		MyNodo<E> nvo = new MyNodo<>(valor,this.first);
		if(isEmpty()) {

			this.last = nvo; 
		}
		this.first = nvo;
		this.size++;
	}

	public void insertLast(E valor) {
		if(isEmpty()) {
			//this.first = this.last = nvo;
			this.insertFirst(valor);
		}else {
			MyNodo<E> nvo = new MyNodo<>(valor);
			this.last.setNext(nvo);
			this.last = nvo;
			this.size++;
		}


	}

	public E removeFirst() {             // Orden constante
		try {
			E tmp = this.first.valor;
			this.first = this.first.next;
			size--;
			return tmp;
		}catch (NullPointerException e) {
			throw new NoSuchElementException("No se puede hacer un remove de una lista vacia");
		}
	}

	public E removeLast() {                     //Orden lineal    
		try {
			MyNodo<E> current = this.first;
			E res = this.last.valor;

			for(int i=0; i<this.size-2; i++) {
				current = current.next;
			}

			current.next = null;
			this.last = current;
			this.size--;
			return res;
		}catch(NullPointerException e) {
			throw new NoSuchElementException("No se puede hacer un remove de una lista vacia");
		}

	}
	//---------------------------------------------------------------------------- TAREA

	public void insertAt(int pos, E valor) {        //Arroja una exceocion cuando la podicion es invalida
		try {
			if(pos == 0) {
				insertFirst(valor);
				return;
			}else if(this.size == pos) {
				insertLast(valor);
				return;
			}

			MyNodo<E> nvo = new MyNodo<>(valor);
			MyNodo<E> current = this.first;


			for(int i=0; i<pos-1; i++) {
				current = current.next;
			}

			nvo.next = current.next;
			current.next = nvo;
			this.size++;
		}catch(NullPointerException e) {
			throw new NoSuchElementException("No se puede insertar un valor en la posicion " + pos + " en una lista de tamaño " + this.size);
		}
	}


	public E removeAt(int pos) {             //Arroja una exceocion cuando la podicion es invalida
		try {

			if(pos == 0) {
				return removeFirst();
			}
			MyNodo<E> current = this.first;


			for(int i=0; i<pos-1; i++) {
				current = current.next;
			}

			E res = current.next.valor;
			current.next = current.next.next;
			size--;
			return res;
		}catch(NullPointerException e) {
			throw new NoSuchElementException("No se puede eliminar un valor en la posicion " + pos + " en una lista de tamaño " + this.size);
		}

	}


	public void flush() {
		this.first = this.last = null;
		this.size = 0;
		System.gc();
	}

	public E getAt(int pos) {    //Obtener el valor de una posicion
		try {
			MyNodo<E> current = this.first;

			for(int i=0; i<pos; i++) {
				current = current.next;
			}

			E res = current.valor;
			return res;
		}catch(NullPointerException e) {
			throw new NoSuchElementException("No se puede obtener un valor de la posicion " + pos + " en una lista de tamaño " + this.size);
		}
	}




	public void setAt(int pos, E valor) {
		try {
			MyNodo<E> current = this.first;

			for(int i=0; i<pos; i++) {
				current = current.next;
			}

			current.valor = valor;

		}catch(NullPointerException e) {
			throw new NoSuchElementException("No se puede colocar un valor en la posicion " + pos + " en una lista de tamaño " + this.size);
		}
	}




	public String toString() {
		String res = "";
		MyNodo<E> current = this.first;

		while(current != null) {
			res += current.getValor() + ",";
			current = current.getNext();
		}

		return res;
	}

	//------------------------------------------------------------------------------------------------------------------- Repaso

	public void desplazarLista(int pos) {       //Desplazar pos lugares hacia la izquierda

		if(pos>0) {
			MyNodo<E> current = this.first;
			MyNodo<E> next = this.first.next;
			MyNodo<E> fin = this.first;

			for (int i = 0; i < pos-1; i++) {
				current = current.next;
			}

			next = current.next;

			for (int i = 0; i < size-1; i++) {               
				fin = fin.next;
			}

			fin.next = this.first;
			current.next = null;
			this.first = next;
			this.last = current;
		}else {
			return;
		}
	}


	public E mitad(MyListaEnlazada<E> lista) {
		MyNodo<E> current = first;
		MyNodo<E> next = first.next;

		while(next != null ) {
			if(next.next == null) {
				current = current.next;	
				return current.valor;
			}else {
				next = next.next.next;
			}
			current = current.next;	
		}
		return current.valor;
	}
	


	//------------------------------------------------------------------------------------------------------------------ MAIN
	public static void main(String[] args) {
		/*
		Integer[] arreglo = {1,2,3,4,5};
		MyListaEnlazada<Integer> lista = new MyListaEnlazada<>(arreglo);
		System.out.println(lista);
		System.out.println(lista.mitad(lista));
		*/
		
		String[] arreglo_s = {"A", "A", "A", "B", "C", "C"};
		MyListaEnlazada<String> lista = new MyListaEnlazada<>(arreglo_s);
		System.out.println(lista);
		System.out.println(lista.mitad(lista));

	}

}


class MyNodo<E>{

	E valor;
	MyNodo<E> next;

	//---------------------------------------------------------------------------------- CONSTRUCTORES

	public MyNodo(E valor, MyNodo<E> next) {
		super();
		this.valor = valor;
		this.next = next;
	}

	public MyNodo(E valor) {
		this(valor,null);             //Hace referencia al condtructor de la clase

	}

	//---------------------------------------------------------------------------------- GETTERS Y SETTERS
	public E getValor() {
		return valor;
	}


	public void setValor(E valor) {
		this.valor = valor;
	}


	public MyNodo<E> getNext() {
		return next;
	}


	public void setNext(MyNodo<E> next) {
		this.next = next;
	}


	public String toString() {
		return this.valor.toString();
	}








}

//static es de clase



/*
 Autor: Linda Nayeli Abundis Lopez   A01636416
 Nombre de la clase: MyABB.java
 Fecha: 28 de enero de 2020
 Comentarios: Se me dificultó hacer la función "nivel" sin usar una cola.
 */


import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Stack;

import javax.sound.midi.Soundbank;

public class MyABB<E extends Comparable<E>>  {

	protected MyNodoABB<E> raiz;

	protected int size = 0;

	public MyABB() {
		super();
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.raiz == null;
	}

	public void flush() {
		this.raiz = null;
		this.size = 0;
		System.gc();
	}

	public void insertar(E dato) {                                 

		MyNodoABB<E> current =  this.raiz;
		MyNodoABB<E> nvo =  new MyNodoABB(dato);

		if(current == null) {
			this.raiz = nvo;              

		}else {

			while(current != null) {
				if(dato.compareTo(current.value) == 0) {           //igual que equals , pero preferible mandar a llamar  
					return;                                          //equals porque es de la clase object que tienen todos los objetos 
				}else if(dato.compareTo(current.value)<0) {            //por default y compareTo se tiene que heredar (extra)
					if(current.left != null) {
						current = current.left;
					}else {
						current.left = nvo;
						this.size++;
						break;
					}
				}else {
					if(current.right != null) {
						current = current.right;
					}else {
						current.right = nvo;
						this.size++;
						break;
					}
				}
			}
		}
	}


	public E borrar(E dato) {
		MyNodoABB<E> parent = this.raiz,
				current = null;
		E res;

		if(this.raiz == null) {
			throw new NoSuchElementException("Árbol vacío, no se encuentra el elemento");
		}

		else if(dato.equals(this.raiz.value)) {    //Caso en que vamos a borrar la raiz
			res = this.raiz.value;
			E value = this.raiz.value;
			if(this.raiz.left == null && this.raiz.right == null) {
				this.raiz = null;
				this.size--;
			}
			else if(this.raiz.right == null) {
				this.raiz = this.raiz.left;
				this.size--;
			}else if(this.raiz.left == null) {
				this.raiz = this.raiz.right;
				this.size--;
			}else {
				E predecesor = this.predecesor(this.raiz);
				this.borrar(predecesor);
				this.raiz.value = predecesor;
			}
			return res;

			//Moveremos parenthasta poscicionarlo en el padre del nodo a borrar

		}else {
			while(parent!= null) {
				try {
					if(dato.compareTo(parent.value) <0) {         //El dato que quiero borrar esta a la left de donde esta parent
						if(dato.equals(parent.left.value)) {
							current = parent.left;
							break;
						}else {
							parent= parent.left; 
						}
					}else {                                         //El dato que quiero borrar esta a la right de donde esta parent
						if(dato.equals(parent.right.value)) {
							current = parent.right;
							break;
						}else {
							parent= parent.right; 
						}
					} 
				}catch(NullPointerException e) {
					throw new NoSuchElementException("No se encontró el elemento en el árbol");
				}

			}
			res = current.value;

			//Aqui parent ya esta en el nodo padre del nodo a borrar
			//1) Es un nodo hoja el nodo a borrar

			if(current.left == null && current.right == null) {
				if(parent.left == current) {                          //********************
					parent.left = null;
				}else {
					parent.right = null;
				}
				this.size--;
			}

			//2.1) Tiene un hijo y es el left

			else if(current.right == null) {
				if(parent.left == current) {                          //************** Caso explicito de cuando usar "==" en objetos, porque son referencias
					parent.left = current.left;
				}else {
					parent.right = current.left;
				} 
				this.size--;
				return current.value; //----------------------------------
				//2.2) Tiene un hijo y es el right
			}else if(current.left == null) {
				if(parent.left == current) {                          //************** Caso explicito de cuando usar "==" en objetos, porque son referencias
					parent.left = current.right;
				}else {
					parent.right = current.right;
				} 
				this.size--;
				return current.value; //----------------------------------

			}
			//3) Tiene 2 hijos
			else {
				E predecesor = this.predecesor(current);
				this.borrar(predecesor);
				current.value = predecesor;
			}
			return res;
		}
	}

	private E predecesor(MyNodoABB<E> current) {
		current = current.left;
		while(current.right != null) {
			current = current.right;
		}

		return current.value;
	}

	//---------------------------------------------------------------------------------------- Recorridos por prufundidad


	public void preorden() {          // Funcion de preparacion
		preorden(this.raiz);
		System.out.println();
	}	

	private void preorden(MyNodoABB<E> current) {
		if(current != null) {
			System.out.print(current.value + ",");
			preorden(current.left);
			preorden(current.right);
		}
	}

	public void inorden() {          // Funcion de preparacion
		inorden(this.raiz);
		System.out.println();
	}	

	private void inorden(MyNodoABB<E> current) {
		if(current != null) {
			inorden(current.left);
			System.out.print(current.value + ",");
			inorden(current.right);
		}
	}


	public void postorden() {          // Funcion de preparacion
		postorden(this.raiz);
		System.out.println();
	}	

	private void postorden(MyNodoABB<E> current) {
		if(current != null) {
			postorden(current.left);
			postorden(current.right);
			System.out.print(current.value + ",");
		}
	}


//------------------------------------------------------------------------------------------------------ TAREA

	public void nivel() {
		Queue<MyNodoABB> cola=new LinkedList();
		nivel(this.raiz, cola);
	}

	public void nivel(MyNodoABB<E> current, Queue<MyNodoABB> cola) {    //Usar cola de java     Imprime separados por ","
		if(current != null) {
			System.out.print(current.value + ", ");

			if(current.left != null) {
				cola.add(current.left);
			}
			if(current.right != null) {
				cola.add(current.right);
			}
			if(cola.size() > 0) {
				nivel(cola.poll(), cola);
			}

		}
	}
	
	public void primos(E valor) {
		Stack<MyNodoABB<E>> pila = new Stack<>();
		MyNodoABB<E> current = this.raiz;
		
		while(!current.value.equals(valor)) {
			pila.push(current);
			if(valor.compareTo(current.value)<0) {
				current = current.left;
			}else {
				current = current.right;
			}
		}
		pila.pop();
		MyNodoABB<E> abuelo = pila.pop();
		MyNodoABB<E> tio;
		if(valor.compareTo(abuelo.value)<0) {
			tio = abuelo.right;
			if(tio.left != null){
				System.out.print(tio.left.value + ",");
			}
			if(tio.right != null){
				System.out.print(tio.right.value );
			}
			System.out.println();
		}else {
			tio = abuelo.left;
			if(tio.left != null){
				System.out.print(tio.left.value + ",");
			}
			if(tio.right != null){
				System.out.print(tio.right.value);
			}
			System.out.println();
		}
	}
	
	public void invertirArbol() {
		this.invertirArbol(this.raiz);
	}
	
	public void invertirArbol(MyNodoABB<E> current) {
		if(current != null) {
			invertirArbol(current.left);
			invertirArbol(current.right);
			MyNodoABB<E> aux = current.left;
			current.left = current.right;
			current.right = aux;
		}
	}
	
//------------------------------------------------------------------------------------------------------- MAIN 

	public static void main(String[] args) {
		MyABB<Integer> arbol = new MyABB<>();
		arbol.insertar(50);
		arbol.insertar(30);
		arbol.insertar(70);
		arbol.insertar(10);
		arbol.insertar(40);
		arbol.insertar(60);
		arbol.insertar(90);
		arbol.insertar(1);
		arbol.insertar(20);
		arbol.insertar(35);
		arbol.insertar(45);
		arbol.insertar(55);
		arbol.insertar(65);
		arbol.insertar(80);
		arbol.insertar(100);
		

		arbol.postorden();
		
		arbol.invertirArbol();
		
		arbol.preorden();
		arbol.inorden();
		arbol.postorden();
		
		//System.out.println("borrado: " + arbol.borrar(50));

		//arbol.preorden();
		//System.out.println();
		//arbol.inorden();
		//System.out.println();
		//arbol.postorden();
		//arbol.nivel();
	}
}

class MyNodoABB <E extends Comparable<E>>{

	MyNodoABB<E> left,
	right;

	E value;

	public MyNodoABB(E value) {    // Nodo hoja
		this(value, null, null);
	}

	public MyNodoABB(E value, MyNodoABB<E> left, MyNodoABB<E> right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public String toString() {
		return value.toString();
	}
}


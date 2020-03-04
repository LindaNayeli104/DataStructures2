/*
 Autor: Linda Nayeli Abundis Lopez   A01636416
 Nombre de la clase: MyABB.java
 Fecha: 28 de enero de 2020
 Comentarios: Se me dificult� hacer la funci�n "nivel" sin usar una cola.
 */


import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

import javax.sound.midi.Soundbank;

public class MyABB<E extends Comparable<E>>  {

	private MyNodoABB<E> raiz;

	private int size = 0;

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
				if(dato.compareTo(current.info) == 0) {           //igual que equals , pero preferible mandar a llamar  
					return;                                          //equals porque es de la clase object que tienen todos los objetos 
				}else if(dato.compareTo(current.info)<0) {            //por default y compareTo se tiene que heredar (extra)
					if(current.izq != null) {
						current = current.izq;
					}else {
						current.izq = nvo;
						this.size++;
						break;
					}
				}else {
					if(current.der != null) {
						current = current.der;
					}else {
						current.der = nvo;
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
			throw new NoSuchElementException("�rbol vac�o, no se encuentra el elemento");
		}

		else if(dato.equals(this.raiz.info)) {    //Caso en que vamos a borrar la raiz
			res = this.raiz.info;
			E info = this.raiz.info;
			if(this.raiz.izq == null && this.raiz.der == null) {
				this.raiz = null;
				this.size--;
			}
			else if(this.raiz.der == null) {
				this.raiz = this.raiz.izq;
				this.size--;
			}else if(this.raiz.izq == null) {
				this.raiz = this.raiz.der;
				this.size--;
			}else {
				E predecesor = this.predecesor(this.raiz);
				this.borrar(predecesor);
				this.raiz.info = predecesor;
			}
			return res;

			//Moveremos parenthasta poscicionarlo en el padre del nodo a borrar

		}else {
			while(parent!= null) {
				try {
					if(dato.compareTo(parent.info) <0) {         //El dato que quiero borrar esta a la izq de donde esta parent
						if(dato.equals(parent.izq.info)) {
							current = parent.izq;
							break;
						}else {
							parent= parent.izq; 
						}
					}else {                                         //El dato que quiero borrar esta a la der de donde esta parent
						if(dato.equals(parent.der.info)) {
							current = parent.der;
							break;
						}else {
							parent= parent.der; 
						}
					} 
				}catch(NullPointerException e) {
					throw new NoSuchElementException("No se encontr� el elemento en el �rbol");
				}

			}
			res = current.info;

			//Aqui parent ya esta en el nodo padre del nodo a borrar
			//1) Es un nodo hoja el nodo a borrar

			if(current.izq == null && current.der == null) {
				if(parent.izq == current) {                          //********************
					parent.izq = null;
				}else {
					parent.der = null;
				}
				this.size--;
			}

			//2.1) Tiene un hijo y es el izq

			else if(current.der == null) {
				if(parent.izq == current) {                          //************** Caso explicito de cuando usar "==" en objetos, porque son referencias
					parent.izq = current.izq;
				}else {
					parent.der = current.izq;
				} 
				this.size--;
				return current.info; //----------------------------------
				//2.2) Tiene un hijo y es el der
			}else if(current.izq == null) {
				if(parent.izq == current) {                          //************** Caso explicito de cuando usar "==" en objetos, porque son referencias
					parent.izq = current.der;
				}else {
					parent.der = current.der;
				} 
				this.size--;
				return current.info; //----------------------------------

			}
			//3) Tiene 2 hijos
			else {
				E predecesor = this.predecesor(current);
				this.borrar(predecesor);
				current.info = predecesor;
			}
			return res;
		}
	}

	private E predecesor(MyNodoABB<E> current) {
		current = current.izq;
		while(current.der != null) {
			current = current.der;
		}

		return current.info;
	}

	//---------------------------------------------------------------------------------------- Recorridos por prufundidad


	public void preorden() {          // Funcion de preparacion
		preorden(this.raiz);
	}	

	private void preorden(MyNodoABB<E> current) {
		if(current != null) {
			System.out.println(current.info + ",");
			preorden(current.izq);
			preorden(current.der);
		}
	}

	public void inorden() {          // Funcion de preparacion
		inorden(this.raiz);
	}	

	private void inorden(MyNodoABB<E> current) {
		if(current != null) {
			inorden(current.izq);
			System.out.println(current.info + ",");
			inorden(current.der);
		}
	}


	public void postorden() {          // Funcion de preparacion
		postorden(this.raiz);
	}	

	private void postorden(MyNodoABB<E> current) {
		if(current != null) {
			postorden(current.izq);
			postorden(current.der);
			System.out.println(current.info + ",");
		}
	}


//------------------------------------------------------------------------------------------------------ TAREA

	public void nivel() {
		Queue<MyNodoABB> cola=new LinkedList();
		nivel(this.raiz, cola);
	}

	public void nivel(MyNodoABB<E> current, Queue<MyNodoABB> cola) {    //Usar cola de java     Imprime separados por ","
		if(current != null) {
			System.out.print(current.info + ", ");

			if(current.izq != null) {
				cola.add(current.izq);
			}
			if(current.der != null) {
				cola.add(current.der);
			}
			if(cola.size() > 0) {
				nivel(cola.poll(), cola);
			}

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
		arbol.insertar(5);
		arbol.insertar(11);

		//System.out.println("borrado: " + arbol.borrar(50));

		//arbol.preorden();
		//System.out.println();
		//arbol.inorden();
		//System.out.println();
		//arbol.postorden();
		arbol.nivel();
	}
}

class MyNodoABB <E extends Comparable<E>>{

	MyNodoABB<E> izq,
	der;

	E info;

	public MyNodoABB(E info) {    // Nodo hoja
		this(info, null, null);
	}

	public MyNodoABB(E info, MyNodoABB<E> izq, MyNodoABB<E> der) {
		this.info = info;
		this.izq = izq;
		this.der = der;
	}

	public String toString() {
		return info.toString();
	}
}


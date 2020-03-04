import java.util.LinkedList;
import java.util.Queue;

public class MyQueue<E> {          // public class MyQueue<E> extends MyListaEnlazada<E> {   // Herencia  hereda todos los datos
	
	protected MyListaEnlazada<E> cola;   // Composicion
	
	public MyQueue() {
		this.cola = new MyListaEnlazada<>();
		
	}
	
	public int size() {
		return this.cola.size();
	}
	
	public void flush() {
		this.cola.size();
	}
	
	public boolean isEmpty() {
		return this.cola.isEmpty();
	}
	
	public void enqueue(E dato) {   //add
		this.cola.insertLast(dato);
	}

	  
	public E dequeue() {            //remove     //Evitar usar removeLast porque es "n"
		return this.cola.removeFirst();          // Constante   "1"
	}
	
	public E next() {
		return this.cola.first();
	}
	public String toString() {
		return this.cola.toString();
	}
	
	public static void main(String[] args) {
		Queue<Integer> cola = new LinkedList();
		
		for (int i = 0; i < 10; i++) {
			cola.add(i);
		}
		
		while(!cola.isEmpty()) {
			System.out.println(cola.remove());
		}
	}
}

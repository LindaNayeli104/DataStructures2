
public class MyStack<E> {
	
	private MyListaEnlazada<E> stack;
	
	public MyStack() {
		this.stack =new MyListaEnlazada<E>();
	}
	
	public E top() {
		return this.stack.first();
	}
	
	public void push(E valor){
		this.stack.insertFirst(valor);
	}
	
	public E pop() {
		return this.stack.removeFirst();
	}
	
	public boolean isEmpty() {
		return this.stack.isEmpty();
	}
	
	public int size() {
		return this.stack.size();
	}
	
	public void flush() {
		this.stack.flush();
	}
	
	public String toString() {
		return this.stack.toString();
	}
	
	public static void main(String[] args) {
		MyStack<Integer> pila = new MyStack<>();
		
		for (int i = 0; i < 10; i++) {
			pila.push(i);
		}
		
		while(!pila.isEmpty()) {
			System.out.println(pila.pop());
		}
		
		/*
		for (int i = 0; i < pila.size(); i++) {   // No se usa  porque el size cambia y hay un momento donde i=5 y size  5 y ya no se cumple
			System.out.println(pila.pop());
		}
		*/
	}
}

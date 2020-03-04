import java.util.LinkedList;
import java.util.Queue;

public class QueueNueva<E> extends MyQueue<E> {
	
	public QueueNueva() {
		super();
	}
	
	
	public void removeValue(E valor) {
		int i = 0;
		while(i < this.cola.size) {
			if(this.cola.getAt(i).equals(valor)) {
				this.cola.removeAt(i);
			}else {
				i++;
			}
		}
	}
		
		public static <T> void removeValue(MyStack<T> pila, T valor) {
			MyStack<T> tmp = new MyStack<T>();
			T dato;
			
			while(!pila.isEmpty()) {
				dato = pila.pop();
				if(!dato.equals(valor)) {
					tmp.push(dato);
				}
			}
			
			while(!tmp.isEmpty()) {
				pila.push(tmp.pop());
			}
		}
		
		
		
//------------------------------------------------------------------------------------------
		
	
	public MyQueue<E> reBuild(E valor) {
		MyQueue<E> colaRes = new MyQueue<E>();
		while(!isEmpty()) {
			E num = this.dequeue();
			
			if(num != valor) {
				colaRes.enqueue(num);
			}
		}
		return colaRes;
	}
	
	/*
	 	public class QueueNueva<E> extends MyQueue<E> {
		
		
		
		public QueueNueva() {
			super();
		}
		
		public void reBuild(E valor) {
			Queue colaRes = new LinkedList();
			for (int i = 0; i < cola.size(); i++) {
				
				if(cola.dequeue() == valor) {
					colaRes.add(i);
				}
			}
		}
		*/
//----------------------------------------------------------------------------------------
	

	public static void main(String[] args) {
		//Integer[] arr = {5,20,15,9,20,12,20,20,20,0,1,2,3,4,5,6,7,8,9,20};
		Integer[] arr = {20,5,20,15,9,20};
		QueueNueva<Integer> cola = new QueueNueva<>();
		MyStack<Integer> pila = new MyStack<Integer>();		
		
		for (Integer i:arr) {
			cola.enqueue(i);
		}
		for (Integer i:arr) {
			pila.push(i);
		}
		//System.out.println(pila);
		//removeValue(pila, 20);
		//System.out.println(pila);
		
		System.out.println(cola);
		System.out.println(cola.reBuild(20));

	}
	
}



/*public class QueueNueva<E> extends MyQueue<E> {
	
	
	
	public QueueNueva() {
		super();
	}
	
	public void reBuild(E valor) {
		Queue colaRes = new LinkedList();
		for (int i = 0; i < cola.size(); i++) {
			
			if(cola.dequeue() == valor) {
				colaRes.add(i);
			}
		}
	}
	
		
		*/
		
	
	

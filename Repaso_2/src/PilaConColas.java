import java.util.*;


public class PilaConColas<E> {
	
	
	
	public ArrayList<E> toStack(ArrayList<E> array) {
		Queue<E> cola_1 = new LinkedList<E>();
		Queue<E> cola_2 = new LinkedList<E>();
		
		ArrayList<E> res = new ArrayList<>();
		
		for(E element : array) {
			while(!cola_1.isEmpty()) {
				cola_2.add(cola_1.poll());
			}
			
			cola_1.add(element);
			
			while(!cola_2.isEmpty()) {
				cola_1.add(cola_2.poll());
			}
			
			
		}
		while(!cola_1.isEmpty()) {
			res.add(cola_1.poll());
		}
		return res;
	}
	
	public static void main(String[] args) {
		PilaConColas<Integer> pila = new PilaConColas<Integer>();
		ArrayList<Integer> array = new ArrayList<>();
		array.add(1);
		array.add(2);
		array.add(3);
		ArrayList<Integer> res = pila.toStack(array);
	
		for(int element : res) {
			System.out.println(element);
		}
		
	}
	
}

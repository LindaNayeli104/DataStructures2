import java.util.NoSuchElementException;

public class KElementFromEnd<E> extends MyListaEnlazada<E> {

	public KElementFromEnd(E[] datos) {
		super(datos);
	}
	
	
	public E element(int pos) {
		
		try {
			if(pos == 0) {
				return null;
			}
			MyNodo<E> current = this.first;
			MyNodo<E> next = this.first;
			
			for (int i = 0; i < pos; i++) {
				next = next.next;
			}
			
			while(next != null) {
				current = current.next;
				next = next.next;
			}
			return current.valor;
		}catch(NullPointerException e) {
			throw new NoSuchElementException("Posicion invalida");
		}
	}
		
	
	public static void main(String[] args) {
		Integer[] arr = {1,2,3,4,5,6,7,8,9};
		KElementFromEnd<Integer> lista = new KElementFromEnd<Integer>(arr);
		
		System.out.println(lista.element(4));
	}
	
	
	
	
}

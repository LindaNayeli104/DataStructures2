
public class ReverseLinkedList<E> extends MyListaEnlazada<E> {
	
	public ReverseLinkedList(E[] datos) {
		super(datos);
	}
	
	private void reverse() {
		
		if(this.first == null) {
			return;
		}
		MyNodo<E> prev = null;
		MyNodo<E> current = this.first;
		MyNodo<E> next = this.first.next;
		
		while(next != null) {
			current.next = prev;
			prev = current;
			current = next;
			next = next.next;
		}
		current.next = prev; 
		this.first = current;

	}
	
	public static void main(String[] args) {
		Integer[] arr = {5,8,6};
		ReverseLinkedList<Integer> lista = new ReverseLinkedList<Integer>(arr);
		
		lista.reverse();
		System.out.println(lista);
	}
}

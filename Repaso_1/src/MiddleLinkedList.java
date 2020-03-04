
public class MiddleLinkedList<E> extends MyListaEnlazada<E> {
	
	public MiddleLinkedList(E[] datos) {
		super(datos);
	}
	
	public E mitad() {
		MyNodo<E> current = this.first;
		MyNodo<E> next = this.first.next;

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
	
	
	public static void main(String[] args) {
		Integer[] arr = {1,2,3,4,5,6};
		MiddleLinkedList<Integer> lista = new MiddleLinkedList<>(arr);
		
		System.out.println(lista);
		System.out.println(lista.mitad());
	}	
}

public class RemoveDuplicateElementsLinkedList<E> extends MyListaEnlazada<E> {

	public RemoveDuplicateElementsLinkedList(E[] datos) {
		super(datos);
	}
	
	public void remove() {
		if(this.first == null) {
			return;
		}
		MyNodo<E> current = this.first;
		MyNodo<E> next = this.first.next;
		
		while(next != null) {
			if(current.valor.equals(next.valor)) {
				next = next.next;
				current.next = next;
			}else {
				next = next.next;
				current = current.next;
			}
		}
	}
	
	
	public static void main(String[] args) {
		String[] arr = {"A","A","B", "B","C","D","D","D"};
		RemoveDuplicateElementsLinkedList<String> lista = new RemoveDuplicateElementsLinkedList<String>(arr);
		lista.remove();
		System.out.println(lista);
	
	}
	
	
	
	
}


public class DetectALoop<E> extends MyListaEnlazada<E> {

	public DetectALoop(E[] datos) {
		super(datos);
	}
	
	
	public boolean loop() {
		MyNodo<E> current = this.first;
		MyNodo<E> next = this.first.next;
		
		while(next != null) {
			if(current == next) {
				return true;
			}else {
				current = current.next;
				next = next.next.next;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Integer[] arr = {1,2,3,4};
		DetectALoop<Integer> lista = new DetectALoop<Integer>(arr);
	
		MyNodo<Integer> current = lista.first;
		
		lista.last.next = lista.first;
		System.out.println(lista.loop());
	}
	
	
	
}

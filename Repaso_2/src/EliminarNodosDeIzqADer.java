
public class EliminarNodosDeIzqADer<E extends Comparable<E>> extends MyABB<E> {


	public void eliminar(MyNodoABB<E> current) {

		if(current != null) {
			eliminar(current.left);
			eliminar(current.right);
			borrar(current.value);
		}
	}
	
	public void inorden(MyNodoABB<E> current) {
		if(current != null) {
			inorden(current.left);
			System.out.println();
			inorden(current.right);
		}
		
	}
	
	


	public static void main(String[] args) {
		EliminarNodosDeIzqADer<Integer> tree = new EliminarNodosDeIzqADer<Integer>();

		tree.insertar(50);
		tree.insertar(25);
		tree.insertar(75);
		tree.insertar(60);
		tree.insertar(1);
		
	
		tree.inorden();
		System.out.println();
		tree.eliminar(tree.raiz);
		tree.inorden();
		System.out.println("Holaaaaa");
		


	}


}

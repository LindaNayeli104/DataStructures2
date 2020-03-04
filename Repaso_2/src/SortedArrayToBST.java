
public class SortedArrayToBST<E extends Comparable<E>> extends MyABB<E>{

	
	public MyABB<E> construir(E[] array) {
		MyABB<E> tree = new MyABB<>();
		tree.raiz = new MyNodoABB(array[array.length/2]);
		
		for(E dato : array) {
			tree.insertar(dato);
		}
		return tree;
	}
	
	private void inorden(MyNodoABB<E> current) {
		if(current != null) {
			inorden(current.left);
			System.out.println(current.value + ",");
			inorden(current.right);
		}
	}
	
	public static void main(String[] args) {
		SortedArrayToBST<Integer> tree_1 = new SortedArrayToBST<>();
		Integer[] array = {2,5,6,10,15};
		
		MyABB<Integer> tree = tree_1.construir(array);
		tree.inorden();
		
	
	}
}

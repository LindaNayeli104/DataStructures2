import java.util.ArrayList;

public class isBinaryTree<E extends Comparable<E>> extends MyABB<E> {
	public isBinaryTree	() {
		super();
	}
	
	public boolean isBST(MyNodoABB<E> current) {
		ArrayList<E> array = new ArrayList<>();
		array = inorden(current, array);
		
		for (int i = 0; i < array.size()-1; i++) {
			if(array.get(i).compareTo(array.get(i+1))>0) {
				return false;
			}
		}
		return true;
	}
	
	public ArrayList<E> inorden(MyNodoABB<E> current, ArrayList<E> array) {
		if(current != null) {
			inorden(current.left, array);
			array.add(current.value);
			inorden(current.right, array);
		}
		return array;
	}
	

	public static void main(String[] args) {
		isBinaryTree<Integer> tree = new isBinaryTree<Integer>();
		/*
		//MyABB<Integer> tree = new MyABB<>();
		tree.insertar(2);
		tree.insertar(1);
		tree.insertar(3);

		//System.out.println(tree.raiz);
		System.out.println(tree.isBST(tree.raiz));
		*/
		
		
		tree.raiz = new MyNodoABB(20);
		tree.raiz.left = new MyNodoABB(10);
		tree.raiz.right = new MyNodoABB(50);
		tree.raiz.right.left = new MyNodoABB(49);
		tree.raiz.right.right = new MyNodoABB(80);
	
		
		System.out.println(tree.isBST(tree.raiz));
	

	}
}

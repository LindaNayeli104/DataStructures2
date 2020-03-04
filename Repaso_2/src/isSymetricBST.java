
public class isSymetricBST<E extends Comparable <E>> extends MyABB<E>{

	public boolean isSymetric(MyNodoABB<E> current) {
		if(current != null) {
			return isSymetric(current.left, current.right);
		}
		return true;

	}


	public boolean isSymetric(MyNodoABB<E> izq, MyNodoABB<E> der ) {
		if(izq == null || der == null) {
			return izq == der;
		}
		if(izq.value != der.value) {
			return false;
		}
		return isSymetric(izq.left, der.right) && isSymetric(izq.right,der.left);
	}
	
	
	
	public void inorden(MyNodoABB<E> current) {
		if(current != null) {
			inorden(current.left);
			System.out.println();
			inorden(current.right);
		}
		
	}
	

	public static void main(String[] args) {
		isSymetricBST<Integer> tree = new isSymetricBST<Integer>();
		
		tree.raiz = new MyNodoABB(10);
		tree.raiz.left = new MyNodoABB(5);
		tree.raiz.right = new MyNodoABB(5);
		tree.raiz.right.left = new MyNodoABB(3);
		tree.raiz.right.right = new MyNodoABB(4);
		tree.raiz.left.left = new MyNodoABB(4);
		tree.raiz.left.right = new MyNodoABB(3);
		tree.raiz.left.left.left = new MyNodoABB(1);
		tree.raiz.right.right.right= new MyNodoABB(1);
		
		System.out.println(tree.isSymetric(tree.raiz));
		
		tree.inorden();
		System.out.println();
	}


}


public class SumOfLeftLeaves<E extends Comparable <E>> extends MyABB<E> {

	int sum=0;
	public int sumOfLeftLeaves(MyNodoABB root) {
	
		if(root != null) {
			
		}
		if(root.left == null && root.right == null) {
			sum = sum + (int) root.value;
			return sum;
		}
		sum +=  sumOfLeftLeaves(root.left);
		sumOfLeftLeaves(root.right);
		return sum;
	}

	
	public static void main(String[] args) {
		SumOfLeftLeaves<Integer> prueba = new SumOfLeftLeaves<>();
		
		prueba.raiz = new MyNodoABB(50);
		prueba.raiz.left = new MyNodoABB(25);
		prueba.raiz.right = new MyNodoABB(75);
		prueba.raiz.left.right = new MyNodoABB(35);
		prueba.raiz.left.right.left = new MyNodoABB(34);
		prueba.raiz.right.left = new MyNodoABB(60);
		prueba.raiz.right.right = new MyNodoABB(80);
		
		prueba.inorden();
		System.out.println();
		prueba.sumOfLeftLeaves(prueba.raiz);
	}
}

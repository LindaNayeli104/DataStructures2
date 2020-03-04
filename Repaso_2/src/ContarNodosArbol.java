
public class ContarNodosArbol<E extends Comparable<E>> extends MyABB<E> {
	
	public int contar(MyNodoABB<E> current, int nodos) {
		if(current != null) {
			nodos++;
			nodos = contar(current.left, nodos);
			nodos = contar(current.right, nodos);
		}
		return nodos;
	}
	

	public static void main(String[] args) {
		ContarNodosArbol<Integer> tree = new ContarNodosArbol<Integer>();
		
		tree.insertar(50);
		tree.insertar(25);
		tree.insertar(75);
		tree.insertar(60);
		
		tree.insertar(80);
		tree.insertar(54);
		tree.insertar(68);
		tree.insertar(76);
		tree.insertar(81);
		
		tree.insertar(1);
		
		System.out.println(tree.contar(tree.raiz, 0));
	}
}

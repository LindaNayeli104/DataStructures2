
public class NumHojasArbol<E extends Comparable<E>> extends MyABB<E>{
	
	public int contar(MyNodoABB<E> current, int hojas) {
		if(current != null) {
			if(current.left == null && current.right == null) {
				hojas++;
			}
			hojas = contar(current.left, hojas);
			hojas = contar(current.right, hojas);
		}
		return hojas;
	}
	
	
	public static void main(String[] args) {
		NumHojasArbol<Integer> tree = new NumHojasArbol<>();
		
		tree.insertar(50);
		tree.insertar(25);
		tree.insertar(75);
		tree.insertar(60);
		/*
		tree.insertar(80);
		tree.insertar(54);
		tree.insertar(68);
		tree.insertar(76);
		tree.insertar(81);
		*/
		tree.insertar(1);
		
		System.out.println(tree.contar(tree.raiz, 0));
	}
}

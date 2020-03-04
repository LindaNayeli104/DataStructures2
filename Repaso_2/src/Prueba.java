public class Prueba<E extends Comparable<E>>  {
	MyABB<Integer> arbol; 

	public E max;

	public Prueba() {
		this.arbol = new MyABB<Integer>();
		max = arbol.raiz.info;
	}
	public boolean isBTSprep(MyNodoABB<E> current) {
		if (current == null) {
			return true;
		}else {
			return isBTS(current);
		}
	}



	private boolean isBTS(MyNodoABB<E> current) {
		if (current != null) {
			isBTS(current.izq);

			if(current.info.compareTo(max) > 0) {
				max = current.info;
			}else {
				return false;
			}

			isBTS(current.der);
			return true;
		}
		return true;
	}

	public static void main(String[] args) {
		Prueba<Integer> tree = new Prueba<Integer>();
		tree.arbol.insertar(2);
		tree.arbol.insertar(1);
		tree.arbol.insertar(3);

		System.out.println(tree.arbol.raiz);
		System.out.println(tree.isBTS(tree.arbol.raiz));

	}
}
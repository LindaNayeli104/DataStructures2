import java.util.Enumeration;
import java.util.Hashtable;

public class SumaVerticalArbol {
	
	static Hashtable<Integer, Integer> ht = new Hashtable<>();

	public static void sumaVerticalArbol(MyABB<Integer> abb) {
		sumaVerticalArbol(abb.raiz, 0);
		Enumeration<Integer> llaves = ht.keys();
		Integer llaveActual;
		
		while(llaves.hasMoreElements()) {
			llaveActual = llaves.nextElement();
			System.out.println(llaveActual + " : " + ht.get(llaveActual)  + ",");
		}
		System.out.println();
	}
	
	private static void sumaVerticalArbol(MyNodoABB<Integer> current, int nivel) {
		if(current != null) {
			if(!ht.containsKey(nivel)) {
				ht.put(nivel,  current.value);
			}else {
				Integer valor = ht.get(nivel);
				ht.put(nivel, valor + current.value);
			}
			sumaVerticalArbol(current.left, nivel-1);
			sumaVerticalArbol(current.right, nivel+1);
		}
	}
	
	public static void main(String[] args) {
		/*
		Hashtable<Integer, Integer> htp = new Hashtable<Integer, Integer>();
		
		htp.put(1, 1);
		htp.put(1,5);
		System.out.println(htp.get(1));
		*/
		
		MyABB<Integer> abb = new MyABB<Integer>();
		Integer[] valores = {100,50,150,25,75,120,200,10,40,60,90,170,250};
		
		for(Integer valor : valores) {
			abb.insertar(valor);
		}
		sumaVerticalArbol(abb);
	}
}

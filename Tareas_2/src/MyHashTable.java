import java.util.Iterator;
import java.util.LinkedList;

public class MyHashTable<K,V> {

	private int size;
	private LinkedList<NodoHT<K,V>>[]  tabla;
	private final static double LOADFACTOR = 0.75;   //Final porque es una constante y no queremos cambiar su valor



	public MyHashTable() {
		this(11);
	}

	public MyHashTable(int length) {
		this.tabla = (LinkedList<NodoHT<K,V>>[]) new LinkedList[length]; 
		for (int i = 0; i < tabla.length; i++) {
			this.tabla[i] = new LinkedList<NodoHT<K,V>>();
		}
		this.size = 0;
	}

	private void rehashing() {
		
		MyHashTable<K, V> ht = new MyHashTable<>(2* this.tabla.length+1);
		
		for (LinkedList<NodoHT<K,V>> lista : this.tabla) {
			for(NodoHT<K, V> elemento : lista) {
				ht.put(elemento.llave, elemento.valor);
			}
		}
		this.tabla = ht.tabla;
		System.gc();
		
		
		}
	
	public void put(K llave, V valor) {
		int pos = Math.abs(llave.hashCode() % this.tabla.length);
		this.tabla[pos].addFirst(new NodoHT(llave, valor));
		this.size++;
		if(  ((double)this.size) / this.tabla.length > MyHashTable.LOADFACTOR) {
			this.rehashing();
		}
	}

	public V delete(K llave) {
		int pos = Math.abs(llave.hashCode() % this.tabla.length);
		Iterator<NodoHT<K,V>> it = this.tabla[pos].iterator();
		NodoHT<K,V> current = null;
		while (it.hasNext()) {
			current = it.next();
			if (llave.equals(current.llave)) {
				it.remove();
				this.size--;
				return current.valor;
			}
		}
		return null;
	}

	public V get(K llave) {
		int pos = Math.abs(llave.hashCode() % this.tabla.length);
		for(NodoHT<K,V> nodo: this.tabla[pos]) {
			if(nodo.llave.equals(llave)) {
				return nodo.valor;
			}
		}
		return null;
	}
	
	public void flush() {
		this.tabla = (LinkedList<NodoHT<K,V>>[]) new LinkedList[11];
		this.size = 0;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public boolean containsKey(K llave) {
		//return this.get(llave) != null;
		
		int pos = Math.abs(llave.hashCode() % this.tabla.length);
		
		for(NodoHT<K, V> nodo : this.tabla[pos]) {
			if(nodo.llave.equals(llave)) {
				return true;
			}
		}
		return false;
	}
	
	

	public static void main(String[] args) {
		MyHashTable<String, Integer> tabla_1 = new MyHashTable<String, Integer>();
		tabla_1.put("uno", 1);
		tabla_1.put("dos", 2);
		tabla_1.put("tres", 3);
		tabla_1.put("cuatro", 4);
		tabla_1.put("cinco", 5);
		tabla_1.put("seis", 6);
		tabla_1.put("siete", 7);
		tabla_1.put("ocho", 8);
		tabla_1.put("nueve", 9);
		tabla_1.put("diez", 10);
		tabla_1.put("once", 11);
		
		//System.out.println(tabla_1.delete("cuatro"));

		tabla_1.delete("cuatro");
		System.out.println(tabla_1.containsKey("cuatro"));
		
		for(int i=0; i< tabla_1.tabla.length;i++) {
			System.out.println(tabla_1.tabla[i]);
		}
		
		

	}




}


class NodoHT<K,V>{

	K llave;
	V valor;

	public NodoHT(K llave, V valor) {
		this.llave = llave;
		this.valor = valor;
	}

	public String toString() {
		return this.llave + ":" + this.valor;
	}


}
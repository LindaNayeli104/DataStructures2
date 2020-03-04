
public class NReinas {
	
	private int[] tablero;
	
	public NReinas(int n) {
		this.tablero = new int[n];
		for(int i=0; i<this.tablero.length; i++) {
			this.tablero[i] = -1;
		}
	}
	
	
	private void imprimeTablero() {
		for(int i=0; i<this.tablero.length; i++) {
			System.out.print(this.tablero[i] + ",");
		}
		System.out.println();
	}
	
	
	private boolean valida(int fila, int columna) {                        //(2,3)    (fila, columna)
		//Revisar que no haya alguna reina en esa misma fila
		for(int i=0; i<columna; i++) {
			if(fila == this.tablero[i]) {
				return false;
			}
		}
		//Revisar que no haya alguna reina en alguna de las diagonales
		for(int i=0; i<columna; i++) {
			if(Math.abs(fila-this.tablero[i]) == Math.abs(columna-i)) {
				return false;
			}
		}
		return true;	
	}
	
	
	private void busca(int columna) {                  //Recursiva        busca todas las soluciones
		for(int i=0; i<this.tablero.length; i++) {
			if(valida(i,columna) == true) {
				this.tablero[columna] = i;
				if(columna < this.tablero.length-1) {
					this.busca(columna+1);                      // Recordar el stack
				}else {
					this.imprimeTablero();
				}
			}
		}
	}
	
	
	public void busca() {
		this.busca(0);
	}
	
	
	public static void main(String[] args) {
		NReinas nr = new NReinas(4);
		nr.busca();
	}
	
}

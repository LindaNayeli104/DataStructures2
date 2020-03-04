/*
 Autor: Linda Nayeli Abundis Lopez   A01636416
 Nombre de la clase: Laberinto.java
 Fecha: 13 de enero de 2020
 Comentarios: No recordaba como leer y escribir archivos asi que revisé documentacion. La parte más compleja para mí fue en la funcion "buscar"
              hacer que no siguiera la recursion después de llegar a las coordenadas "fin".
 */


import java.awt.Point;
import java.io.*;

public class Laberinto {

	private Point inicio,
				  fin;
	
	private boolean[][] laberinto;
	
	private boolean[][][] pasado;
	
	
	
	public Laberinto(String ruta) {   //Ruta del archivo laberinto
		try {
			
			//Construir laberinto---------------------------------------------------------
			
			FileReader fr = new FileReader(ruta);    //("EjemploEntrada.txt")
			BufferedReader br = new BufferedReader(fr);
			
			String[] aux = br.readLine().split(" ");
			String[] aux2 = br.readLine().split(" ");
			this.inicio = new Point(Integer.parseInt(aux[0]),Integer.parseInt(aux[1]));
			this.fin = new Point(Integer.parseInt(aux2[0]),Integer.parseInt(aux2[1]));
			
			String[] aux3 = br.readLine().split(" ");
			int fil = Integer.parseInt(aux3[0]);
			int col = Integer.parseInt(aux3[1]);
			laberinto = new boolean[fil][col];
			pasado = new boolean[fil][col][2];
			
			String[] auxLab = new String[col];
			for(int i=0; i<fil; i++) {
				 auxLab = br.readLine().split("");
				 for(int j=0; j< col; j++) {
					 if(auxLab[j].equals("1")) {
						 laberinto[i][j] = true;
					 }else{
						 laberinto[i][j] = false;
					 }
				 }
			}
		}catch(Exception err){
			System.out.println(err);
		}
		
		//Recorrer laberinto------------------------------------------------------------
		
		buscar();
		
		//Resultado---------------------------------------------------------------------
		
		char[][] res = new char[laberinto.length][laberinto[0].length];
		
		for(int i=0; i<this.laberinto.length; i++) {
			for(int j=0; j<this.laberinto[0].length; j++) {
				
				if(pasado[i][j][1]) {
					res[i][j] = 'Y';
				}else {
					res[i][j] = ' ';
				}
				
				if(pasado[i][j][0] == true && res[i][j] == ' ') {
					res[i][j] = 'X';
				}else if(laberinto[i][j] == true) {
					res[i][j] = 'P';
				}	
			}
		}
		res[inicio.x][inicio.y] = 'I';
		res[fin.x][fin.y] = 'F';
		
		
		
	//Crear doc de salida-------------------------------------------------------------

		File archivo = new File("Respuesta.txt");
		try {
			PrintWriter pw = new PrintWriter("Respuesta.txt");
			String linea = "";
			
			for(int i=0; i<this.laberinto.length; i++) {
				for(int j=0; j<this.laberinto[0].length; j++) {
					linea += res[i][j];
					linea += ",";
				}
				pw.println(linea);
				linea = "";
			}
			pw.close();
		}catch(Exception err){
			System.out.println(err);
		}
	}
	
	
	public void buscar() {                           
		buscar(inicio.x, inicio.y);
	}
	
	
	private boolean buscar(int fila, int columna) {   
		if(validar(fila,columna) ) {
			this.pasado[fila][columna][0] = true;
			this.pasado[fila][columna][1] = true;
			boolean bandera;
			
			if(fila == fin.x && columna == fin.y) {
				//System.out.println("Fila " + fila + " Columna " + columna);
				return true;
			}
			
			bandera = buscar(fila, columna+1);
			if(bandera || pasado[fin.x][fin.y][1]) {
				return false;
			}
			
			bandera = buscar(fila, columna-1);
			if(bandera || pasado[fin.x][fin.y][1]) {
				return false;
			}
			
			bandera = buscar(fila+1, columna);
			if(bandera || pasado[fin.x][fin.y][1]) {
				return false;
			}
			
			bandera = buscar(fila-1, columna);
			if(bandera || pasado[fin.x][fin.y][1]) {
				return false;
			}
			
			this.pasado[fila][columna][1] = false;
		}
		return false;
	}
	
	
	private boolean validar(int fila, int columna) {
		//Valida que pertenezca al laberinto
		if(fila >= laberinto.length || fila < 0) {
			return false;
		}
		else if(columna >= laberinto[0].length || columna < 0) {
			return false;
		}
		//Valida que no sea pared
		else if(laberinto[fila][columna]) {
			return false;
		}
		//Valida que no se haya visitado
		else if(pasado[fila][columna][0]) {
			return false;
		}else {
			return true;
		}	
	}    
	
	
	public static void main(String[] args) {
		Laberinto lab = new Laberinto("EjemploEntrada.txt");
	}
}

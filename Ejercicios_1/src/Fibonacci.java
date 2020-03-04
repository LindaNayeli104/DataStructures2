
public class Fibonacci {

//---------------------------------------------------------------------------------------------------------------EXPONENCIAL
	public static long fib(int n) {
		if(n==0 || n==1) {
			return 1;
		}else {
			return fib(n-2) + fib(n-1);
		}
	}

//--------------------------------------------------------------------------------------------------------------LINEAL
	public static long fibOpt (int n) {                         //Funcion de preparacion
		long[] vFibo = new long[n+1];
		vFibo[0] = vFibo[1] = 1;
		return fibOpt(n,vFibo);
	}
	
	public static long fibOpt(int n, long[] vFibo) {
		if(vFibo[n] == 0) {                                        // Preguntar si el valor ya esta calculado, lo regreso
			vFibo[n] = fibOpt(n-2,vFibo) + fibOpt(n-1,vFibo);
		}
		return vFibo[n];
	}
	
	
//------------------------------------------------------------------------------------------------------------------MAIN	
	public static void main(String[] args) {
		System.out.println(fib(5));
		System.out.println(fibOpt(5));	
	}

}






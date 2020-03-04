
public class Factorial {

	public static long factorial(int number) {
		if(number <= 1) {
			return 1;
		}else {
			return number * factorial(number-1);
		}
	}
	
	public static void main(String[] args) {
		long fact5 = factorial(5);
		System.out.println("El factorial de 5 es: " + fact5);
	}
	
}

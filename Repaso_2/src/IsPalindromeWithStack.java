import java.util.Stack;

public class IsPalindromeWithStack{
	Stack pila = new Stack();


	public boolean comprueba(String palabra) {
		char letra;

		for (int i = 0; i <palabra.length (); i++) {
			letra = palabra.charAt(i); 
			pila.add(letra);
		}

		for (int i = 0; i <palabra.length (); i++) {
			letra = palabra.charAt(i); 
			if(!pila.pop().equals(letra)){
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		IsPalindromeWithStack pal = new IsPalindromeWithStack();
		
		System.out.println(pal.comprueba("rotor"));
	}
}


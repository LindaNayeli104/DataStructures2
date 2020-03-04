import java.util.Stack;

public class ValidParentheses {
	
	public <E extends Comparable <E>> boolean validar(String phrase) {
		Stack<Character> stack =new Stack<>();
		Character symbol;
		for(int i=0; i < phrase.length(); i++) {
			symbol = phrase.charAt(i);
			if(symbol == '(' || symbol == '[' || symbol == '{'  ) {
				stack.add(symbol);
			}
			else if(symbol == ')') {
				if(stack.pop() != '(') {
					return false;
				}
			}
			else if(symbol == ']') {
				if(stack.pop() != '[') {
					return false;
				}
			}
			else if(symbol == '}') {
				if(stack.pop() != '{') {
					return false;
				}
			}
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		ValidParentheses prueba = new ValidParentheses();
		System.out.println(prueba.validar("([{()()}[]])"));
	}
	
	
}

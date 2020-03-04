/*
 Autor: Linda Nayeli Abundis Lopez   A01636416
 Nombre de la clase: ValidaOperadoresAgrupacion.java
 Fecha: 21 de enero de 2020
 Comentarios: Me gustó ver ejercicios para aplicar las pilas de este estilo
 */

import java.util.*; 

public class ValidaOperadoresAgrupacion {

	public static boolean valida(String exp) {   
		Stack<Character> pila = new Stack<>();
		Character x;
		
		for(int i = 0; i < exp.length(); i++) {
			Character  oper = exp.charAt(i);                       
			if(oper == '(' || oper == '[' || oper == '{') {
				pila.add(oper);
			}else if(oper == ')' || oper == ']' || oper == '}') {
				if(pila.isEmpty()) {
					return false;
				}
				x = (Character) pila.pop();
				if(x == '(' && oper != ')') {
					return false;
				}else if(x == '[' && oper != ']') {
					return false;
				}else if(x == '{' && oper != '}') {
					return false;
				}
			}
		}
		if(!pila.isEmpty()) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(valida("[2+3(4)6{7(5)7}]Linda"));
		//System.out.println(valida("("));
	}
	
}

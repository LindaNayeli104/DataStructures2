
public class StarsRec {

	public static void recDes(int num) {
		if(num==0) {
			return; 
		}
		String res = "";
		for (int i = 0; i < num; i++) {
			res += "*";
		}
		System.out.println(res);
		recDes(num-1);
		res = "";
		
		for (int i = 0; i < num; i++) {
			res += "*";
		}
		System.out.println(res);
	}
	
	public static void recAsc(int num) {                         //****************************************DUDA
		if(num == 6) {     //num*2
			return; 
		}
		int n = 1;
		int m = num-n;
		System.out.println(num-2);     //num-1
		recAsc(num+1);
		System.out.println(num-2);
	}
	
	public static void recDiamante(int num) {
		if(num==0) {
			return; 
		}
		String res = "";
		for (int i = 0; i < num; i++) {
			res += "*";
		}
		System.out.println(res);
		recDes(num-1);
		res = "";
		
		for (int i = 0; i < num; i++) {
			res += "*";
		}
		System.out.println(res);
	}
	
	public static void recMarco(int num) {
		if(num==0) {
			return; 
		}
		String res = "";
		for (int i = 0; i < num; i++) {
			res += "*";
		}
		for (int i = 0; i < num; i++) {
			res += "*";
		}
		System.out.println(res);
		recMarco(num-1);
		res = "";
		
		for (int i = 0; i < num; i++) {
			res += "*";
		}
		for (int i = 0; i < num; i++) {
			res += "*";
		}
		System.out.println(res);
	}
	
	
	
	


	
	public static void main(String[] args) {
		//recDes(4);
		//recAsc(3);
		//recDiamante(4);
		recMarco(3);
	}
	
}




/*
 public static void rec(int num) {
		if(num==0) {
			return; 
		}
		
		System.out.println(num);
		rec(num-1);
		System.out.println(num);
	}
	
	public static void main(String[] args) {
		rec(5);
	}
	*/

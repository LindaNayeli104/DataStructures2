import java.util.Hashtable;

public class DosNumQueDenSumadosUnNum {

	
	public static int[] nums(int[] array, int target) {
		Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
		int[] res = new int[2];
		for(int num : array) {
			if(!ht.containsKey(num)){
				ht.put(target-num, num);
			}
			else {
				res[0] = num;
				res[1] = target-num;
			}
		}
		return res;
	}	
	
	public static void main(String[] args) {
		int[] array = {8,2,1,5};
		int[] res = nums(array,9);
		for(int num : res) {
			System.out.println(num);
		}
			
	}
}

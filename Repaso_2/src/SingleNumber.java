import java.util.HashSet;

public class SingleNumber {
	
	public static int find(int[] nums) {
		
		HashSet<Integer> hs = new HashSet<Integer>();
		
		for(int num : nums) {
			if(!hs.contains(num)) {
				hs.add(num);
			}else {
				hs.remove(num);
			}
		}
		for(int num : nums) {
			if(hs.contains(num)) {
				return num;
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		int[] nums = {2,2,1};
		System.out.println(find(nums));
	}
}

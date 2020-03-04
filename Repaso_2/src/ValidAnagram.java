import java.util.Hashtable;

public class ValidAnagram {

	public static boolean isAnagram(String s, String t) {
		if(s.length() != t.length()) {
			return false;
		}

		Hashtable<Character, Integer> htUno = new Hashtable<>();

		for (int i = 0; i < s.length(); i++) {
			if(htUno.containsKey(s.charAt(i))){
				htUno.put(s.charAt(i), htUno.get( s.charAt(i)) +1);
			}else {
				htUno.put(s.charAt(i), 1);
			}
		}

		for (int i = 0; i < t.length(); i++) {
			if(htUno.containsKey(t.charAt(i)) && htUno.get(t.charAt(i)) > 0 ){
				htUno.put(t.charAt(i), htUno.get( t.charAt(i)) -1);

			}else {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isAnagram("aacc", "ccac"));
	}
}

/*public static boolean isAnagram(String s, String t) {
		if(s.length() != t.length()) {
			return false;
		}

		Hashtable<Character, Integer> htUno = new Hashtable<>();
		Hashtable<Character, Integer> htDos = new Hashtable<>();

		for (int i = 0; i < s.length(); i++) {
			if(htUno.containsKey(s.charAt(i))){
				htUno.put(s.charAt(i), htUno.get( s.charAt(i)) +1);
			}else {
				htUno.put(s.charAt(i), 1);
			}
		}

		for (int i = 0; i < t.length(); i++) {
			if(htDos.containsKey(t.charAt(i))){
				htDos.put(t.charAt(i), htDos.get( t.charAt(i)) +1);

			}else {
				htDos.put(t.charAt(i), 1);

			}
		}

		for(int i = 0; i < s.length(); i++) {
			if(htUno.get(s.charAt(i)) != htDos.get(s.charAt(i))) {
				System.out.println(s.charAt(i));
				return false;
			}
		}
		return true;

	}
 */


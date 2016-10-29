package selfPreparation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SMS {

	public static HashMap<Character, List<Character>> map = new HashMap<>();

	public static void main(String[] args) {
		load();
		System.out.println(message("2*"));
	}

	private static String message(String sms) {
		int count = 1;
		Character c = sms.charAt(0);
		StringBuilder sb = new StringBuilder();
		List<Character> value = null;
		for (int idx = 1; idx < sms.length(); idx++) {
			if (c.equals(sms.charAt(idx))) {
				count++;
			} else {
				if (c == '*') {
					while (count > 0) {
						sb.append(' ');
						count--;
					}
				} else if (c != '#') {
					value = map.get(c);
					int far = count % value.size();
					sb.append(value.get(far));
					count = 0;
				}

				c = sms.charAt(idx);
				count = 1;

			}
		}
		if (count > 0) {
			if (c == '*') {
				while (count > 0) {
					sb.append(' ');
					count--;
				}
			} else if (c != '#') {
				value = map.get(c);
				int far = count % value.size();
				sb.append(value.get(far));
				count = 0;
			}
		}

		return sb.toString();
	}

	public static void load() {
		List<Character> value = new ArrayList<Character>();
		value.add('2');
		value.add('A');
		value.add('B');
		value.add('C');

		map.put('2', value);
		value = new ArrayList<Character>();
		value.add('3');
		value.add('D');
		value.add('E');
		value.add('F');

		map.put('3', value);
		value = new ArrayList<Character>();
		value.add('4');
		value.add('G');
		value.add('H');
		value.add('I');

		map.put('4', value);
		value = new ArrayList<Character>();
		value.add('5');
		value.add('J');
		value.add('K');
		value.add('L');

		map.put('5', value);
		value = new ArrayList<Character>();
		value.add('6');
		value.add('M');
		value.add('N');
		value.add('O');

		map.put('6', value);
		value = new ArrayList<Character>();
		value.add('7');
		value.add('P');
		value.add('Q');
		value.add('R');
		value.add('S');

		map.put('7', value);
		value = new ArrayList<Character>();
		value.add('8');
		value.add('T');
		value.add('U');
		value.add('V');

		map.put('8', value);
		value = new ArrayList<Character>();
		value.add('9');
		value.add('W');
		value.add('X');
		value.add('Y');
		value.add('Z');

		map.put('9', value);

	}

}

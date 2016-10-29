package selfPreparation;

import java.util.ArrayList;
import java.util.List;

public class PeekingMain {

	public static void main(String[] args) {
		List<Integer> lst = new ArrayList<>();
		lst.add(710);
		lst.add(659);
		lst.add(77);
		PeekingIterator pit = new PeekingIterator(lst.iterator());
		System.out.println(pit.hasNext());
		System.out.println(pit.next());
		System.out.println(pit.next());
		System.out.println(pit.peek());
		System.out.println(pit.hasNext());
		System.out.println(pit.peek());
		System.out.println(pit.hasNext());
		
	}

}

package selfPreparation;

import java.util.Comparator;

public class MaxComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		if(o1.intValue() == o2.intValue())
			return 0;
		if(o1.intValue() > o2.intValue())
			return -1;
		else
			return 1;
	}

}

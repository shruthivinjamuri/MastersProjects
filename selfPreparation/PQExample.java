package selfPreparation;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PQExample {
	
	public static void main(String [] args){
		PQExample x = new PQExample();
		myComparator comp =  x.new myComparator();
		PriorityQueue<Person> pq = new PriorityQueue<>(comp);
		pq.add(new Person(32,"ABS"));
		Person b = new Person(34,"ABZ");
		pq.add(b);
		pq.add(new Person(35,"ABV"));
		
		while(!pq.isEmpty()){
			System.out.println(pq.poll().age);
		}
		
	}
	
	public class myComparator implements Comparator<Person> {

		@Override
		  public int compare(Person o1, Person o2) {
			// TODO Auto-generated method stub
			if(o1.age > o2.age)
				return 1;
			else if (o1.age < o2.age)
				return -1;
			else
				return 0;
		}
		
	}
	
}

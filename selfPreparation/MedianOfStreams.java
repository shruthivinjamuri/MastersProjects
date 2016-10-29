package selfPreparation;

public class MedianOfStreams {

	public static void main(String[] args) {
		Median med = new Median();
		/*med.max.offer(4);
		med.max.offer(6);
		while(!med.max.isEmpty())
			System.out.println(med.max.poll()); */
		
		med.insertItem(6);
		System.out.println("lower: "+med.lowerMedian()+" Upper: "+med.upperMedian());
		
		med.insertItem(8);
		System.out.println("lower: "+med.lowerMedian()+" Upper: "+med.upperMedian());
		
		med.insertItem(7);
		System.out.println("lower: "+med.lowerMedian()+" Upper: "+med.upperMedian());
		
		med.insertItem(4);
		System.out.println("lower: "+med.lowerMedian()+" Upper: "+med.upperMedian());
		
		med.insertItem(8);
		System.out.println("lower: "+med.lowerMedian()+" Upper: "+med.upperMedian());
		
		med.insertItem(1);
		System.out.println("lower: "+med.lowerMedian()+" Upper: "+med.upperMedian());
		
		med.insertItem(9);
		System.out.println("lower: "+med.lowerMedian()+" Upper: "+med.upperMedian());

	}

}

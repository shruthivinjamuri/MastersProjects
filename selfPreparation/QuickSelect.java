package selfPreparation;

public class QuickSelect {

	public static void main(String[] args) {
		int a[] = {2,7};//,8,1,3,5,6,4};
		try {
			System.out.println(quickSelect(a, 0, a.length-1, 2));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static int quickSelect(int[] a, int low, int high, int k) throws Exception{
		if(k > high+1 || k < low +1)
			throw new Exception( k + " doesn't satisfy either of the two cases, it cannot be more than "+ (high+1) + " or less than "+ (low+1) );
		if(low > high)
			return -1;
		int pivot = partition(a,low,high);
		if(k < pivot-low+1) //left side
		{
			return quickSelect(a,low,pivot-1,k);
		}
		else if( k > pivot-low+1) // go to right side
			return quickSelect(a,pivot+1,high,k-(pivot-low)-1);
		else
			return a[pivot];
		
	}
	
	public static int partition(int[] a, int low, int high){
		if(low == high)
			return low;
		int i = low-1;
		int pivot = a[high];
		int temp = 0;
		for (int j = low; j < high; j++) {
			if(a[j] <= pivot){
				i++;
				//exchange a[i] and a[j]
				temp=a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		i++;
		temp = a[high];
		a[high] = a[i];
		a[i] = temp;
		return i;
		
	}

}

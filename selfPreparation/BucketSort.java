package selfPreparation;

import java.util.ArrayList;
import java.util.List;

public class BucketSort {

	public static void main(String[] args) {
		int [] a = {3,1,24,2,4};
		List<Node> data = new ArrayList<Node>(a.length);
		for (int i = 0; i < a.length; i++) {
			data.add(new Node(Integer.MIN_VALUE));
		}
		sort(a, data);

	}
	
	public static void sort(int[] a, List<Node> data){
		if(a==null||a.length ==0)
			return;
		for (int i = 0; i < a.length; i++) {
			int idx = (a[i]-1)/a.length;
			Node inner = data.get(idx);
			if(inner.val == Integer.MIN_VALUE) {
				inner.val = a[i];
			}
			else {
				Node temp = inner;
				while(temp != null){
					if(temp.val > a[i]){
						Node newNode = new Node(temp.val);
						temp.val = a[i];
						newNode.next = temp.next;
						temp.next=newNode;
						break;						
					}
					if(temp.next == null){
						temp.next = new Node(a[i]);
						break;
					}
					temp = temp.next;
				}
			}
		}
		for (int i = 0; i < a.length; i++) {
			Node inner = data.get(i);
			while(inner != null){
				if(inner.val != Integer.MIN_VALUE) System.out.print(inner.val+" ");
				inner = inner.next;
			}
		}
	}

}

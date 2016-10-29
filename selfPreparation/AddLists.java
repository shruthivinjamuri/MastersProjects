package selfPreparation;

public class AddLists {

	public static void main(String[] args) {
		Node l1 = new Node(3);
		l1.next = new Node(2);
		l1.next.next = new Node(1);

		Node l2 = new Node(2);
		l2.next = new Node(1);
		Node ans = Sum(l1, l2);
		while (ans != null) {
			System.out.print(ans.val + " ");
			ans = ans.next;
		}

	
	}

	public static Node add(Node l1, Node l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		Node head = null;
		Node tail = null;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int v1 = 0;
			if (l1 != null) {
				v1 = l1.val;
				l1 = l1.next;
			}

			int v2 = 0;
			if (l2 != null) {
				v2 = l2.val;
				l2 = l2.next;
			}

			int sum = carry + v1 + v2;
			carry = sum / 10;
			sum = sum % 10;

			if (head == null) {
				head = new Node(sum);
				tail = head;
			} else {
				tail.next = new Node(sum);
				tail = tail.next;
			}
		}

		if (carry > 0) {
			tail.next = new Node(carry);
		}

		return head;
	}
	
	public static Node Sum(Node l1, Node l2){
		int len1 = getLength(l1);
		int len2 = getLength(l2);
		
		if(len1>len2){
			l2 = appendZeros(l2, len1-len2);
		}
		else{
			l1 = appendZeros(l1,len2-len1);
		}
		
		AddListSum sum=helper(l1,l2);
		
		if(sum.carry > 0){
			Node newNode = new Node(sum.carry);
			newNode.next = sum.sum;
			return newNode;
		}
		return sum.sum;
	}
	
	private static AddListSum helper(Node l1, Node l2) {
		if(l1 == null) return new AddListSum();
		
		AddListSum sum = helper(l1.next,l2.next);
		
		int val = sum.carry + l1.val + l2.val;
		sum.carry = val/10;
		if(sum.sum == null){
			sum.sum = new Node(val%10);
		}
		else {
			Node newSum = new Node(val%10);
			newSum.next = sum.sum;
			sum.sum = newSum;
		}
		
		return sum;
		
	}

	public static int getLength(Node l){
		Node cur = l;
		int len=0;
		while(cur != null){
			len++;
			cur = cur.next;
		}
		return len;
	}
	
	public static Node appendZeros(Node l, int ctr){
		if(ctr < 0)
			return l;
		
		Node zero = new Node(0);
		Node cur = zero;
		while(ctr > 1){
			cur.next = new Node(0);
			cur=cur.next;
			ctr--;
		}
		cur.next = l;
		return zero;
	}

}

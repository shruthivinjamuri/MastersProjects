package selfPreparation;

public class AddListsRecur {
	public static void main(String[] args) {
		Node l1 = new Node(1);
		l1.next = new Node(2);
		l1.next.next = new Node(6);

		Node l2 = new Node(4);
		l2.next = new Node(5);
		Node ans = Sum(l1, l2);
		while (ans != null) {
			System.out.print(ans.val + " ");
			ans = ans.next;
		}

	}

	public static Node Sum(Node l1, Node l2) {
		int len1 = getLength(l1);
		int len2 = getLength(l2);

		if (len1 > len2) {
			l2 = appendZeros(l2, len1 - len2);
		} else {
			l1 = appendZeros(l1, len2 - len1);
		}

		Node head = new Node(0);
		/*
		 * first way using helper method int carry=helper(l1,l2, head);
		 * 
		 * if(carry > 0){ head.val = carry; return head; } return head.next;
		 */

		// second way using helper1 method where the carry value is present at
		// front of the node
		helper1(l1, l2, head);
		System.out.println();
		if (head.val > 0)
			return head;
		else
			return head.next;
	}

	private static void helper1(Node l1, Node l2, Node head) {
		if (l1 == null) {
			head.val = 0;
			return;
		}
		helper1(l1.next, l2.next, head);
		int val = head.val + l1.val + l2.val;
		head.val = val / 10; // head contains the carry
		if (head.next == null) {
			head.next = new Node(val % 10);
		} else {
			Node newSum = new Node(val % 10);
			newSum.next = head.next;
			head.next = newSum;
		}
	}

	private static int helper(Node l1, Node l2, Node head) {
		if (l1 == null) {
			return 0;
		}
		int carry = helper(l1.next, l2.next, head);
		int val = carry + l1.val + l2.val;
		carry = val / 10;
		if (head.next == null) {
			head.next = new Node(val % 10);
		} else {
			Node newSum = new Node(val % 10);
			newSum.next = head.next;
			head.next = newSum;
		}

		return carry;

	}

	public static int getLength(Node l) {
		Node cur = l;
		int len = 0;
		while (cur != null) {
			len++;
			cur = cur.next;
		}
		return len;
	}

	public static Node appendZeros(Node l, int ctr) {
		if (ctr < 0)
			return l;

		Node zero = new Node(0);
		Node cur = zero;
		while (ctr > 1) {
			cur.next = new Node(0);
			cur = cur.next;
			ctr--;
		}
		cur.next = l;
		return zero;
	}

}

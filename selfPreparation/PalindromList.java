package selfPreparation;

public class PalindromList {

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(8);
		head.next.next = new Node(1);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(1);
		head.next.next.next.next.next = new Node(8);
		head.next.next.next.next.next.next = new Node(16);
		head.next.next.next.next.next.next.next = new Node(17);
		head.next.next.next.next.next.next.next.next = new Node(5);
		System.out.println(palindrome(head));
	}

	public static int countCommon(Node l1, Node l2){
		if(l1 == null || l2 == null)
			return 0;
		int ctr=0;
		while(l1 != null && l2 != null){
			if(l1.val == l2.val){
				ctr++;
				l1 = l1.next;
				l2=l2.next;
			}
			else
				break;
			
		}
		return ctr;
	}
	
	public static int palindrome(Node head){
		if(head == null) return 0;
		Node prev = null;
		Node cur = head;
		int len=0;
		while(cur != null){
			//save next node
			Node next = cur.next;
	
			//reverse the cur next link: point it to prev
			cur.next = prev;
			len = Math.max(len, 2*countCommon(prev,next) + 1); //don't include cur node: odd length case
			len = Math.max(len, 2*countCommon(cur,next)); //include cur node: even case
			
			prev = cur;
			cur = next;		
		}
		
		return len;
	}
}

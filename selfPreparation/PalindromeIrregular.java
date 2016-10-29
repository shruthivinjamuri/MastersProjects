package selfPreparation;

public class PalindromeIrregular {

	public static void main(String[] args) {
		ListNode<String> head= new ListNode<>("abac");
		head.next = new ListNode<>("dde");
		head.next.next=new ListNode<>("effee");
		head.next.next.next=new ListNode<>("dd");
		head.next.next.next.next=new ListNode<>("caba");
		System.out.println(isPalindrome(head));

	}
	
	public static boolean isPalindrome(ListNode<String> head){
		if(head == null)
			return true;
		
		int slen = 0;
		ListNode<String> cur = head;
		//find the length of the string in the list
		while(cur!= null){
			slen += cur.value.length();
			cur = cur.next;
		}
		cur = head;
		ListNode<String> prev = null;
		int curLen=0;
		while(cur!=null){
			curLen += cur.value.length();
			if(curLen > slen/2) break;
			prev = cur;
			cur = cur.next;			
		}
		while(cur != null){
			ListNode<String> next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		cur = prev; // cur acts as right
		prev = head; //now prev acts as left
		String left = prev.value;
		String right = cur.value;
		int i=0,j=right.length()-1;
		while(i<left.length() && j>=0){
			if(left.charAt(i) != right.charAt(j)) return false;
			if(i+1 == left.length() && prev.next != cur){
				prev = prev.next;
				left = prev.value;
				i=0;
			}
			else i++;
			
			if(j-1 < 0 && cur.next != prev){
				cur= cur.next;
				right = cur.value;
				j = right.length()-1;
			}
			else j--;	
			
			
					
		}
		
		if(i >= left.length() && j >= 0) {
			i=0;
			while(i < j){
				if(right.charAt(i) != right.charAt(j)) return false;
				i++;j--;
			}
		}
		else if (i < left.length() && j < 0){
			j=left.length()-1;
			while(i < j){
				if(left.charAt(i) != left.charAt(j)) return false;
				i++;j--;
			}
		}
			
		
		return true;
	}

}

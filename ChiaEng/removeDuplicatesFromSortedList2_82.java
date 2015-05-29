import java.util.Currency;

public class CopyOfRemoveDuplicatesFromSortedList2_82 {

	public static void main(String args[]){
		
		ListNode n1=new ListNode(1);
		ListNode n2=new ListNode(1);
		n1.next=n2;
		deleteDuplicates(n1);
	}
	
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

	}
	
    public static ListNode deleteDuplicates(ListNode head) {

		if (head == null) {
			return null;
		}
		
		ListNode starter= new ListNode(0);
		starter.next=head;
		ListNode left = starter;
		ListNode right = head;

		while (right != null) {

			// move right until reach a different node
			while (right.next != null && left.next.val == right.next.val) {
				right = right.next;
			}

			// Here, right.next is different with right

			// judge if the "node" is the same

			// keep this only node
			if (left.next == right) {
				left = right;
			} else {
				left.next = right.next;
			}
			right = right.next;
		}

		return starter.next;

	}
}



/*:Algo:
  
  move right pointer until right.val != right.next.val
  
  judge if two situation:
  
  LRRRRRR(New)  L->(New)
  LR(New)       L->R
  
 
 */


/*:Mistakes:


1. 

Node n1,n2,n3

n1=n2
n2=n3

set n1=null
n2,n3 remain

but set n1.next=null or other node.
next of n2 n3 change too. (next is the same node, n1,n2,n3 not
)


PS: 

n1=head;
n2=head;

change n2.next.  n1.next will not change

2. Don't initilize a node with null and assign it a next node.

3. Always get one to point to the head, and don't move it.

4.

		ListNode starter= new ListNode(0);
		starter.next=head;
		ListNode left = new ListNode(0);
		left.next = head;
		
		ListNode starter= new ListNode(0);
		starter.next=head;
		ListNode left = starter
		
		if want to get starter sync with action of left.
		Use the 2nd one
		

		left will obtain different ID
*/
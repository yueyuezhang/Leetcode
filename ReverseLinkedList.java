public class ReverseLinkedList {
	public static ListNode reverseList(ListNode head){
		if (head==null){
			return null;
		}
		if (head.next==null){
			return head;
		}
		ListNode second=head.next;
		ListNode third=second.next;
		second.next=head;
		head.next=null;
		if(third==null){
			return second;
		}
		if(third.next==null){
			third.next=second;
			return third;
		}
		ListNode curr=third;
		ListNode prev=second;
		
		while (curr!=null){
			 ListNode next=curr.next;
			 curr.next=prev;
			 prev=curr;
			 curr=next;
		}

		return prev;
		
	}
	}

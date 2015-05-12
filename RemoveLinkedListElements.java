public class RemoveLinkedListElements {
	public static ListNode removeElements(ListNode head, int val){
		if(head==null) return head;
		ListNode helper=new ListNode(0);
		helper.next=head;
		ListNode runner=helper;
		while(runner.next!=null){
			if (runner.next.val==val){
				ListNode next=runner.next.next;
				runner.next=next;
			}
			else{
				runner=runner.next;
			}
		}
		return helper.next; 
	}
		
	
	}

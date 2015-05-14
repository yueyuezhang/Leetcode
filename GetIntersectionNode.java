package leetcode;

public class GetIntersectionNode {
	public static ListNode getIntersectionNode(ListNode headA,ListNode headB){
		int lengthDiff=getLengthDiff(headA,headB);
		if (lengthDiff>0){
			for(int i=0;i<lengthDiff;i++){
				headA=headA.next;
			}
		}
		else{
			for(int i=0;i<Math.abs(lengthDiff);i++){
				headB=headB.next;
			}
		}
		while(headA!=headB){
			headA=headA.next;
			headB=headB.next;
		}
		return headA;
	}
	public static int getLength(ListNode head){
		int counter=0;
		while(head!=null){
			head=head.next;
			counter++;
		}
		return counter;
	}
	public static int getLengthDiff(ListNode headA,ListNode headB){
		return getLength(headA)-getLength(headB);
	}
	
	public static void main(String[] args){
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(2);
		ListNode l3=new ListNode(3);
		ListNode l4=new ListNode(4);
		ListNode l5=new ListNode(5);
		ListNode l6=new ListNode(6);
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		l4.next=l5;
		l5.next=l6;
		ListNode l9=new ListNode(9);
		ListNode l8=new ListNode(8);
		l8.next=l9;
		l9.next=l4;
		ListNode intersection=getIntersectionNode(l9,l1);
		System.out.println(intersection.val);
		
	}
	
}

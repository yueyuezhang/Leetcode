public class PartitionList_86 {

	public static void main(String args[]) {

		ListNode n1 = new ListNode(1);
		// ListNode n2 = new ListNode(3);
		// ListNode n3 = new ListNode(1);
		//
		//
		// n1.next = n2;
		// n2.next = n3;

		ListNode hd = partition(n1, 2);

		while (hd != null) {
			System.out.print(hd.val);
			hd = hd.next;
		}

	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode partition(ListNode head, int x) {
		if (head == null)
			return null;
		ListNode helper = new ListNode(-999);
		helper.next = head;
		ListNode walker = new ListNode(-999);
		walker = helper;
		ListNode runner = new ListNode(-999);
		runner = helper;
		while (runner.next != null) {
			if (runner.next.val < x) {
				if (runner.val >= x) {
					ListNode next = runner.next.next;
					runner.next.next = walker.next;
					walker.next = runner.next;
					runner.next = next;
				} else
					runner = runner.next;
				walker = walker.next;
			} else {
				runner = runner.next;
			}
		}
		return helper.next;
	}

	/*
	 * :Thinking:
	 * 
	 * 1. My thought: if next< and this>. should make next backward. Better
	 * thought: if next< runner with walker 1. runner move runner faster than
	 * walker 2. runner backward and walker move
	 * 
	 * 
	 * 
	 * 
	 * 2. swap a node (next to some where) 1. sv r.next.next 2. r.next -> back
	 * .next 3. back.next= r.next 4. r.next = sv
	 */

	/*
	 * :Mistakes:
	 * 
	 * 1. does not need to use while to keep moving walker. move one every once
	 * runner meet <x
	 * 
	 * 2. Don't move walker until needed
	 * 
	 * Input: [1,1], 0 Output: [] Expected: [1,1]
	 * 
	 * (never move walker because not needed)
	 */

	public static ListNode partition2(ListNode head, int x) {

		if (head == null) {
			return head;
		}

		// left is a dummy node. enter the link after first point to x of xo
		// edge
		ListNode starter = new ListNode(0);
		starter.next = head;

		ListNode left = new ListNode(0);
		left.next = head;
		ListNode right = head;
		boolean leftMove = false;

		// keep up the central thinking. left is responsible of track the x of
		// xo

		while (right.next != null) {

			if (right.next.val >= x && right.val < x) {
				right = right.next;

			} else {
				while (left.next.val < x) {
					left = left.next;
				}

				ListNode bckR = right.next;
				right.next = bckR.next;

				bckR.next = left.next;

				if (leftMove == false) {
					left.next = bckR;
					starter = left;
					leftMove = true;
				} else {
					left.next = bckR;
				}

			}

			// right = right.next;

		}

		return starter.next;

	}

}

/*
 * :Mistakes: 1. do the else first, that is easier and release your stress
 * if(right.next.val<x && right.val>x){
 * 
 * }else{ // all other situation that just make right pointer keep going }
 * 
 * 
 * 2. concept of treat object assign as a pointer.
 * http://www.c4learn.com/java/java-assigning-object-reference/
 * 
 * n1,n2,n3 n1=n2 n2=n3
 * 
 * n3=null // n1,n2 still exist
 * 
 * 
 * n1 -> 口' n2 -> 口'' n3 -> 口''' n2,n1-> 口' n3-> 口''' n1 -> 口' n2,n3-> 口''' n1
 * -> 口' n2-> 口'''
 * 
 * above, all n is independtly point to 口
 * 
 * 
 * but set a right node's next =null is different thing. right could be in the
 * following of head or starter or left
 * 
 * Conclusion, only one right in the front. Here, has a lot of n1,n2,n3
 * 
 * 3. swap to first node! starter.next not first node anymore
 * 
 * 4. Consider the equal to x condition
 * 
 * 5. edge cases: [1,1], 2
 * 
 * try move left to last one <2. but go out of bound (all < 2) while
 * (left.next.val < x) { left = left.next; }
 * 
 * walker and runner one move, one move will not 'cause this 6.
 */
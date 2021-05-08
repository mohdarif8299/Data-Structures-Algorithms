/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode mergeKLists(ArrayList<ListNode> a) {
	    PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(a.size(),(node1,node2)->node1.val-node2.val);
	    for(int i=0;i<a.size();i++) minHeap.add(a.get(i));
	    int k=0;
	    ListNode head=null;
	    ListNode tail = null;
	    while(!minHeap.isEmpty()) {
	        ListNode temp = minHeap.poll();
	        if(head==null) { head=temp; }
	        else { tail.next = temp;}
	        tail = temp;
	        if(temp.next!=null)
	        minHeap.add(temp.next);
	    }
	    return head;
	}
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((n1,n2)->n1.val-n2.val);
        ListNode head = null;
        ListNode tail = null;
        for(int i=0;i<lists.length;i++) if(lists[i]!=null) minHeap.add(lists[i]);
        while(!minHeap.isEmpty()) {
            ListNode temp = minHeap.poll();
            if(head==null) head = temp;
            else tail.next = temp;
            tail = temp;
            if(temp.next!=null) minHeap.add(temp.next);
        }
        return head;
    }
}
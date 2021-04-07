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
    public ListNode rotateRight(ListNode head, int k) {
         if(head==null) return null;
        int totalNodes = 0;
        ListNode temp  =head,prev = null;;
        while(temp!=null) {
            prev = temp;
            temp = temp.next;
            totalNodes+=1;
        }
        k = k%totalNodes;
        if(k==0) return head;
        ListNode temp2 = head;
        int i=0;
        while(i<totalNodes-k-1) {
            temp2 = temp2.next;
            i+=1;
        }
        ListNode newHead = temp2.next;
        temp2.next = null;
        prev.next = head;
        return newHead;
    }
}

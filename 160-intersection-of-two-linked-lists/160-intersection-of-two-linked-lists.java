/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int h1 = height(headA);
        int h2 = height(headB);
    
        
        if( h1> h2) {
            int n = h1-h2;
            while(n-->0) headA = headA.next;
        } else {
            int n = h2-h1;
            while(n-->0) headB = headB.next;
        }
        
        return getIntersection(headA, headB);
        
    }
    public ListNode getIntersection(ListNode headA, ListNode headB) {
        while(headA!=null && headB!=null) {
            if(headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
    public int height(ListNode head) {
        int h = 0;
        ListNode temp = head;
        while(temp!=null) {
            h += 1;
            temp = temp.next;
        }
        return h;
    }
}
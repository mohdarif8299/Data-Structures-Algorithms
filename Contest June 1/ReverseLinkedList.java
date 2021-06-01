/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode A, int B, int C) {
        ListNode prev = A;
        int K=1;
        while(K<B-1) {
            prev = prev.next;
            K++;
        }
        if(B==1)  {
            A = reverse(prev,B,C);
        } else {
            prev.next = reverse(prev.next,B,C);
        }
        return A;
    }
    public static ListNode reverse(ListNode A,int B,int C) {
        ListNode curr = A;
        ListNode prev = null;
        ListNode next=null;
        while(B<=C) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            B = B+1;
        }
        A.next = curr;
        return prev;
    }
}

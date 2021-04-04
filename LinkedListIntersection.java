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
        HashSet<ListNode> nodeSet = new HashSet<>();
        ListNode temp = headA;
        int M = 0,N=0;
        while(temp!=null) {
            temp = temp.next;
            M+=1;
        }
        ListNode temp2 = headB;
        while(temp2!=null) {
          N+=1;
            temp2 = temp2.next;
        }
        int K = Math.abs(M-N);
        temp = headA;temp2 = headB;
        if(M>N) {
            int i = 0;
            while(i<K && temp!=null) {
                temp = temp.next;
                i+=1;
            }
            while(temp!=null && temp2!=null && temp!=temp2) {
                temp =temp.next;
                temp2 = temp2.next;
            }
            return temp;
        }
        else {
             int i = 0;
            temp2 = headB;
            while(i<K && temp2!=null) {
                temp2 = temp2.next;
                i+=1;
            }
             while(temp!=null && temp2!=null && temp!=temp2) {
                temp =temp.next;
                temp2 = temp2.next;
            }
            return temp;
        }
    }
}

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode solve(ListNode A, int B) {
        ListNode ans = null;
        ListNode ansEnd = null;
        ListNode temp = A;
        while(temp!=null) {
            int m = temp.val%B;
            if(m==0) {
                ListNode node = new ListNode(temp.val);
                if(ans==null) {
                    ans = node;
                }
                else {
                    ansEnd.next = node;
                }
                ansEnd = node;
            }
            temp = temp.next;
        }
        ListNode temp1 = ans;
        ListNode temp2 = A;
        while(temp2!=null) {
            if(temp1!=null &&temp2.val%B!=0) {
                temp2.val = temp1.val;
            }
            else if(temp1!=null && temp2.val==temp1.val) {
                temp1 = temp1.next;
            }
            temp2 = temp2.next;
        }
        return A;
    }
}

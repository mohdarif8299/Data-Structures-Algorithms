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
    public static ListNode tailEnd = null;
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode head = null;
        while(p1!=null && p2!=null) {
            if(p1.val < p2.val) {
                ListNode node = p1;
                p1 = p1.next;
                head = insertAtEnd(head, node);
                node = null;
            } else {
                ListNode node = p2;
                p2 = p2.next;
                head = insertAtEnd(head, node);
                node = null;
            }
        }
        if(p1!=null) head = insertAtEnd(head, p1);
        if(p2!=null) head = insertAtEnd(head, p2);
        return head;
    }
    public static ListNode insertAtEnd(ListNode head, ListNode node) {
        if(head == null) {
            head = node; 
        } else {
            tailEnd.next = node;
        }
        tailEnd = node;
        return head;
    }
}
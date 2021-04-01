import java.util.List;

public class PalindromeLinkedList {

    public static ListNode head = null;
    public static ListNode tail = null;
    public static class ListNode {
            public int val;
            public ListNode next;
             ListNode(int x) { val = x; next = null; }
    }

    public static void main(String[] args) {
       insert_node_end(1);
       insert_node_end(2);
      // insert_node_end(3);
       insert_node_end(2);
       insert_node_end(1);
       System.out.println(isPalindrome(head));
    }
    public static boolean isPalindrome(ListNode head) {
       ListNode temp = middle(head);
       ListNode curr = temp.next,prev=null,next=null;
       while(curr!=null) {
           next = curr.next;
           curr.next = prev;
           prev = curr;
           curr = next;
       }
       temp.next = prev;
       ListNode t = head;
       ListNode m = temp.next;
       while(t!=null && m!=null) {
           if(t.val!=m.val) return false;
           t = t.next;
           m = m.next;
       } 
       return true;
    }
    public static ListNode middle(ListNode A) {
        ListNode single = A;
        ListNode dbl = A;
        while(dbl.next!=null && dbl.next.next!=null) {
            dbl = dbl.next.next;
            single = single.next; 
        }
        return single;
    }
    public static void insert_node_end(int value) {
        ListNode node = new ListNode(value);
        if(head==null) {
            node.next = null;
            head = node;
        }
        else {
            tail.next=node;
        }
        tail = node;
    } 
}
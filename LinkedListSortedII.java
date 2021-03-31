import java.util.List;

public class LinkedListSortedII {
    public static ListNode head = null;
    public static class ListNode {
            public int val;
            public ListNode next;
             ListNode(int x) { val = x; next = null; }
    }

    public static void main(String[] args) {
        insert_node(1);
        insert_node(1);
        insert_node(2);
        insert_node(2);
        insert_node(3);
        insert_node(4);  
        ListNode temp = deleteDuplicates(head);
        while(temp!=null) {
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();   
    }
    
    public static ListNode deleteDuplicates(ListNode A) {
       
       ListNode  dumm = new ListNode(0);
       dumm.next = head;
       ListNode curr=A;
       ListNode prev = dumm;
       while(curr!=null) {
            while(curr.next!=null && curr.next.val==prev.next.val) curr = curr.next;
            if(prev.next==curr) prev = prev.next;
            else prev.next = curr.next;
            curr = curr.next;
        }
        A = dumm.next;
        return A;
    }

    public static void insert_node(int value) {
        ListNode node = new ListNode(value);
        if(head==null) {
            node.next = null;
            head = node;
        }
        else {
            ListNode temp = head;
            while(temp.next!=null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }   
    
}
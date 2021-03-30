public class LinkedListMiddle {
    public static ListNode head = null;
    public static class ListNode {
            public int val;
            public ListNode next;
             ListNode(int x) { val = x; next = null; }
    }
    public static void main(String[] args) {
        insert_node(1);
        insert_node(2);
         insert_node(3);
        // insert_node(4);
        // insert_node(5);
        // insert_node(6);  
        ListNode single = head;
        ListNode dbl = head;
        while(dbl.next!=null && dbl.next.next!=null) {
            dbl = dbl.next.next;
            single = single.next; 
        }
        if(dbl.next==null) 
        System.out.println(single.val);
        else System.out.println(single.next.val);
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
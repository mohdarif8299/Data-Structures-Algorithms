public class PartitionList {
    
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
        insert_node_end(3);
        insert_node_end(1);
        insert_node_end(3);
        //insert_node_end(2);
        ListNode temp = partition(head, 2);
        while(temp!=null) {
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static ListNode partition(ListNode A, int B) {
       if(A==null) return A;
       ListNode smallList = null;
       ListNode greatList = null;
       ListNode smallEnd  =null;
       ListNode greatEnd = null;
       
       ListNode temp = A;
       while(temp!=null) {
           if(temp.val<B) {
               ListNode node = temp;
               if(smallList==null) smallList = node;
               else smallEnd.next = node;
               smallEnd = node;
           }
           else {
                ListNode node = temp;
                if(greatList==null) greatList = node;
                else greatEnd.next = node;
                greatEnd =node;
           }
           temp = temp.next;
       }
       if(smallList==null) { A = greatList; return A;}
       if(greatList==null) { A = smallList; return A;}
       else  greatEnd.next = null;
       smallEnd.next = greatList;
       A = smallList;
       return A;
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
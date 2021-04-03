public class LinkedListMergeSort {
    public static ListNode head = null;
    public static ListNode tail = null;
    public static class ListNode {
            public int val;
            public ListNode next;
             ListNode(int x) { val = x; next = null; }
    }
    public static void main(String[] args) {
        // insert_node_end(1);
        // insert_node_end(2);
        // insert_node_end(5);
        // insert_node_end(3);
        // insert_node_end(4);
        // insert_node_end(9);
        ListNode temp = sortList(head);
        while(temp!=null) {
            System.out.print(temp.val+" ");
            temp  =temp.next;
        }
        System.out.println();
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
    public static ListNode sortList(ListNode A) {
        if(A==null || A.next==null) return A;
        ListNode m = middle(A);
        
        ListNode head2 = m.next;
        m.next=null;
        ListNode start = sortList(A);
        ListNode end = sortList(head2);
        ListNode mergeList = mergeTwoLists(start,end );
        return mergeList;
    }
    public static ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode temp1 = A;
        ListNode temp2 = B;
        ListNode ans = null;
        ListNode tail = null;
        while(temp1!=null && temp2!=null) {
            if(temp1.val<temp2.val) {
                ListNode node = temp1;
                temp1 = temp1.next;
                if(ans == null) ans = node;
                else tail.next = node;
                tail = node;
                node = null;
            }
            else {
                ListNode node = temp2;
                temp2 = temp2.next;
                if(ans == null)
                ans = node;
                else tail.next = node;
               tail = node;
               node = null;
            }
        }
         if(tail!=null){
             if(temp1!=null) tail.next = temp1;
             if(temp2!=null) tail.next = temp2;
         }
         else {
           if(temp1!=null) ans = temp1;
           if(temp2!=null) ans = temp2;
         }
        return ans;
   }
}
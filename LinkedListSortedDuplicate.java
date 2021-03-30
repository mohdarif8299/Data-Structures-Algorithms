public class LinkedListSortedDuplicate {
    public static ListNode head = null;
    public static class ListNode {
            public int val;
            public ListNode next;
             ListNode(int x) { val = x; next = null; }
    }
    public static void main(String[] args) {
        insert_node(3);
        insert_node(3);
        insert_node(3);
        insert_node(3);
        insert_node(3);
        insert_node(3);  
        ListNode temp = deleteDuplicates(head);
        while(temp!=null) {
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static ListNode deleteDuplicates(ListNode A) {
        ListNode ptr1 = A,ptr2 = A.next;
        
        while(ptr1!=null && ptr2!=null) {
            if(ptr1.val!=ptr2.val) {
                while(ptr1!=null && ptr2!=null && ptr1.val!=ptr2.val) {
                    ptr1 = ptr1.next;
                    ptr2 = ptr2.next;
                }
            } 
            else {
                while(ptr1!=null && ptr2!=null && ptr1.val == ptr2.val) {
                    ptr2 = ptr2.next;
                }
                ptr1.next = ptr2;
                ptr1 = ptr2;
                if(ptr2==null) return A;
                ptr2 = ptr2.next;
            }
            
       }
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
public class PartitionLinkedList {
    public static ListNode head = null;
    public static class ListNode {
            public int val;
            public ListNode next;
             ListNode(int x) { val = x; next = null; }
    }
    public static void main(String[] args) {
        insert_node(1);
        insert_node(4);
        insert_node(3);
        insert_node(2);
        insert_node(5);
        insert_node(2);
        ListNode temp = partition(head,3);
        
        while(temp!=null) {
             if(temp.next==null) System.out.print(temp.val); 
             else System.out.print(temp.val+" ");
             temp = temp.next;
        }
    }
    public static ListNode partition(ListNode A, int B) {
        ListNode K = null;
        ListNode temp = A;
        while(temp!=null) {
            if(temp.val<B) {
               K= insert_node_beg(K,temp.val);
               temp.val = -1;
            }
            temp = temp.next;
        }
        temp = A;
        while(temp!=null) {
            if(temp.val!=-1) {
                K = insert_node_end(K,temp.val);
            }
            temp = temp.next;
        }
        return K;
    }
    
    public static ListNode insert_node_end(ListNode head,int value) {
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
        return head;
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
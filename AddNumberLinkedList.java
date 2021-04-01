public class AddNumberLinkedList {
    public static ListNode head = null;
    public static ListNode tail = null;
    public static ListNode head2 = null;
    public static ListNode tail2 = null;
    public static ListNode tailEnd = null;
    public static class ListNode {
            public int val;
            public ListNode next;
             ListNode(int x) { val = x; next = null; }
    }

    public static void main(String[] args) {
        insert_node_end(9);
        insert_node_end(6);
        insert_node_end(9);
        insert_node_end_2(8);
        insert_node_end_2(4);
        insert_node_end_2(8);
        ListNode temp = addTwoNumbers(head,head2);
        while(temp!=null) {
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static ListNode addTwoNumbers(ListNode A, ListNode B) {
        ListNode head = null;
        int carry=0;
        while(A!=null || B!=null) {
            int X = 0;
            if(A!=null)  { X+=A.val; A = A.next; }
            if(B!=null)  { X+=B.val; B = B.next; }  
            X+=carry;
            if(X>=10){ 
                head = insert_end(head,X%10);
                carry=1;
            }
            else { 
                head = insert_end(head,X);
                carry = 0;
            }
        }
        if(carry!=0)
        head = insert_end(head,carry);
        return head;
    }
    public static ListNode insert_end(ListNode head,int value) {
        ListNode node = new ListNode(value);
        if(head==null) {
            node.next = null;
            head = node;
        }
        else {
            tailEnd.next=node;
        }
        tailEnd = node;
        return head;
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
    public static void insert_node_end_2(int value) {
        ListNode node = new ListNode(value);
        if(head2==null) {
            node.next = null;
            head2 = node;
        }
        else {
            tail2.next=node;
        }
        tail2 = node;
    } 
}
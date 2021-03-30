public class LinkedListReverseII {
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
        insert_node(4);
        insert_node(5);
        ListNode temp = reverseBetween(head,2,4);
        while(temp!=null) {
                 if(temp.next==null) System.out.print(temp.val); 
             else System.out.print(temp.val+" ");
             temp = temp.next;
        }
    }
    public static ListNode reverseBetween(ListNode A, int B, int C) {
        ListNode prev = A;
        int k = 1;
        while(k<B-1) {
            prev = prev.next;
            k++;
        }
        if(B==1){
             A =  reverseLinkedList(prev,B,C);
        }
        else{
         prev.next =  reverseLinkedList(prev.next,B,C);
          
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
    public static ListNode reverseLinkedList(ListNode A,int B,int C) {
        ListNode curr = A;
        ListNode previous = null;
        ListNode ptr = null;
        while(B<=C) {
            ptr = curr.next;
            curr.next = previous;
            previous = curr;
            curr = ptr;
            B+=1;
        }
        A.next = curr;
        return previous;
    }
}
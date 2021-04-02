public class KReverseNode {
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
        insert_node_end(4);
        insert_node_end(5);
        insert_node_end(6);
        insert_node_end(7);
        insert_node_end(8);
        insert_node_end(9);
        ListNode temp = reverseList(head, 3);
        while(temp!=null) {
            System.out.print(temp.val+" ");
            temp  =temp.next;
        }
        System.out.println();
    }
    public static ListNode reverseList(ListNode A, int B) {
        if(A==null) return A; 
        ListNode curr = A,prev= null,next=null;
        int K = 0;
        while(K<B) {
            next = curr.next;
            curr.next = prev;
            prev= curr;
            curr=next;
            K++;
        }
        A.next = reverseList(curr,B);
        return prev;
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
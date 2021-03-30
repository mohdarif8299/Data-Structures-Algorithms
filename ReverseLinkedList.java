public class ReverseLinkedList {
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
        ListNode temp = reverseList(head);
        while(temp!=null) {
            System.out.print(temp.val+" ");
            temp = temp.next;
        }

    }
    public static ListNode reverseList(ListNode A) {
        ListNode curr = A;
        ListNode prev = null;
        ListNode next = null;
        while(curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        A = prev;
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
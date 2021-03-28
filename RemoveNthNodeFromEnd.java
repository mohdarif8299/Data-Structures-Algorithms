public class RemoveNthNodeFromEnd {
    static ListNode head = null; 
    static class ListNode {
             public int val;
             public ListNode next;
             ListNode(int x) { val = x; next = null; }
         }
    public static void main(String[] args) {
        insert_node(10);
        insert_node(20);
        insert_node(30);
        ListNode temp = delete_node(head,4);
       //ListNode temp = head; 
       while(temp!=null) {
            System.out.print(temp.val+" ");
            temp = temp.next;
            
        }
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
    public static ListNode delete_node(ListNode head,int B) {
            ListNode temp  = head;
            int position = countNodes()-B;
            if(position<=0) {
                head = head.next;
                return head;
            }
            int K = 0;
            while(K<position-1 && temp.next!=null) {   
                temp = temp.next;
                K++;
            }
            if(temp.next!=null)
            temp.next = temp.next.next;
        return head;
    }
    public static int countNodes() {
        ListNode temp = head;
        int count=0;
        while(temp!=null) { 
            temp = temp.next; 
            count+=1;
        }
        return count;
    }

}
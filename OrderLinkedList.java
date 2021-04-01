import java.util.List;

public class OrderLinkedList {
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
        //insert_node(6);
        ListNode m = head;
        int count=0;
        while(m!=null) {
            count+=1;
            m = m.next;
        }
        ListNode temp = middle(head);
        ListNode curr = temp.next;
        ListNode prev = null;
        ListNode next = null;
        while(curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        temp.next = prev;
        ListNode d = temp.next;
        ListNode t = head;
        ListNode dummy = head,dummy2=d;
        while(dummy2!=null) {
            dummy = t.next;
            t.next = d;
            if(d.next==null) {
                dummy2 = d.next;
                break;
            }
            dummy2 = d.next;
            d.next = dummy;
            t = dummy;
            d = dummy2;
        }
        
        System.out.println(count);
        if(count%2==1){ d.next = dummy; dummy.next=null;}   
        ListNode temp1 = head;
        while(temp1!=null) {
            System.out.print(temp1.val+" ");
            temp1 = temp1.next;
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
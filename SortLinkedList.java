import java.util.*;
public class SortLinkedList {
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
        insert_node_end(4);
        insert_node_end(2);
        insert_node_end(0);
        insert_node_end(1);
        solve(head);
        ListNode temp = solve(head); 
        while(temp!=null) {
            System.out.print(temp.val+" ");
            temp = temp.next;
        } 
    }
    public static ListNode solve(ListNode A) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode temp = A;
        while(temp!=null) {
            list.add(Integer.parseInt(temp.val+""+temp.next.val));
            temp = temp.next.next;
        }
        ListNode ans = A;
        Collections.sort(list);
        for(int i=0;i<list.size();i++) {
            int val = list.get(i)/10;
            ans.val = val;
            ans.next.val = list.get(i)%10;
            ans = ans.next.next;
        }
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
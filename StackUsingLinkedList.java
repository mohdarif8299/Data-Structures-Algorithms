public class StackUsingLinkedList {
    public static Node head= null;
    public static class Node {
        int val;
        Node next;
        Node(int val) {
            this.val  =val;
            next = null;
        }
    } 
    public static void main(String[] args) {
        push(5);
        push(4);
        push(6);
        print();
        System.out.println(getTop());
        pop();
        print();
    }
    public static void push(int X) {
        Node node  = new Node(X);
        node.next = head;
        head = node;
    }
    public static void pop() {
        if(head==null) return;
        head = head.next;
    }
    public static void print() {
        Node temp = head;
        while(temp!=null) {
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static int getTop() {
        if(head!=null) return head.val;
        return -1;
    }
}
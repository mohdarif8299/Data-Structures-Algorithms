public class LinkedList {
    public static Node head = null;
    public static int size=0;
    public static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static void main(String[] args) {
        insert_node(1,7);
        insert_node(2,5);
        insert_node(3,6);
        delete_node(1);
        print_ll();
    }
    public static void insert_node(int position, int value) {
            Node node = new Node(value);
            if(position<1 || position>size+1) return;
            size+=1;
            if(head==null) {
                head = node;
                return;
            }
            if(position==1) {
                node.next = head;
                head = node;
                return;
            }
            int K = 1;
            Node temp = head;
            while(K<position-1) {   
                temp = temp.next;
                K++;
            }
                node.next = temp.next;
                temp.next = node;
    }

    public static void delete_node(int position) {
        Node temp  = head;
        if(position<1 || position>size) {
            return;
        }
        size-=1;
        if(position==1) {
            head = head.next;
            temp=null;
            return;
        }
        // else {
            int K = 1;
            while(K<position-1) {   
                temp = temp.next;
                K++;
            }
            if(temp.next.next!=null)
            temp.next = temp.next.next;
            else  {
                temp.next = null;
            }
       // }
    }

    public static void print_ll() {
        Node temp = head;
        while(temp!=null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
            
        }
    }
    public static void count() {
        Node temp = head;
        while(temp!=null) {
            temp = temp.next;
            size+=1;
        }
    }
}
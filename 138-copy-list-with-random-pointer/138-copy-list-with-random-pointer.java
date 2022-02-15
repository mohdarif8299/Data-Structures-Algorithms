/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node temp = head;
        while(temp!=null) {
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }
        Node node = head;
        
        while(node!=null) {
            Node random = map.get(node);
            random.next = map.get(node.next);
            random.random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }
}
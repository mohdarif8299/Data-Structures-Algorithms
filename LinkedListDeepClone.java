/*
class ListNode {
    int val;
    ListNode next, random;
    ListNode(int x) {
        val = x;
        next = random = null;
    }
} 
*/

ListNode cloneList(ListNode A) {
    Map<ListNode,ListNode> map = new HashMap<>();
    ListNode temp = A;
    while(temp!=null) {
        ListNode newNode = new ListNode(temp.val);
        map.put(temp,newNode);
        temp = temp.next;
    }
    temp  = A;
    while(temp!=null) {
        ListNode clonedNode = map.get(temp);
        clonedNode.next = map.get(temp.next);
        clonedNode.random = map.get(temp.random);
        temp = temp.next;
    }
    A = map.get(A);
    return A;
}

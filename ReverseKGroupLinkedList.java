class Solution
{
    public static Node reverse(Node node, int k)
    {
        int count=0;
        Node temp = node;
        while(temp!=null) {
            count++;
            temp = temp.next;
        }
        return reverseKGroup(node,k,count);
        //Your code here
    }
    public static Node reverseKGroup(Node head,int k,int count) {
        if(head==null) return null;
        Node prev = null;
        Node next = head;
        Node curr = head;
        int temp = k;
        while(k-->0 && curr!=null) {
         next = curr.next;
         curr.next = prev;
         prev= curr;
         curr=next;
        }
        head.next = reverseKGroup(next,temp%count,count);
        return prev;
    }
}

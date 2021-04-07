/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode solve(ListNode A, int B) {
        if(A==null) return A;
        ListNode heads[] = new ListNode[B];
        ListNode temp = A,temp2=A;
        int i=0;
        temp = temp.next;
        while(i<B && (temp!=null || temp2!=null)) {
            ListNode tempNode = temp2;
            heads[i] = tempNode;
            heads[i].next = null;
            temp2 = temp;
            if(temp!=null)
            temp = temp.next;
            i+=1;
            
        }
        int count=0;
        while(temp!=null || temp2!=null){
            ListNode node = temp2;
            ListNode head = heads[count];
            node.next = head.next;
            head.next = node;
            count+=1;
            if(count==B) count=0;
            temp2 = temp;
            if(temp!=null)
            temp = temp.next; 
        }
        i=0;
        for(int k=0;k<heads.length-1;k++) {
            ListNode head = heads[k];
              while(head.next!=null) {
                head = head.next;
            }
            head.next = heads[k+1];
        }
        return heads[0];
    }
}

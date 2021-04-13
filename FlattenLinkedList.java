/*
class ListNode {
    int val;
    ListNode right, down;
    ListNode(int x) {
        val = x;
        right = down = null;
    }
}
*/
ListNode flatten(ListNode root) {
    if(root==null || root.right==null) return root;
        ListNode middle = getMiddleNode(root);
        ListNode head2 = middle.right;
        middle.right=null;
        ListNode A = flatten(root);
        ListNode B = flatten(head2);
        ListNode newHead = mergeTwoLists(A,B);
    return newHead;
}
public static ListNode getMiddleNode(ListNode node) {
    ListNode slow = node;
    ListNode fast = node;
    while(fast.right!=null && fast.right.right!=null) {
        fast = fast.right.right;
        slow = slow.right;
    }
    return slow;
}
public static ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode temp1 = A;
        ListNode temp2 = B;
        ListNode ans = null;
        ListNode tail = null;
        while(temp1!=null && temp2!=null) {
            if(temp1.val<temp2.val) {
                ListNode node = temp1;
                temp1 = temp1.down;
                if(ans == null) ans = node;
                else tail.down = node;
                tail = node;
                node = null;
            }
            else {
                ListNode node = temp2;
                temp2 = temp2.down;
                if(ans == null)
                ans = node;
                else tail.down = node;
               tail = node;
               node = null;
            }
        }
         if(tail!=null){
             if(temp1!=null) tail.down = temp1;
             if(temp2!=null) tail.down = temp2;
         }
         else {
           if(temp1!=null) ans = temp1;
           if(temp2!=null) ans = temp2;
         }
        return ans;
   }

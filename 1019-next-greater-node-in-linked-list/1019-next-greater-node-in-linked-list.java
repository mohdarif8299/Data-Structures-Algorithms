/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
       int arr[] = new int[count(head)];
        Stack<Pair> stack = new Stack<>();
        int index = 0;
        while(head!=null) {
            while(!stack.isEmpty() && index< arr.length && head.val > stack.peek().node.val) {
                Pair p = stack.pop();
                arr[p.index] = head.val;
            }
            stack.push(new Pair(head, index++));
            head = head.next;
        }
        return arr;
    }
    public static class Pair {
        ListNode node;
        int index;
        Pair(ListNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }
    public static int count(ListNode node) {
        ListNode temp = node;
        int count = 0;
        while(temp!=null) {
            temp = temp.next;
            count++;
        }
        return count;
    }
}
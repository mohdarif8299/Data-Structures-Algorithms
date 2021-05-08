public class Solution {
    public static class TrieNode {
        TrieNode child[] = new TrieNode[50];
        int count;
        TrieNode() {
            for(int i=0;i<50;i++) {
                this.child[i] = null;
            }
            this.count=0;
        }
    }
    public int solve(String[] A) {
        TrieNode root = getNode();
        insertTrie(root,A[0]);
        for(int i=1;i<A.length;i++) {
            if(searchContact(root,A[i])==1) return 0; 
             insertTrie(root,A[i]);
        }
        return 1;
    }
    public static int searchContact(TrieNode root,String s) {
        TrieNode temp = root;
        int count=0;
        for(int i=0;i<s.length();i++) {
            if(temp.child[s.charAt(i)-'0']==null) return 0;
            count = temp.count;
            temp = temp.child[s.charAt(i)-'0'];
        }
        return count;
    }
    public static void insertTrie(TrieNode root,String str) {
        TrieNode temp = root;
        for(int i=0;i<str.length();i++) {
            if(temp.child[str.charAt(i)-'0']==null) {
               temp.child[str.charAt(i)-'0'] = getNode(); 
            }
            temp.count=1;
            temp = temp.child[str.charAt(i)-'0'];
        }
    }
    public static TrieNode getNode() {
        TrieNode root = new TrieNode();
        return root; 
    }
}

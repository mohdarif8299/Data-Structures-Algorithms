public class Solution {
    public static class TrieNode {
        TrieNode[] child = new TrieNode[26];
        boolean isEnd;
    }
    public int[] solve(String[] A, String[] B) {
        int ans[] = new int[B.length];
        TrieNode root = new TrieNode();
        for(String s:A) insertTrie(root, s);
        for(int i=0;i<B.length;i++){
            ans[i] = search(root,B[i]);
        }
        return ans;
    }
    public static int search(TrieNode root,String str) {
        TrieNode temp = root;
        String s="";
        for(int i=0;i<str.length();i++) {
            if(temp.child[str.charAt(i)-'a']==null) {
                return 0;
            }
            temp = temp.child[str.charAt(i)-'a'];
            s+=str.charAt(i);
            if(str.length()==i+1 && temp.isEnd) return 1;
        }
        return 0;

    }
     public static void insertTrie(TrieNode root,String S) {
        TrieNode temp  = root;
        for(int i=0;i<S.length();i++) {
            if(temp.child[S.charAt(i)-'a']==null) {
                TrieNode node = getNode();
                temp.child[S.charAt(i)-'a'] = node;
            }
            temp = temp.child[S.charAt(i)-'a'];
        }
        temp.isEnd = true;
    }
    public static TrieNode getNode() {
        TrieNode node = new TrieNode();
        node.isEnd = false;
        return node;
    }
}

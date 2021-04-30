public class Solution {
    public static class TrieNode {
        TrieNode[] child = new TrieNode[26];
        boolean isEnd;
        int count;
    }
    public int[] solve(String[] A, String[] B) {
        int m = B[0].length();
        int ans[] = new int[B.length];
        TrieNode root= new TrieNode();
        for(String S:A) {
            String s = filter(S,m);
            if(s!="") {
                insertTrie(root,s);  
            }
        } 
        for(int i=0;i<B.length;i++) {
            ans[i] = searchTrie(root, B[i]);
        }
        return ans;
    }
     public static String filter(String S,int m) {
        if(S.length()>=m) {
           String S1 = S.substring(0,m);
           if(S.endsWith(S1)) return S1;
           return "";
        }
        return "";
        
    }
    public static int searchTrie(TrieNode root,String str) {
       TrieNode temp = root;
        for(int i=0;i<str.length();i++) {
            if(temp.child[str.charAt(i)-'a']==null) { 
                return 0;
            }
            if(str.length()==i+1 && temp.isEnd) return temp.count;
            temp = temp.child[str.charAt(i)-'a'];
        }
        return temp.count;
    }
    public static void insertTrie(TrieNode root,String S) {
        TrieNode temp = root;
        for(int i=0;i<S.length();i++) {
            if(temp.child[S.charAt(i)-'a']==null) {
                TrieNode node = getNode();
                temp.child[S.charAt(i)-'a'] = node;
            }
            temp.count=temp.count+1;
            if(i+1==S.length())  temp.isEnd = true;
            temp = temp.child[S.charAt(i)-'a'];
        }
       
    }
    public static TrieNode getNode() {
        TrieNode node = new TrieNode();
        node.isEnd = false;
        return node;
    }
}

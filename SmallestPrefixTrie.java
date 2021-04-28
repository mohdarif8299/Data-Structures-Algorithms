public class Solution {
   public static class TrieNode {
        TrieNode[] child = new TrieNode[26];
        boolean isEnd;
        int count;
    }
    public ArrayList<String> prefix(ArrayList<String> A) {
           ArrayList<String> ans = new ArrayList<>();
           TrieNode root = new TrieNode();
            for(String s:A) insertTrie(root, s);
            for(String s:A) ans.add(search(root,s));
            return ans;
    }
    public static void insertTrie(TrieNode root,String S) {
        TrieNode temp  = root;
        for(int i=0;i<S.length();i++) {
            if(temp.child[S.charAt(i)-'a']==null) {
                TrieNode node = getNode();
                temp.child[S.charAt(i)-'a'] = node;
            }
            temp.count+=1;
            temp = temp.child[S.charAt(i)-'a'];
        }
        temp.isEnd = true;
    }
     public static String search(TrieNode root,String str) {
        TrieNode temp = root;
        String s="";
        for(int i=0;i<str.length();i++) {
            if(temp.child[str.charAt(i)-'a']==null) {
                return "";
            }
            temp = temp.child[str.charAt(i)-'a'];
            s+=str.charAt(i);
            if(temp.count==1) return s;
            if(str.length()==i+1 && temp.isEnd) return s;
        }
        return s;

    }
    public static TrieNode getNode() {
        TrieNode node = new TrieNode();
        node.isEnd = false;
        return node;
    }
}

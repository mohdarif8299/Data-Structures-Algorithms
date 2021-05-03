public class Solution {
    public static class TrieNode {
        TrieNode[] child = new TrieNode[26];
        int count=0;
    }
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<String> B) {
        ArrayList<Integer> ans = new ArrayList<>();
        TrieNode root = getNode();
        for(int i=0;i<A.size();i++) {
            if(A.get(i)==0) insertTrie(root,B.get(i));
            else ans.add(searchTrie(root,B.get(i)));
        }
        //System.out.println(ans);
        return ans;
    }
    public static void insertTrie(TrieNode root,String str) {
        TrieNode temp = root;
        for(int i=0;i<str.length();i++) {
            if(temp.child[str.charAt(i)-'a']==null) {
               TrieNode node = getNode();
               temp.child[str.charAt(i)-'a'] = node;
            }
            temp.count+=1;
            temp = temp.child[str.charAt(i)-'a'];
        }
    }
    public static TrieNode getNode() {
        TrieNode node = new TrieNode();
        return node;
    }
    public static int searchTrie(TrieNode root,String str) {
        TrieNode temp = root;
        int count=0;
        for(int i=0;i<str.length();i++) {
            if(temp.child[str.charAt(i)-'a']==null) return 0;
            count = temp.count;
            temp = temp.child[str.charAt(i)-'a'];
        }
        return count;
    }
}

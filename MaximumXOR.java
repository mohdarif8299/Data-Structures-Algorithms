public class Solution {
     public static class TrieNode {
     TrieNode child[] = new TrieNode[2];
     boolean isEnd;
    }
    public int solve(int[] A) {
        int ans = 0;
        TrieNode root = getNode();
        insertTrie(root,A[0]);
        for(int i=1;i<A.length;i++) {
            int currMax = findXOr(root, A[i]);
            ans = Math.max(ans, currMax);
            insertTrie(root,A[i]);
        }
        return ans;
    }
    public static int check(int num,int i) {
        if((num&(1<<i))>0) return 1;return 0;
    }
    public static int findXOr(TrieNode root,int x) {
        TrieNode temp = root;
        int ans=0;
        for(int i=31;i>=0;i--) {
            int bit = check(x, i);
            if(temp.child[bit^1]!=null) {
                ans = ans+(1<<i);
                temp = temp.child[bit^1];
            }
            else temp = temp.child[bit];
        }
        return ans;
    } 
    public static void insertTrie(TrieNode root,int num) {
        TrieNode temp  = root;
        for(int i=31;i>=0;i--) {
            int bit = check(num, i);
            if(temp.child[bit]==null) {
                temp.child[bit] = getNode();
            }
            temp = temp.child[bit];
        }
    }
    public static TrieNode getNode() {
        TrieNode node = new TrieNode();
        return node;
    }
}

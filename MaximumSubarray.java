public class Solution {
    
    public static class TrieNode {
        TrieNode child[] = new TrieNode[2];
        TrieNode() {
			for (int i = 0; i < 2; i++)
				child[i] = null;
		}
    }
    
    public int[] solve(int[] A) {
        int prexor[] = new int[A.length+1];
        int l=-1,r=-1;
        TrieNode node = getNode();
        for(int i=1;i<prexor.length;i++) prexor[i] = prexor[i-1]^A[i-1];
        insertTrie(node,prexor[0]);
        int max=-1;
        for(int i=1;i<prexor.length;i++) {
            max = Math.max(max,findXOR(node,prexor[i]));
            insertTrie(node,prexor[i]);
        }
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        for(int i=1;i<prexor.length;i++) {
            int xor = max^prexor[i];
            if(map.containsKey(xor)) {
                if(l==-1 && r==-1) {
                    l = map.get(xor)+1;
                    r=i;
                }
             else {
                if(i-(map.get(xor)+1)<r-l) {
                    l = map.get(xor)+1;
                    r=i;
                }
                else if(i-(map.get(xor)+1)==r-l) {
                    int min = Math.min(l,map.get(xor));
                    if(min==map.get(xor)) {
                        l = map.get(xor)+1;
                        r=i;
                    }
                }
              }
            }
            map.put(prexor[i],i);
        }
        return new int[]{l,r};
    }
    public static TrieNode getNode() {
        TrieNode root = new TrieNode();
        for (int i = 0; i < 2; i++)
				root.child[i] = null;
        return root;
    }
    public static int checkBit(int num,int i) {
        if((num&(1<<i))>0) return 1;
        return 0;
    }
    public static void insertTrie(TrieNode root,int num) {
        TrieNode temp = root;
        for(int i=31;i>=0;i--) {
            int bit = checkBit(num,i);
            if(temp.child[bit]==null) {
                temp.child[bit] = getNode();
            } 
            temp = temp.child[bit]; 
        }
    }
    public static int findXOR(TrieNode root,int num) {
        int ans=0;
        TrieNode temp = root;
        for(int i=31;i>=0;i--) {
            int bit = checkBit(num,i);
            if(temp.child[bit^1]==null) {
                temp =  temp.child[bit];    
            }
            else {
                ans+=(1<<i);
                temp = temp.child[bit^1];
            }
        }
        return ans;
    }
}

import java.lang.*;
import java.util.*;

public class Main {
     public static class TrieNode {
     TrieNode[] child = new TrieNode[26];
     ArrayList<Integer> prefix = new ArrayList<>();
   }
   public static class Pair {
     String S;
     int weight;
     Pair(int weight,String S) {
       this.S = S;
       this.weight= weight;
     }
   }
   public static TrieNode getNode() {
     TrieNode node = new TrieNode();
     return node;
   }
   public static void insert(TrieNode root,String str,int index) {
     TrieNode temp = root;
     for(int i=0;i<str.length();i++) {
       if(temp.child[str.charAt(i)-'a']==null) {
         temp.child[str.charAt(i)-'a'] = getNode();
       }
       temp = temp.child[str.charAt(i)-'a'];
        temp.prefix.add(index);
     }
   }
   public static ArrayList<Integer> searchTrie(TrieNode root,String str) {
     TrieNode temp = root;
     for(int i=0;i<str.length();i++) {
         if(temp.child[str.charAt(i)-'a']==null) return null;
         temp = temp.child[str.charAt(i)-'a'];
     }
     return temp.prefix;
   }
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
     while(T-->0) {
         int N = sc.nextInt();
         int M = sc.nextInt();
         String S[] = new String[N];
         String Q[] = new String[M];
         int A[] = new int[N];
         for(int i=0;i<N;i++) { 
           S[i] = sc.next();
         }
         for(int i=0;i<N;i++) { 
           A[i] = sc.nextInt();
         }
         for(int i=0;i<M;i++) { 
           Q[i] = sc.next();
         }
         ArrayList<Pair> words = new ArrayList<>();
          for(int i=0;i<N;i++) 
            words.add(new Pair(A[i],S[i]));
         Collections.sort(words,(w1,w2)->w2.weight-w1.weight);
         TrieNode root = getNode();
         for(int i=0;i<words.size();i++) {
           insert(root,words.get(i).S,i);
         }
         ArrayList<String> W = new ArrayList<>();
         for(int i=0;i<words.size();i++) W.add(words.get(i).S);
         for(int i=0;i<Q.length;i++) {
           ArrayList<Integer> allWords = searchTrie(root,Q[i]);
           if(allWords==null)  System.out.print(-1+" "); 
           else {
               int count=1;
               for(Integer index:allWords) { 
                   if(count<=5)
                   System.out.print(W.get(index)+" ");
                   count+=1;
               }
            }
            System.out.println();
         }
       }
    }
}

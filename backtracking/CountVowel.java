class Solution {
    public static int count;
    public int countVowelStrings(int n) {
        char ch[] = {'a','e','i','o','u'};
        count=0;
        print(0,ch.length,ch,"",n);
        return count;
    }
    public static void print(int i,int N,char ch[],String S,int K) {
       if(K==0) { count++;
           return;
       }
       if(i==N) return;
       char c = ch[i];
       for(int j=i;j<N;j++) {
           print(j,N,ch,ch[i]+c+"",K-1);
       }
       return;
    }
}

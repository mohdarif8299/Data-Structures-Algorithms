class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int Q[] = new int[queries.length];
        int W[] = new int[words.length];
        for(int i=0;i<Q.length;i++) {
            int freq[] = new int[26];
            for(int j=0;j<queries[i].length();j++) freq[queries[i].charAt(j)-'a']++;
            int max = 0;
            for(int k=0;k<26;k++) {
                if(freq[k]!=0) { max = freq[k];
                break;
                    }
            } 
            Q[i] = max;
        }
        for(int i=0;i<W.length;i++) {
            int freq[] = new int[26];
            for(int j=0;j<words[i].length();j++) freq[words[i].charAt(j)-'a']++;
            int max=0;
            for(int k=0;k<26;k++) {
                if(freq[k]!=0) {
                    max = freq[k];
                    break;
                }
            } 
            W[i] = max;
        }
        Arrays.sort(W);
        System.out.println(Arrays.toString(Q));
        System.out.println(Arrays.toString(W));
        int ANS[] = new int[Q.length];
        for(int i=0;i<Q.length;i++) {
           ANS[i] =  upperBound(Q[i],W);
        }
        return ANS;
    }
    public static int upperBound(int num,int W[]) {
        int low=0,high=W.length-1;
        int index=-1;
        while(low<=high) {
            int mid = (low+high)/2;
            if(num<W[mid]) {
                index = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        if(index==-1) return 0;
        return W.length-index;
    }
}

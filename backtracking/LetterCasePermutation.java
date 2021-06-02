class Solution {
    public List<String> letterCasePermutation(String s) {
         return new ArrayList<>(print(0,s.length(),s.toCharArray(),new HashSet<>()));
    }
    public static Set<String> print(int i,int N,char[] ch,Set<String> set) {
        if(i==N) {
            set.add(new String(ch)); return set;
        }
        if( ch[i]>60 && ch[i]>90) 
        ch[i] = (char)(ch[i]-32); 
        print(i+1,N,ch,set);
        if(ch[i]>60 && ch[i]<=90) 
        ch[i] = (char)(ch[i]+32);
        print(i+1,N,ch,set);
        return set;
    }
}

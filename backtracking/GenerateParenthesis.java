public class Solution {
    public ArrayList<String> generateParenthesis(int A) {
       char[] ch = new char[2*A];
       return print(0,A,0,0,ch,new ArrayList<>());
    }
    public static ArrayList<String> print(int i,int N,int open,int close,char[] ch,ArrayList<String> list) {
        if(i==2*N) {
            list.add(new String(ch));
            return list;
        }
        if(open<N) {
            ch[i]='(';
            print(i+1,N,open+1,close,ch,list);
        }
        if(open>close) {
            ch[i] = ')';
            print(i+1,N,open,close+1,ch,list);
        }
        return list;
    }
}

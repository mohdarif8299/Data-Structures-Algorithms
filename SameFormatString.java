public class SameFormatString {
    public static void main(String[] args) {
        String A = "HIRE";
        String B = "DIRE";
        System.out.println(solve(A,B));
    }
    public static int solve(String A,String B) {
        if(B.length()<A.length()) return 0;
        int i=0,j=0;
        for(i=0;i<A.length();i++) {
            if(j<B.length() && A.charAt(i)==B.charAt(j)) {
                while(j<B.length() && A.charAt(i)==B.charAt(j)) {
                    j++;
                }
            }
            else return 0;
        }
        if(j==B.length()-1 && i==A.length()) return 0; 
       // return (j<B.length() && A.charAt(i-1)==B.charAt(j))?1:0; 
        return 1;
    }
}
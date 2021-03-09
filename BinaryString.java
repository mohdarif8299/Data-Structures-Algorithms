public class BinaryString {
    public static void main(String[] args) {
        String A = "1001";
        String B = "10";
        System.out.println(solve(A,B));
    }
    public static String solve(String A,String B) {
        String ans = "";
        int carry = 0;
        int i=0,j=0;
        if(A.length()!=B.length()) {
           int addZeroes = A.length()-B.length();
           String zeroes = "";
           for( i=0;i<addZeroes;i++) zeroes+="0";
           B = zeroes+B;
        }
        for(i=A.length()-1;i>=0;i--) {
            int X = Integer.parseInt(A.charAt(i)+"")+Integer.parseInt(B.charAt(i)+"");
           if(carry==0) {
                if(X>1) {
                    carry = 1;
                    ans+="0";
                }
                else {
                    ans+=X;
                    carry = 0;
                }
            }
            else {
                if(X==1) {
                    carry = 1;
                    ans+="0";
                }
                else if(X>1) {
                    carry = 1;
                    ans+="1";
                }
                else {
                    ans+=X+carry;
                    carry=0;
                }
            }
        }
        if(carry==1) {
            ans+="1";
        }
        return new StringBuffer(ans).reverse().toString();
    }
}
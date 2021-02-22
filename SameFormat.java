public class SameFormat {
    public static void main(String[] args) {
        String A = "HIRED";
        String B = "HHHIIRRREDD";
        System.out.println(solve(A,B));
    }
    public static int solve(String A,String B) {
        if(B.length()<A.length()) return 0;
        int p1=0,p2=0;
        int count=0;
        while(p1<A.length()) {
            while(p2<B.length()-1 && B.charAt(p2)==B.charAt(p2+1)) {
               p2++;
            }
           if(A.charAt(p1)==B.charAt(p2)) {
            count++;
            p1++;p2++;
           } 
           if(p2>=B.length()) break;
        }
        if(count==A.length() && p2>=B.length()) return 1;
        return 0;
    }
}
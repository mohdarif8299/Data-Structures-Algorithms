public class SmallestPrefix {
    public static void main(String[] args) {
        String A = "acd";
        String B = "bay";
        System.out.println(solve(A,B));
    }
    public static String solve(String A,String B) {
        String S = A.charAt(0)+"";
        int i=1;
        while(i<A.length()) {
            if(A.charAt(i)<B.charAt(0)) {
                S+=A.charAt(i);
                i++;
            }
            else break;
        }
        return S+=B.charAt(0);

    }
}
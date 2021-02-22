public class StrStr {
    public static void main(String[] args) {
        String A =  "aabaaaababaabbbabbabbbaabababaaaaaababaaabbabbabbabbaaaabbbbbbaabbabbbbbabababbaaabbaabbbababbb";
        String B = "bba";
        System.out.println(solve(A,B));
    }
    public static int solve(String A,String B) {
        int i=0,j=0;
        int count=0;
        int index=-1;
        boolean firstOccurrence = true;
        boolean first = true;
        while(i<A.length()) {
           
                while(j<B.length() && i<A.length() && A.charAt(i)==B.charAt(j)) {
                    if(firstOccurrence) {  
                        index = i; firstOccurrence = false;
                    }
                    i++;j++;count++;
                   
                }
    
                if(count==B.length()) return index;
                else { count=0;if(index!=-1) i=index; firstOccurrence = true;index=-1; j=0;}
          
            i++;
        }
        return index;
    }
}
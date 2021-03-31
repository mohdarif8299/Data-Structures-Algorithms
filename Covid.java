import java.util.*;
public class Covid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String V = sc.next();
        int N  = sc.nextInt();
        for(int i=0;i<N;i++) {
            String B = sc.next();
            int count = 0;
            int p=0,p1=0;
            while(p<V.length() && p1<B.length()) {
                while(p<V.length() && V.charAt(p)!=B.charAt(p1)) {
                    p+=1;
                }
                while( p<V.length() && p1<B.length() && V.charAt(p)==B.charAt(p1)) {
                    p1+=1;
                    p+=1;
                    count+=1;
                }
            }

            if(count==B.length()) {
                System.out.println("POSITIVE");
            }
             else {
                System.out.println("NEGATIVE");
             }
            
        }
    }
    
}
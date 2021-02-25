import java.util.*;
public class Contest1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0) {
            int M = sc.nextInt();
            int H = sc.nextInt();
            int X = M/(H*H);
            if(X<=18) {
                System.out.println(1);
            }
            else if(X>18 && X<25) {
                System.out.println(2);
            }
            else if(X>25 && X<30) {
                System.out.println(3);
            }
            else  System.out.println(4);
        }
    }
}
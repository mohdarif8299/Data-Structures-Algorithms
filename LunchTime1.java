import java.util.*;
public class LunchTime1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0) {
            int D = sc.nextInt();
            int C = sc.nextInt();
            int A1 = sc.nextInt();
            int A2 = sc.nextInt();
            int A3 = sc.nextInt();
            int B1 = sc.nextInt();
            int B2 = sc.nextInt();
            int B3 = sc.nextInt();
            int totalPriceDay1 = A1+A2+A3;
            int totalPriceDay2 = B1+B2+B3;
            int totalPrice = A1+A2+A3+B1+B2+B3;
            int totalPriceWithDelivary = totalPrice+2*(D);
            int totalPriceWithoutDelivary = 0;
            if(totalPriceDay1>=150 && totalPriceDay2>=150) {
                totalPriceWithoutDelivary = totalPrice+C;
            }
            else if(totalPriceDay1<150 && totalPriceDay2<150){
                totalPriceWithoutDelivary = totalPrice+(2*D)+C;
            }
            else {
                totalPriceWithoutDelivary = totalPrice+D+C;
            }
            if(totalPriceWithDelivary<=totalPriceWithoutDelivary) {
                System.out.println("NO");
            }
            else {
                System.out.println("YES");
            }
        }
    }
}
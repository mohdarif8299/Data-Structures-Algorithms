import java.util.*;

public class Main {

    // ~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~
    public static int maximumProduct(int[] arr) {
       int maximumProduct=-1000;
       Arrays.sort(arr);
       for(int k=0;k<arr.length-2;k++) {
            int i=k+1;
            int j = arr.length-1;
            while(i<j) {
                int product = arr[k]*arr[i]*arr[j];
                maximumProduct = Math.max(maximumProduct,product);
                if(arr[i]<arr[j]) i++;
                else j--;
            }
       }
       return maximumProduct;
    }

    // ~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int prod = maximumProduct(arr);
        System.out.println(prod);
    }
}

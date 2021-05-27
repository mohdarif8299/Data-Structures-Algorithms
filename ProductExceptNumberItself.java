import java.util.*;

public class Main {
    
    //~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~
    public static int[] productExceptSelf(int[] arr) {
        // write your code here
        int ANS[] = new int[arr.length];
        int PREFIX[] = new int[arr.length];
        int SUFFIX[] = new int[arr.length];
        PREFIX[0] = arr[0];
        SUFFIX[SUFFIX.length-1] = arr[arr.length-1];
        for(int i=1;i<arr.length;i++) PREFIX[i] = PREFIX[i-1]*arr[i];
        for(int i=SUFFIX.length-2;i>=0;i--)  SUFFIX[i] = SUFFIX[i+1]*arr[i];
        
        ANS[0] = SUFFIX[1];
        ANS[ANS.length-1] = PREFIX[PREFIX.length-2];
        for(int i=1;i<arr.length-1;i++) {
            ANS[i] = PREFIX[i-1]*SUFFIX[i+1];
        }
        return ANS;
        
    }

    //~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int[] res = productExceptSelf(arr);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}

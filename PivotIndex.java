import java.util.*;
import java.io.*;

public class Main {

    public static int pivot_index(int[]arr) {
        int left[]= new int[arr.length];
        int right[] = new int[arr.length];
        left[0] = arr[0];
        for(int i=1;i<arr.length;i++) {
            left[i] = left[i-1]+arr[i];
        }
        right[right.length-1] = arr[arr.length-1];
        for(int i=right.length-2;i>=0;i--) {
            right[i] = right[i+1]+arr[i];
        }
        for(int i=0;i<arr.length;i++) {
            if(left[i]==right[i]) return i;
        }
        return -1;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];

        for(int i=0; i < arr.length;i++) {
            arr[i] = scn.nextInt();
        }

        int pi = pivot_index(arr);
        System.out.println(pi);
    }
}

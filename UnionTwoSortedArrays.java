import java.util.*;
import java.io.*;

public class Main {

    /*You have to complete union function and return an Arraylist which contains union elements of the two arrays*/
    public static ArrayList<Integer> union(int[] A,int[] B) {
       ArrayList<Integer> al = new ArrayList<>();
        int p1=0,p2=0;
        while(p1<A.length && p2<B.length) {
            while(p1<A.length-1 && A[p1]==A[p1+1]) p1+=1;
            while(p2<B.length-1 && B[p2]==B[p2+1]) p2+=1;
            if(A[p1]==B[p2]) {
                al.add(A[p1]);
                p1++;
                p2++;
            } else if(A[p1]<B[p2]) {
                al.add(A[p1]);
                p1++;
            } else {
                 al.add(B[p2]);
                p2++;
            }
        }
        while(p1<A.length) {
            al.add(A[p1++]);
        }
        while(p2<B.length) {
            al.add(B[p2++]);
        }
        return al;
    }

    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);
        //input work
        int n = scn.nextInt();
        int[]a = new int[n];
        for(int i=0; i < n;i++) {
            a[i] = scn.nextInt();
        }

        int m = scn.nextInt();
        int[]b = new int[m];
        for(int i=0;i < m;i++) {
            b[i] = scn.nextInt();
        }

        ArrayList<Integer>ans = union(a,b);

        //print answer list
        for(int val : ans) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}

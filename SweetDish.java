import java.util.ArrayList;
public class SweetDish {
    public static void main(String[] args) {
        int A[] = {1,3,7,4},B=5,C=8;
        int P[] = new int[A.length];
        for(int i=0;i<P.length;i++) {
            P[i] = isPrime(A[i]);
        }
        ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<>();
        for(int i=1;i<Math.pow(2,A.length);i++) {
            ArrayList<Integer> al = new ArrayList<>();
            for(int j=0;j<A.length;j++) {
                if((i&(1<<j))>0) {
                    al.add(A[j]);
                }
            }
            allSubsets.add(al);
        }
        ArrayList<ArrayList<Integer>> allSubsetsPrime = new ArrayList<>();
        for(int i=1;i<Math.pow(2,P.length);i++) {
            ArrayList<Integer> al = new ArrayList<>();
            for(int j=0;j<P.length;j++) {
                if((i&(1<<j))>0) {
                    al.add(P[j]);
                }
            }
            allSubsetsPrime.add(al);
        }
        int count=0;
        for(int i=0;i<allSubsets.size();i++) {
            ArrayList<Integer> al = allSubsets.get(i);
            ArrayList<Integer> alPrime = allSubsetsPrime.get(i);
            int sum = 0,flag=0;
            for(int j=0;j<al.size();j++) {
                if(alPrime.get(j)==1) {flag = 1;}
                sum+=al.get(j);
            }
            if(flag==1 && sum>=B&&sum<=C) count+=1;
        }
        System.out.println(count);
    }
    public static int isPrime(int num) {
        for(int i=2;i*i<=num;i++) {
            if(num%i==0) return 0;
        }
        return 1;
    }
}

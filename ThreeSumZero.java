import java.util.*;
public class ThreeSumZero {
    public static void main(String[] args) {
        Integer AR[] = { 1, -4, 0, 0, 5, -5, 1, 0, -2, 4, -4, 1, -1, -4, 3, 4, -1, -1, -3};
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(AR));
        System.out.println(solve(A));
    }
    public static ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> ANS = new ArrayList<>();
        Collections.sort(A);
        int j=0,k=0;
        for(int i=0;i<A.size()-2;i++) {
            if( i > 0 && A.get(i).equals(A.get(i-1)))
               continue;
            j=i+1;
             k = A.size()-1;
            while(j<k) {
               
                int sum = A.get(i)+A.get(j)+A.get(k);
                if(sum==0) {
                    System.out.println(i+"  "+j+"  "+k);
                    ArrayList<Integer> AL = new ArrayList<>();
                    AL.add(A.get(i));
                    AL.add(A.get(j));
                    AL.add(A.get(k));
                    ANS.add(AL);
                    while(j<k && A.get(j).equals(A.get(j+1))) {
                        j++;
                    }
                    while(j<k && A.get(k).equals(A.get(k-1))) {
                        k--;
                    }
                    j++;
                    k--;
                }
                else if(sum<0) j++;
                else k--;
            }
        }
        return ANS;
    }
}
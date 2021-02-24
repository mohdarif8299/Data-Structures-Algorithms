import java.util.*;
public class MedianSortedArray {
    public static void main(String[] args) {
        Integer AR[] = { -50, -41, -40, -19, 5, 21, 28 };
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(AR));
        Integer BR[] ={-50, -21, -10};
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(BR));
        System.out.println(solve(A,B));
        System.out.println(getElementWithIndex(A,B,-19));
    }
    public static double solve(ArrayList<Integer> A,ArrayList<Integer> B) {
        if(A.size()==1 && B.size()==1) return ((double)(A.get(0)+B.get(0)))/2;
        int num1=0,num2=0,index1=0,index2=0;
        int e1=0,e2=0;
        int low = Math.min(A.get(0),B.get(0));
        int high = Math.max(A.get(A.size()-1),B.get(B.size()-1));
        int N = (A.size()+B.size())/2;
        int X=0;
        while(low<=high) {
            int mid= (low+high)/2;
            int elements1 = ((A.size()+B.size())-getElementsFromArrayGreater(A,B,mid));
            int elements2 = getElementsFromArrayGreater(A,B,mid)-1; 
            if(elements1 == elements2 ) {
                    X = mid;
                    break;
                }
                else if(elements1<elements2) {
                    num1 = elements2;
                    index1 = mid;
                    low= mid+1;
                }
                else  {
                    num2 = elements1;
                    index2 = mid;
                    high = mid-1;
                }  
                if(num1==num2)
                {
                    e1= index1;
                    e2=index2;
                }
        }
        if(e1!=0 && e2!=0) {
            System.out.println(e1+"  "+e2);
           return ((double)(getElementWithIndex(A,B,e1)+getElementWithIndex(A,B,e2)))/2;
        }
        return getElementWithIndex(A,B,X);
    }
    public static int getElementsFromArrayGreater(ArrayList<Integer> A,ArrayList<Integer> B,int X) {
        int count=0;
        int countGreater=0;
        int low = 0,high = A.size()-1;
        while(low<=high) {
            int mid = (low+high)/2;
            if(X>A.get(mid)) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        count = A.size()-(high+1);
        low = 0;high = B.size()-1;
        while(low<=high) {
            int mid = (low+high)/2;
            if(X>B.get(mid)) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        countGreater=B.size()-(high+1);
        return count+countGreater;
    }
    public static double getElementWithIndex(ArrayList<Integer> A,ArrayList<Integer> B,int X) {
        int low=0,high=A.size()-1;
        while(low<=high) {
            int mid = (low+high)/2;
            if(A.get(mid)==X) return A.get(mid);
            else if(X>A.get(mid)) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }  
        if(high+1>A.size()-1) {
            low=0;
            int count = high+1;
            high = B.size()-1;
            while(low<=high) {
                int mid = (low+high)/2;
                if(B.get(mid)==X) return B.get(mid);
                else if(X>B.get(mid)) {
                    low = mid+1;
                }
                else {
                    high = mid-1;
                }
            }
            return B.get(high+1);
        }
        return A.get(high+1);
    }
}
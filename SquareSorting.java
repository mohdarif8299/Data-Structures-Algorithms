import java.util.*;

public class Main {

    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~

    public static int[] sortedSquares(int[] nums) {
        // write your code here
        int p1=0,p2=nums.length-1;
        int arr[] = new int[nums.length];
        int k=nums.length-1;
        while(p1<=p2 && k!=-1) {
            if(Math.abs(nums[p1])<Math.abs(nums[p2])) {
                arr[k] = nums[p2]*nums[p2];
                p2--;
            } else {
                  arr[k] = nums[p1]*nums[p1];
                p1++;
            }
            k-=1;
        }
        return arr;
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] nums = new int[n];
        
        for(int i = 0; i < n; i++) 
            nums[i] = scn.nextInt();
        
        int[] res = sortedSquares(nums);

        for(int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
    }
}

import java.util.*;

public class Main {

    // ~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~
    public static int maxChunksToSorted2(int[] arr) {
        // write your code here
        int A[] = new int[arr.length];
        for(int i=0;i<arr.length;i++) A[i] = arr[i];
        Arrays.sort(A);
        Map<Integer,Integer> map = new HashMap<>();
        int maxChunk=0;
        for(int i=0;i<arr.length;i++) {
            
            if(map.containsKey(arr[i])) {
                map.put(arr[i],map.get(arr[i])+1);
                if(map.get(arr[i])==0) map.remove(arr[i]);
            } else {
                map.put(arr[i],1);
            }
            if(map.containsKey(A[i])) {
                map.put(A[i],map.get(A[i])-1); 
                if(map.get(A[i])==0) map.remove(A[i]);
             } else {
                 map.put(A[i],-1);
             }
            if(map.size()==0) {
                maxChunk+=1;
            }
        }
        return maxChunk;
    }

    // ~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int res = maxChunksToSorted2(arr);
        System.out.println(res);
    }
}

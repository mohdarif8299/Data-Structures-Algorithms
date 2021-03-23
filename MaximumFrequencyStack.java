import java.util.*;
public class MaximumFrequencyStack {
    public static void main(String[] args) {
       // int A[][] = {{1,5},{1,7},{1,5},{1,7},{1,4},{1,5},{2,0},{2,0},{2,0},{2,0}};
        int A[][] = {{1,2},{2,0},{1,2},{1,7},{2,0},{2,0},{1,4},{1,1},{1,7}};
        System.out.println(Arrays.toString(solve(A)));
    }
    public static int[] solve(int[][] A) {
        int ANS[] = new int[A.length];
        Map<Integer,Stack<Integer>> mapStack = new HashMap<>();
        Map<Integer,Integer> frequencyMap = new HashMap<>();
        int currentFrequency = 0;
        Integer maxFrequency = 0;
        for(int i=0;i<A.length;i++) {
            if(A[i][0]==1) {
                if(frequencyMap.containsKey(A[i][1])) {
                    int frq = frequencyMap.get(A[i][1]);
                    frequencyMap.put(A[i][1],frq+1);
                    currentFrequency = frq+1;
                    maxFrequency = Math.max(maxFrequency,currentFrequency);
                }
                else {
                    frequencyMap.put(A[i][1],1);
                    maxFrequency  = Math.max(maxFrequency,1);
                    currentFrequency = 1;
                }
                if(mapStack.containsKey(currentFrequency)) {
                    Stack<Integer> stack = mapStack.get(currentFrequency);
                    stack.push(A[i][1]);
                    mapStack.put(currentFrequency,stack);
                }
                else {
                    Stack<Integer> stack = new Stack<>();
                    stack.push(A[i][1]);
                    mapStack.put(currentFrequency,stack);
                }
            ANS[i] = -1;
            }
            else {
                if(mapStack.containsKey(maxFrequency)) {
                  Stack<Integer> stack = mapStack.get(maxFrequency);
                  ANS[i] = stack.pop();
                  if(stack.isEmpty()){                    
                       mapStack.remove(maxFrequency);
                       maxFrequency-=1;
                    }
                    else {  
                        mapStack.put(maxFrequency,stack); 
                    }
                frequencyMap.put(ANS[i],frequencyMap.get(ANS[i])-1);
               }
            }
        }
        return ANS;
    }
}
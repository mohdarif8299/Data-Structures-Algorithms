public class Solution {
    public static class Car {
        int time;
        int profit;
        Car(int time,int profit) {
            this.time=time;
            this.profit=profit;
        }
    }
    public int solve(int[] A, int[] B) {
        long profit=0;
        int time=0;
        Car car[] = new Car[A.length];
        for(int i=0;i<A.length;i++) {
            car[i] = new Car(A[i],B[i]);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Arrays.sort(car,(c1,c2)->c1.time-c2.time);
       for(int i=0;i<car.length;i++) {
           Car c = car[i];
           if(time<c.time) {
               profit+=c.profit;
               minHeap.add(c.profit);
               time+=1;
           } else {
               if(c.profit>minHeap.peek()) {
                   profit-=minHeap.poll();
                   profit+=c.profit;
                   minHeap.add(c.profit);
               }
           }
       }   
       return (int)(profit%1000000007);
    }
}

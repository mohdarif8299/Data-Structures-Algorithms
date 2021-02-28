import java.util.*;
public class LunchTime2 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0) {
            int S = sc.nextInt();
            int Q[] = new int[S]; 
            for(int i=0;i<S;i++) 
              Q[i] = sc.nextInt();
              int totalTime=0,startingTime=0;
              int EP[] = null, E=0; 
              for(int i=0;i<S;i++) {
                  E = sc.nextInt();
                  EP = new int[E];
                 for(int j=0;j<E;j++) {
                     EP[j] = sc.nextInt();
                     totalTime= EP[0]; 
                  } 
                  for(int k=1;k<E;k++) {
                    if(Q[i]<=EP[k]) 
                    totalTime+=EP[k]-Q[i]; else break;
                  }
                 startingTime+= totalTime;
                 totalTime=0;
              }
              System.out.println(startingTime);
        }
    }
}
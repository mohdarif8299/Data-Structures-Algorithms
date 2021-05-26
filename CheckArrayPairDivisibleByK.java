import java.util.*;

public class Main {
	
	public static void solution(int[] arr, int k){
	      if(arr.length%2==1) {
	          System.out.println(false);
	          return;
	      }
	      boolean flag = true;
	      Map<Integer,Integer> map = new HashMap<>();
	      for(int i=0;i<arr.length;i++) {
	          int remainder = ((arr[i]%k)+k)%k;
	          if(map.containsKey(remainder))
	          map.put(remainder,map.get(remainder)+1); 
	          else map.put(remainder,1);
	      }
	      for(int i=0;i<arr.length;i++) {
	          int rem = (arr[i]%k)%k;
	          if(rem==0) {
	              if( map.containsKey(rem)==false || map.get(rem)%2==1) { 
	                  flag = false;
	                  break;
	              }
	          } else  {
	              if(map.containsKey(rem)==false || map.get(rem)!=map.get(k-rem)){
	                   flag = false;
	                  break;
	              }
	          }
	      }
	      System.out.println(flag);

	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		solution(arr,k);
	}

}

import java.util.*;

public class Main {

	public static ArrayList<Integer> solution(int[] arr, int k) {
	   int N = arr.length;
	   ArrayList<Integer> al = new ArrayList<>();
	   Map<Integer,Integer> map = new HashMap<>();
	   int count=0;
	   for(int i=0;i<k;i++) {
	        if(map.containsKey(arr[i])) {
	             map.put(arr[i],map.get(arr[i])+1);
	        } else {
	            map.put(arr[i],1);
	        }
	   }
	   al.add(map.size());
	   for(int i=0;i<N-k;i++) {
	       
	       // remove ith index from map
	
	       int fre = map.get(arr[i]);
	       if(fre==1) map.remove(arr[i]);
	       else map.put(arr[i],fre-1);
	           
	       // add (i+k)th index to window 
	       if(map.containsKey(arr[i+k])) {
	             map.put(arr[i+k],map.get(arr[i+k])+1);
	       }else {
	           map.put(arr[i+k],1);
	       }
	       al.add(map.size());
	   }
		return al;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		ArrayList<Integer> ans = solution(arr,k);
		for(int a : ans){
			System.out.print(a + " ");
		}
	}


}

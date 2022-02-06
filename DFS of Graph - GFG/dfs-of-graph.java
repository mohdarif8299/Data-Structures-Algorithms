// { Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj =
                new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < V; i++) adj.add(new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.dfsOfGraph(V, adj);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean isVisited[] = new boolean[V+1];
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        isVisited[0] = true;
        return dfs(0, adj, isVisited, list);
    }
    public static ArrayList<Integer> dfs(int src, ArrayList<ArrayList<Integer>> adj, boolean isVisited[], ArrayList<Integer> list) {
        if(src == adj.size()) return list;
        
        for(int n: adj.get(src)) {
            if(isVisited[n] == false) {
                list.add(n);
                isVisited[n] = true;
                dfs(n, adj, isVisited, list);
            }
        }
        return list;
    }
}
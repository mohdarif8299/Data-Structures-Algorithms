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
Time Complexity: O(V + E)
Space Complexity: O(V)

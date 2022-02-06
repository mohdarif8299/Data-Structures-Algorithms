## BFS Graph

class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
       ArrayList<Integer> list = new ArrayList<>();
       Queue<Integer> queue = new LinkedList<>();
       boolean isVisited[] = new boolean[V+1];
       queue.add(0);
       isVisited[0] = true;
       list.add(0);
       while(!queue.isEmpty()) {
           int source = queue.poll();
           for(int node: adj.get(source)) {
               if(isVisited[node] == false) {
                   list.add(node);
                   isVisited[node] = true;
                   queue.add(node);
               }
           }
       }
       return list;
     }
}
Time Complexity: O(V + E)
Space Complexity: O(V)

package src;

import java.util.ArrayList;

public class G08_DetectCycleInDirectedGraphDFS {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] inRecursion = new boolean[V];

        for(int i = 0; i<V;i++){ // this loop is to go all the graph if there are multiple graphs
            if(!visited[i] && dfs(adj, i, visited, inRecursion)){
                return true;
            }
        }

        return false;
    }


    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int start, boolean[] visited, boolean[] inRecursion){
        visited[start] = true;
        inRecursion[start] = true;

        for(int i:adj.get(start)){
            if((!visited[i] && dfs(adj, i, visited, inRecursion)) || inRecursion[i]){
                return true;
            }
        }

        inRecursion[start] = false;
        return false;
    }
}

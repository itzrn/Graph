package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class G04_DFS {
    // here creating Undirected Graph
    Map<Integer, List<Integer>> graph = new HashMap<>();

    public void buildGraph(int src, int dest){
        if(!graph.containsKey(src)){
            graph.put(src, new ArrayList<>());
        }
        graph.get(src).add(dest);
    }


    public void print(){
        for (Integer i:graph.keySet()){
            System.out.println(i + " -> " + graph.get(i));
        }
    }

    List<Integer> res = new ArrayList<>();
    public void dfs(int start, boolean[] visited){ // arr can be used when the nodes value is from 0 to n-1
        if(visited[start]){
            return;
        }

        visited[start] = true;
        res.add(start);
        for(int i:graph.get(start)){
            dfs(i,visited);
        }
    }

    public static void main(String[] args) {
        G04_DFS dfs = new G04_DFS();
        dfs.buildGraph(0,2);
        dfs.buildGraph(0,3);
        dfs.buildGraph(0,1);

        dfs.buildGraph(2,0);
        dfs.buildGraph(2,4);

        dfs.buildGraph(4,2);

        dfs.buildGraph(3,0);

        dfs.buildGraph(1,0);
        dfs.print();
        dfs.dfs(0,new boolean[dfs.graph.size()]);
        System.out.println(dfs.res);
    }

}

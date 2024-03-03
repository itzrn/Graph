package src;

import java.util.*;

// this is used to calculate the shortest path instead of using dfs
public class G05_BFS {
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

    public void bfs(int start, boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[start] = true;
        while(!queue.isEmpty()){
            for (int i: graph.get(queue.peek())){
                if(!visited[i]){
                    queue.add(i);
                    visited[i] = true;
                }
            }
            System.out.println(queue.poll());
        }
    }

    public static void main(String[] args) {
        G05_BFS bfs = new G05_BFS();
        bfs.buildGraph(0,2);
        bfs.buildGraph(0,3);
        bfs.buildGraph(0,1);

        bfs.buildGraph(2,0);
        bfs.buildGraph(2,4);

        bfs.buildGraph(4,2);

        bfs.buildGraph(3,0);

        bfs.buildGraph(1,0);


        bfs.bfs(0, new boolean[5]);
    }
}

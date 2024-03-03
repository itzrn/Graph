package src;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
Code here is actually going to be same as khan's algo
so, we fill try to find topological sorting using khan's algo, as in topological sorting is possible when there is no cycle in the graph.
And while finding topological sorting, we couldn't able to find then we will declare that there is a cycle in the graph
 */
public class G11_CycleDetectionInDirectedGraphBFS {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        return bfs(V, adj);
    }

    public boolean bfs(int V, ArrayList<ArrayList<Integer>> adj){ // this is actually a khan's algo
        int[] inDegree = new int[V];

        // step 1 - calculating inDegree for every node
        for(ArrayList<Integer> i:adj){
            for(int j:i){
                inDegree[j]++;
            }
        }

        int count = 0;

        //  step 2 - fill queue have in degree zero
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(inDegree[i] == 0){
                queue.add(i);
                count++;
            }
        }

        // step 3 - bfs
        while(!queue.isEmpty()){
            int u = queue.poll();
            for(int v: adj.get(u)){
                inDegree[v]--;
                if(inDegree[v] == 0){
                    queue.add(v);
                    count++;
                }
            }
        }

        return count == V;
    }
}
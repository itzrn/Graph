package src;

/**
 * Given a Directed Acyclic Graph (DAG) with V vertices and E edges, Find any Topological Sorting of that Graph.
 *
 * Example 1:
 *
 * Input:
 *
 * Output:
 * 1
 * Explanation:
 * The output 1 denotes that the order is
 * valid. So, if you have, implemented
 * your function correctly, then output
 * would be 1 for all test cases.
 * One possible Topological order for the
 * graph is 3, 2, 1, 0.
 * Example 2:
 *
 * Input:
 *
 * Output:
 * 1
 * Explanation:
 * The output 1 denotes that the order is
 * valid. So, if you have, implemented
 * your function correctly, then output
 * would be 1 for all test cases.
 * One possible Topological order for the
 * graph is 5, 4, 2, 1, 3, 0.
 * Your Task:
 * You don't need to read input or print anything. Your task is to complete the function topoSort()  which takes the
 * integer V denoting the number of vertices and adjacency list as input parameters and returns an array consisting of the
 * vertices in Topological order. As there are multiple Topological orders possible, you may return any of them. If your returned topo sort is correct then the console output will be 1 else 0.
 *
 * Expected Time Complexity: O(V + E).
 * Expected Auxiliary Space: O(V).
 *
 * Constraints:
 * 2 ≤ V ≤ 104
 * 1 ≤ E ≤ (N*(N-1))/2
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class G10_TopologicalSortBFSKahnsAlgo {
    public int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] inDegree = new int[V];

        // step 1 - calculating the in degree of each element
        for(ArrayList<Integer> i:adj){
            for(int j:i){
                inDegree[j]++;
            }
        }

        //  step 2 - fill queue have in degree zero
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }

        // step 3- Simple bfs
        List<Integer>res = new ArrayList<>();
        while(!queue.isEmpty()){
            int u = queue.poll();
            res.add(u);
            for(int v: adj.get(u)){
                inDegree[v]--;
                if(inDegree[v] == 0){
                    queue.add(v);
                }
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}

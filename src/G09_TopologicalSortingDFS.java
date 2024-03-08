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
 * vertices in Topological order. As there are multiple Topological orders possible, you may return any of them. If your returned
 * topo sort is correct then the console output will be 1 else 0.
 *
 * Expected Time Complexity: O(V + E).
 * Expected Auxiliary Space: O(V).
 *
 * Constraints:
 * 2 ≤ V ≤ 104
 * 1 ≤ E ≤ (N*(N-1))/2
 */

/*
This is the sorting which is only available in directed graph
If there is cycle in a graph then it is not possible to write topological sorting
There can be multiple order of topological sorting
 */

import java.util.ArrayList;
import java.util.Stack;

public class G09_TopologicalSortingDFS {
    public int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        for(int i = 0;i<V;i++){
            if(!visited[i]){
                dfs(i, visited, adj, stack);
            }
        }

        int[] ans = new int[V];

        int i = 0;
        while(!stack.isEmpty()){ // we are using stack so that we can easily put the node (the node from where we can not fo further) at the end
            ans[i] = stack.pop();
            i++;
        }
        return ans;
    }

    public void dfs(int start, boolean[] visited, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack){ // this is normal dfs
        visited[start] = true;
        for(int i:adj.get(start)){
            if(!visited[i]){
                dfs(i, visited, adj, stack);
            }
        }
        stack.push(start);
    }
}

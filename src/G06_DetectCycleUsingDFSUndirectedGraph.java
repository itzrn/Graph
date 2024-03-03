package src;

/**
 * Given an undirected graph with V vertices and E edges, check whether it contains
 * any cycle or not. Graph is in the form of adjacency list where adj[i] contains all the nodes ith node is having edge with.
 *
 * Example 1:
 *
 * Input:
 * V = 5, E = 5
 * adj = {{1}, {0, 2, 4}, {1, 3}, {2, 4}, {1, 3}}
 * Output: 1
 * Explanation:
 *
 * 1->2->3->4->1 is a cycle.
 * Example 2:
 *
 * Input:
 * V = 4, E = 2
 * adj = {{}, {2}, {1, 3}, {2}}
 * Output: 0
 * Explanation:
 *
 * No cycle in the graph.
 *
 *
 * Your Task:
 * You don't need to read or print anything. Your task is to complete the function isCycle() which takes V denoting
 * the number of vertices and adjacency list as input parameters and returns a boolean value denoting if the undirected
 * graph contains any cycle or not, return 1 if a cycle is present else return 0.
 *
 * NOTE: The adjacency list denotes the edges of the graph where edges[i] stores all other vertices to which ith vertex is connected.
 *
 *
 *
 * Expected Time Complexity: O(V + E)
 * Expected Space Complexity: O(V)
 *
 *
 *
 *
 * Constraints:
 * 1 ≤ V, E ≤ 105
 */

import java.util.ArrayList;

public class G06_DetectCycleUsingDFSUndirectedGraph {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean[] visited = new boolean[V];
        for(int i = 0;i<V;i++){// this is used so that we can visit all graphs if there are more than one graph, so taking every element as the starting point
            if(!visited[i] && dfs(i, adj, -1, visited)){
                return true;
            }
        }

        return false;
    }

    // here we are using dfs traversal
    public boolean dfs(int start, ArrayList<ArrayList<Integer>> adj, int parent, boolean[] visited){
        visited[start] = true;
        for(Integer i: adj.get(start)){
            if(i == parent){ // this is used to detect that we are not moving back from where we came
                continue;
            }

            if(visited[i]){ // at this condition, mean there is a loop
                return true;
            }

            if(dfs(i, adj, start, visited)){ // this is used as recursion
                return true;
            }
        }

        return false;
    }
}

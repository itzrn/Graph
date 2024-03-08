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
import java.util.LinkedList;
import java.util.Queue;

public class G07_DetectCycleUsingBFSUndirectedGraph {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        for(int i = 0;i<V;i++){// this is used so that we can visit all graphs if there are more than one graph
            if(!visited[i] && bfs(i, adj, visited)){
                return true;
            }
        }

        return false;
    }

    public boolean bfs(int start, ArrayList<ArrayList<Integer>> adj, boolean[] visited){
        Queue<int[]> queue = new LinkedList<>(); // using queue with pairs
        queue.add(new int[]{start, -1}); // putting the starting point
        visited[start] = true;
        while(!queue.isEmpty()){
            int[] temp = queue.poll(); // taking the front element from the queue
            for(int i : adj.get(temp[0])){ // iterating through every adjacent node
                if(!visited[i]){// if it's not visited
                    visited[i] = true; // then make it visited
                    queue.add(new int[]{i, temp[0]}); // add it to queue
                }else if(i != temp[1]){ // if its visited, and it's not the parent node then return true -> reaching to visited node
                    return true;
                }
            }
        }

        return false;
    }
}

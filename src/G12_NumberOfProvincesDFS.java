package src;

/**
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b,
 * and city b is connected directly with city c, then city a is connected indirectly with city c.
 *
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 *
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly
 * connected, and isConnected[i][j] = 0 otherwise.
 *
 * Return the total number of provinces.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * Output: 2
 * Example 2:
 *
 *
 * Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * Output: 3
 *
 *
 * Constraints:
 *
 * 1 <= n <= 200
 * n == isConnected.length
 * n == isConnected[i].length
 * isConnected[i][j] is 1 or 0.
 * isConnected[i][i] == 1
 * isConnected[i][j] == isConnected[j][i]
 */

public class G12_NumberOfProvincesDFS {
    public int findCircleNum(int[][] isConnected) {
        // imp1 -> The word connected implies that this is the graph question
        // imp2 -> Here the graph is represented in Matrix form, which we can directly use, or you can make your own graph using Map

        int n = isConnected.length; // imp3 -> n number of nodes are there
        boolean[] visited = new boolean[n];
        int count=0;
        for(int i=0; i<n; i++){
            if(!visited[i]){ // imp4 -> increasing the count by one when we find any node not visited
                count++;
                recursion(i, isConnected, visited, n); // then we do dfs to make visited for that province
            }
        }

        return count;
    }

    public void recursion(int start, int[][] graph, boolean[] visited, int n){
        visited[start] = true; // imp5 -> making it visited so that node won't get count in other province
        for(int i=0; i<n; i++){
            if(!visited[i] && graph[start][i] == 1){
                recursion(i, graph, visited, n);
            }
        }
    }
}

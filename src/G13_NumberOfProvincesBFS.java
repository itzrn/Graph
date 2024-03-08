package src;

import java.util.LinkedList;
import java.util.Queue;

// same previous question

public class G13_NumberOfProvincesBFS {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count=0;
        for(int i=0; i<n; i++){
            if(!visited[i]){
                count++;
                bfs(i, isConnected, visited, n);
            }
        }

        return count;
    }

    public void bfs(int start, int[][] graph, boolean[] visited, int n){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            int a = queue.poll();
            for(int i = 0;i<n; i++){
                if(!visited[i] && graph[a][i] == 1){
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}

package src;

import java.util.ArrayList;
import java.util.List;

public class G02_RepresentationOfGraph {
    public List<EdgeW>[] createGraph(){
        int numberOfVertex = 4;
        List<EdgeW>[] graph = new ArrayList[numberOfVertex];

        for(int i = 0;i<numberOfVertex;i++){
            graph[i] = new ArrayList<>();
        }

        addEdge(graph, 0,2,2);

        addEdge(graph, 1,10,2);
        addEdge(graph, 1,0,3);

        addEdge(graph, 2,2,0);
        addEdge(graph, 2,10,1);
        addEdge(graph, 2,-1,3);

        addEdge(graph, 3,0,1);
        addEdge(graph, 3,-1,2);

        return graph;
    }

    public void addEdge(List<EdgeW>[] graph, int src, int weight,  int dest){
        graph[src].add(new EdgeW(src,weight,dest));
    }
}
package src;
// this is the graph created which have no edge weight
import java.util.ArrayList;
import java.util.List;

public class G01_RepresentationOfGraph {
    public List<EdgeNW>[] createGraph(){
        int numberOfVertex = 4;
        List<EdgeNW>[] graph = new ArrayList[numberOfVertex];

        for(int i = 0;i<numberOfVertex;i++){
            graph[i] = new ArrayList<>();
        }

        addEdge(graph, 0,2);

        addEdge(graph, 1,2);
        addEdge(graph, 1,3);

        addEdge(graph, 2,0);
        addEdge(graph, 2,1);
        addEdge(graph, 2,3);

        addEdge(graph, 3,1);
        addEdge(graph, 3,2);

        return graph;
    }

    public void addEdge(List<EdgeNW>[] graph, int src, int dest){
        graph[src].add(new EdgeNW(src,dest));
    }
}
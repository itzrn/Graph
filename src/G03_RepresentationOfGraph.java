package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class G03_RepresentationOfGraph {
    Map<Integer, List<Integer>> graph = new HashMap<>();

    public void buildGraph(int[][] arr){
        for(int[] i : arr){
            addEdge(i[0],i[1]);
        }
        print();
    }

    // this is for directed edges
    public void addEdge(int src, int dest){
        if(!graph.containsKey(src)){
            graph.put(src, new ArrayList<>());
        }
        graph.get(src).add(dest);
    }

    public void print(){
        for(Integer i: graph.keySet()){
            System.out.println(i + " -> " + graph.get(i));
        }
    }

    public static void main(String[] args) {
        G03_RepresentationOfGraph t = new G03_RepresentationOfGraph();
//        int[][] arr = new int[4][2];
        int[][] arr = {{1,0}, {2,0}, {2,1},{3,1}};
        t.buildGraph(arr);

    }

}
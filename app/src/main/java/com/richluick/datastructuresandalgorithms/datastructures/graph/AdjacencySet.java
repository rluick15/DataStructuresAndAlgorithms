package com.richluick.datastructuresandalgorithms.datastructures.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rluic on 2/7/2017.
 */

public class AdjacencySet implements Graph {

    private List<GraphNode> vertexList = new ArrayList<>();
    private GraphType graphType = GraphType.DIRECTED;
    private int numVertices = 0;

    public AdjacencySet(GraphType graphType, int numVertices) {
        this.graphType = graphType;
        this.numVertices = numVertices;

        for (int i = 0; i < numVertices; i++) {
            vertexList.add(new GraphNode(i));
        }
    }

    @Override
    public void addEdge(int v1, int v2) {
        if (v1 >= numVertices || v1 < 0 || v2 >= numVertices || v2 < 0) {
            throw new IllegalArgumentException("");
        }

        vertexList.get(v1).addEdge(v2);
        if (graphType == GraphType.UNDIRECTED) {
            vertexList.get(v2).addEdge(v1);
        }
    }

    @Override
    public List<Integer> getAdjacentVertices(int v) {
        if (v >= numVertices || v < 0) {
            throw new IllegalArgumentException("");
        }

        return vertexList.get(v).getAdjacentVertices();
    }
}

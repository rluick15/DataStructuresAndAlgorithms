package com.richluick.datastructuresandalgorithms.datastructures.graph;

import java.util.List;

/**
 * Created by rluic on 2/6/2017.
 */

public interface Graph {

    enum GraphType {
        DIRECTED,
        UNDIRECTED
    }

    void addEdge(int v1, int v2);

    List<Integer> getAdjacentVertices(int v);
}

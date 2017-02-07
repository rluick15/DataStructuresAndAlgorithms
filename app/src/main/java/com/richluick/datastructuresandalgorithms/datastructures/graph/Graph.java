package com.richluick.datastructuresandalgorithms.datastructures.graph;

import java.util.List;

/**
 * Created by q1410049 on 2/7/17.
 */

public interface Graph {

    enum GraphType {
        DIRECTED,
        UNDIRECTED
    }

    void addEdge(int v1, int v2);

    List<Integer> getAdjacentVertices(int v);
}

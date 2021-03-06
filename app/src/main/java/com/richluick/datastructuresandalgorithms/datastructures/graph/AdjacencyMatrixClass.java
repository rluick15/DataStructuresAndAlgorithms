package com.richluick.datastructuresandalgorithms.datastructures.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by q1410049 on 2/7/17.
 */

public class AdjacencyMatrixClass implements Graph {

    private int[][] adjacencyMatrix;
    private GraphType graphType = GraphType.DIRECTED;
    private int numVertices = 0;

    public AdjacencyMatrixClass(int[][] adjacencyMatrix, GraphType graphType) {
        this.adjacencyMatrix = adjacencyMatrix;
        this.graphType = graphType;

        adjacencyMatrix = new int [numVertices][numVertices];

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                adjacencyMatrix[i][j] = 0;
            }
        }
    }

    @Override
    public void addEdge(int v1, int v2) {
        if (v1 >= numVertices || v1 < 0 || v2 >= numVertices || v2 < 0) {
            throw new IllegalArgumentException("");
        }

        adjacencyMatrix[v1][v2] = 1;
        if (graphType == GraphType.UNDIRECTED) {
            adjacencyMatrix[v2][v1] = 1;
        }
    }

    @Override
    public List<Integer> getAdjacentVertices(int v) {
        if (v >= numVertices || v < 0) {
            throw new IllegalArgumentException("");
        }

        List<Integer> adjacentVerticies = new ArrayList<>();

        for (int i = 0; i < numVertices; i++) {
            if (adjacencyMatrix[v][i] == 1) {
                adjacentVerticies.add(i);
            }
        }

        Collections.sort(adjacentVerticies);

        return adjacentVerticies;
    }

    @Override
    public int getNumVertices() {
        return numVertices;
    }

    @Override
    public int getIndegree(int v) {
        if (v >= numVertices || v < 0) {
            throw new IllegalArgumentException("");
        }

        int indegree = 0;
        for (int i = 0; i < numVertices; i++) {
            if (adjacencyMatrix[i][v] != 0) {
                indegree++;
            }
        }

        return indegree;
    }
}

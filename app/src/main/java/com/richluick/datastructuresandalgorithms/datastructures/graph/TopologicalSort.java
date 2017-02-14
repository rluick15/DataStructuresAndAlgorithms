package com.richluick.datastructuresandalgorithms.datastructures.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by q1410049 on 2/14/17.
 */

public class TopologicalSort {

    public static List<Integer> sort(Graph graph) {
        LinkedList<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> indegreeMap = new HashMap<>();

        for (int i = 0 ; i < graph.getNumVertices(); i++) {
            int indegree = graph.getIndegree(i);
            indegreeMap.put(i, indegree);
            if (indegree == 0) {
                queue.add(i);
            }
        }

        List<Integer> sortedList = new ArrayList<>();
        while (!queue.isEmpty()) {
            int vertex = queue.pollLast();
            sortedList.add(vertex);

            List<Integer> adjacentVertices = graph.getAdjacentVertices(vertex);
            for (int adjaentVertex : adjacentVertices) {
                int updatedIndegree = indegreeMap.get(adjaentVertex) - 1;
                indegreeMap.remove(adjaentVertex);
                indegreeMap.put(adjaentVertex, updatedIndegree);

                if (updatedIndegree == 0) {
                    queue.add(adjaentVertex);
                }
            }
        }

        if (sortedList.size() != graph.getNumVertices()) {
            throw new RuntimeException("Graph has a cycle");
        }

        return sortedList;
    }
}

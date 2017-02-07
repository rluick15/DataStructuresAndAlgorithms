package com.richluick.datastructuresandalgorithms.datastructures.graph;

import com.richluick.datastructuresandalgorithms.datastructures.queue.Queue;
import com.richluick.datastructuresandalgorithms.datastructures.queue.QueueOverflowException;
import com.richluick.datastructuresandalgorithms.datastructures.queue.QueueUnderflowException;

/**
 * Created by rluic on 2/7/2017.
 */

public class GraphTraversal {

    //todo: must iterate over all nodes and call this method for unconnected graph
    public static void depthFirstTraversal(Graph graph, int[] visited, int currentVertex) {
        if (visited[currentVertex] == 1) {
            return;
        }
        visited[currentVertex] = 1;

        for (int vertex : graph.getAdjacentVertices(currentVertex)) {
            depthFirstTraversal(graph, visited, vertex);
        }
        System.out.println(currentVertex + "->");
    }

    public static void breadthFirst(Graph graph, int[] visited, int currentVertex) throws QueueOverflowException, QueueUnderflowException {
        if (visited[currentVertex] == 1) {
            return;
        }

        Queue<Integer> queue = new Queue<>(Integer.class);
        queue.enqueue(currentVertex);
        while (!queue.isEmpty()) {
            int vertex = queue.dequeue();

            if (visited[vertex] == 1) {
                continue;
            }
            System.out.print(vertex);
            visited[currentVertex] = 1;

            for (int adjacentVertex : graph.getAdjacentVertices(vertex)) {
                if (adjacentVertex != 1) {
                    queue.enqueue(adjacentVertex);
                }
            }
        }
    }
}

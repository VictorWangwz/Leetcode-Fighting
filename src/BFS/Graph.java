package BFS;

import java.util.*;

public class Graph {
    Node root;
    public Graph(int n, int[][] edges){
        Map<Integer, HashSet<Node>> graph = new HashMap<>();
        Map<Integer, Node> node_map = new HashMap<>();
        for(int i = 0; i < n; i++){
            graph.put(i, new HashSet<>());
            node_map.put(i, new Node(i));
        }
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(node_map.get(v));
            graph.get(v).add(node_map.get(u));
        }
        for(int i = 0; i < n; i++){
            List<Node> neighbors = new LinkedList<>();
            neighbors.addAll(graph.get(i));
            node_map.get(i).neighbors = neighbors;
        }
        root = node_map.get(0);
    }
}

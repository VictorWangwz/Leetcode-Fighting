package BFS;

import java.util.*;

public class BFSInGraph {

    // Build Graph with node number and edges
    public  static Map<Integer, HashSet<Integer>> initializeGraph(int n, int[][] edges){
        Map<Integer, HashSet<Integer>> m = new HashMap<>();
        for(int i = 0; i < n; i++){
            m.put(i, new HashSet<>());
        }
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            m.get(u).add(v);
            m.get(v).add(u);
        }
        return m;
    }

    // Check whether a graph is a tree
    public boolean validTree(int n, int[][] edges) {
        if(n < 1){
            return false;
        }
        if(edges.length != n - 1){
            return false;
        }

        Map<Integer, HashSet<Integer>> m;
        m = initializeGraph(n, edges);

        List<Integer> q = new LinkedList<>();
        ((LinkedList<Integer>) q).offer(0);
        Set<Integer> s = new HashSet<>();
        s.add(0);
        while(!q.isEmpty()){
            int e = ((LinkedList<Integer>) q).pollFirst();
            for(Integer neighbor: m.get(e)){
                if(s.contains(neighbor)){
                    continue;
                }
                q.add(neighbor);
                s.add(neighbor);
            }
        }
        return s.size() == n;
    }

    //Clone Graph
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        Node rst = new Node();
        rst.val = node.val;
        List<Node> ori_q = new LinkedList<>();
        List<Node> cur_q = new LinkedList<>();
        ori_q.add(node);
        cur_q.add(rst);
        Map<Node, Node> visited_nodes = new HashMap<>();
        visited_nodes.put(node, rst);

        while(!cur_q.isEmpty()){
            Node ori = ((LinkedList<Node>) ori_q).pollFirst();
            Node cur = ((LinkedList<Node>) cur_q).pollFirst();
            cur.neighbors = new LinkedList<>();
            for(Node neighbor: ori.neighbors){
                Node temp;
                if(!visited_nodes.containsKey(neighbor)){
                    temp = new Node();
                    ori_q.add(neighbor);
                    cur_q.add(temp);
                    visited_nodes.put(neighbor, temp);
                }
                temp = visited_nodes.get(neighbor);
                temp.val = neighbor.val;
                cur.neighbors.add(temp);

            }
        }
        return rst;
    }


    // Connected componentin Undirected Graph
    public static int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        List<List<Integer>> edgesList = new ArrayList<>();
        for(int i = 0; i < n; i ++){
            edgesList.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            edgesList.get(edges[i][0]).add(edges[i][1]);
            edgesList.get(edges[i][1]).add(edges[i][0]);
        }

        Queue<Integer> q = new LinkedList<>();
        int rst = 0;

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                q.offer(i);
                rst ++;
                while(!q.isEmpty()){
                    int cur = q.poll();
                    visited[cur] = true;
                    List<Integer> l = edgesList.get(cur);
                    for(Integer temp: l){
                        if(!visited[temp])
                            q.offer(temp);
                    }
                }
            }

        }
        return rst;
    }

    public static int countComponents2(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        Map<Integer, HashSet<Integer>> m = initializeGraph(n, edges);

        Queue<Integer> q = new LinkedList<>();
        int rst = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i] && m.containsKey(i)){
                q.offer(i);
                rst ++;
                while(!q.isEmpty()){
                    int idx = q.poll();
                    visited[idx] = true;
                    Set<Integer> s = m.get(idx);
                    for(int temp: s){
                        if(!visited[temp]){
                            q.offer(temp);
                        }
                    }
                }
            }

        }
        return rst;
    }

    public static void main(String[] args) {
        BFSInGraph g = new BFSInGraph();
        int n = 4;
        int[][] edges = {{0, 1}, {1, 2}, { 2, 3}, {3, 0}};
        Graph graph = new Graph(4, edges);
        Node cloned_node = g.cloneGraph(graph.root);
        int rst = countComponents2(n, edges);
        System.out.println(rst);
    }
}

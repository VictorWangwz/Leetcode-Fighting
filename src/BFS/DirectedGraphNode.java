package BFS;

import java.util.*;

class DirectedGraphNode {
     int label;
     ArrayList<DirectedGraphNode> neighbors;
     DirectedGraphNode(int x) {
         label = x;
         neighbors = new ArrayList<DirectedGraphNode>();
     }

     // Get the Topological Order of DAG
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> rst = new ArrayList<>();
        Map<DirectedGraphNode, Integer> m = new HashMap<>();
        for(DirectedGraphNode node: graph){
            if(!m.containsKey(node)){
                m.put(node, 0);
            }
            for(DirectedGraphNode neighbor: node.neighbors){
                if(!m.containsKey(neighbor)){
                    m.put(neighbor, 1);
                    continue;
                }
                m.put(neighbor, m.get(neighbor) + 1);
            }
        }
        List<DirectedGraphNode> q = new LinkedList<>();
        for(DirectedGraphNode node: graph){
            if(m.containsKey(node) && m.get(node) == 0){
                q.add(node);
                rst.add(node);
            }
        }
        while(!q.isEmpty()){
            DirectedGraphNode cur = ((LinkedList<DirectedGraphNode>) q).pollFirst();
            for(DirectedGraphNode neighbor: cur.neighbors){
                m.put(neighbor, m.get(neighbor) - 1);
                if(m.get(neighbor) == 0){
                    q.add(neighbor);
                    rst.add(neighbor);
                }
            }
        }
        return rst;
    }

    // 207. Course Schedule
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
         List<Integer>[] graph =  new ArrayList[numCourses];
         int[] degree = new int[numCourses];
         List<Integer> q = new LinkedList<>();
         for(int i = 0; i < numCourses; i++){
             graph[i] = new ArrayList<>();
         }
         for(int i = 0; i < prerequisites.length; i++){
             graph[prerequisites[i][0]].add(prerequisites[i][1]);
             degree[prerequisites[i][1]] ++;
         }
         for(int i = 0; i < numCourses; i++){
             if(degree[i] == 0){
                q.add(i);
             }
         }
         for(int i = 0; i < q.size(); i++){
             for(Integer j: graph[q.get(i)]){
                 degree[j]--;
                 if(degree[j] == 0) q.add(j);
             }
         }
         return q.size() == numCourses;
    }

    // 210. Course Schedule II
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] degrees = new int[numCourses];
        int[] rst = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < prerequisites.length; i++){
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
            degrees[prerequisites[i][0]] ++;
        }
        List<Integer> q = new ArrayList<>();
        int idx = 0;
        for(int i = 0; i < numCourses; i++){
            if(degrees[i] == 0) {
                q.add(i);
                rst[idx++] = i;
            }
        }
        for(int i = 0; i < q.size(); i++){
            for(Integer j: graph[q.get(i)]){
                if(--degrees[j] == 0){
                    q.add(j);
                    rst[idx++] = j;
                }
            }
        }
        if(q.size() != numCourses)
            return new int[0];
        return rst;
    }

    // Sequence Reconstruction
//    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
//        return true
//    }

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        int[] rst = findOrder(numCourses, prerequisites);
        System.out.println(rst);
    }

 };

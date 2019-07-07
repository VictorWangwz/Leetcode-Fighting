package vopreparation0530;


//There are a total of n courses you have to take, labeled from 0 to n-1.
//
//        Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
//
//        Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
//
//        There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

import java.util.ArrayList;
import java.util.List;

//210. Course Schedule II
public class CourseSchedule2 {

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] ls = new List[numCourses];
        int[] degrees = new int[numCourses];
        int[] rst = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            ls[i] = new ArrayList<>();
        }
        for(int[] pair: prerequisites){
            ls[pair[1]].add(pair[0]);
            degrees[pair[0]] ++;
        }
        List<Integer> q = new ArrayList<>();
        int idx = 0;
        for(int i = 0; i < ls.length; i++){
            if(degrees[i] == 0) {
                q.add(i);
                rst[idx++] = i;
            }
        }
        for(int i = 0; i < q.size(); i++){
            for(Integer course: ls[q.get(i)]){
                if(--degrees[course] == 0) {
                    q.add(course);
                    rst[idx++] = course;
                }
            }
        }
        if(q.size() != numCourses)
            return new int[0];
        return rst;

    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1,0},{0,1}};
        int[] rst = findOrder(numCourses, prerequisites);
        int[] expected = {0,1,2,3};// or 0,2,1,3
        System.out.print(rst);
    }
}

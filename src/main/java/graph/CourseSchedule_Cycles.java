package graph;

import java.util.ArrayList;
import java.util.HashMap;

public class CourseSchedule_Cycles {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] visited = new int[numCourses];
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for(int i = 0; i < numCourses; i++){
            ArrayList<Integer> pre = map.put(i, new ArrayList<Integer>());
        }
        for(int[] pre: prerequisites){
            ArrayList<Integer> preList = map.get(pre[0]);
            preList.add(pre[1]);
            map.put(pre[0], preList);
        }

        for(int course: map.keySet()){
            if(visited[course] == 0 && !canFinish(visited, map, course)){
                return false;
            }
        }
        return true;
    }

    public boolean canFinish(int[] visited, HashMap<Integer, ArrayList<Integer>> map, int k){
        if(visited[k] == 1) return false;

        visited[k] = 1;

        for(int course: map.get(k)){
            boolean canFinish = canFinish(visited, map, course);
            if(!canFinish) return false;
        }
        visited[k] = 2;
        return true;
    }

}

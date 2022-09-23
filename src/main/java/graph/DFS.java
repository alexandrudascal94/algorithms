package graph;

import java.util.ArrayList;
import java.util.Arrays;

public class DFS {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2},{4},{3},{},{}};

        int[][] visited = new int[matrix.length][];

        getDfs(matrix).forEach(System.out::println);
    }

    private static ArrayList<Integer> getDfs(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        int[] visited = new int[matrix.length];
        Arrays.fill(visited, 0);

        for(int i = 0; i < matrix.length; i++){
            if(visited[i] == 0){
                result.add(i);
                visited[i] = 1;
                for (int j = 0; j < matrix[i].length; j++){
                    int next = matrix[i][j];
                    if(visited[next] == 0){
                        result.add(next);
                        visited[next] = 1;
                    }
                }
            }
        }
        return result;
    }
}

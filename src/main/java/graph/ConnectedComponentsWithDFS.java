package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ConnectedComponentsWithDFS {

    public static void main(String[] args) {
        System.out.println(getConnectedComponents(new int[][]{
                {0, 1},
                {1, 2},
                {3, 4},
                {0, 4}
        }, 5));
    }

    private static int getConnectedComponents(int[][] edges, int n) {
        // transform the edges to easier format
        // this is called adjacency list
        HashMap<Integer, ArrayList<Integer>> nodes = new HashMap<>();

        for (int[] edge : edges) {
            int first = edge[0];
            int second = edge[1];

            if (nodes.containsKey(first)) {
                nodes.get(first).add(second);
            } else {
                ArrayList<Integer> connected = new ArrayList<>();
                connected.add(second);
                nodes.put(first, connected);
            }

            if (nodes.containsKey(second)) {
                nodes.get(second).add(first);
            } else {
                ArrayList<Integer> connected = new ArrayList<>();
                connected.add(first);
                nodes.put(second, connected);
            }
        }

        int[] visited = new int[n];
        Arrays.fill(visited, 0);
        int components = 0;

        for (int node : nodes.keySet()) {
            if (visited[node] == 0) {
                dfs(node, nodes, visited);
                components++;
            }
        }
        return components;
    }

    private static void dfs(int node, HashMap<Integer, ArrayList<Integer>> nodes, int[] visited) {
        if(visited[node] == 1){
            return;
        }
        visited[node] = 1;
        for(int connected : nodes.get(node)){
            dfs(connected, nodes, visited);
        }
    }
}

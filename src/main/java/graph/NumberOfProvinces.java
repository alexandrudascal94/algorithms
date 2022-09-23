package graph;

public class NumberOfProvinces {

    public int findCircleNum(int[][] isConnected) {
        int[] visited = new int[isConnected.length];
        int provinces = 0;

        for(int i = 0; i < isConnected.length; i++){
            if(visited[i] == 0){
                provinces++;
                dfs(visited, isConnected, i);
            }
        }
        return provinces;
    }

    private void dfs(int[] visited, int[][] isConnected, int k){
        for(int i = 0; i < isConnected[k].length; i++){
            if(isConnected[k][i] == 1 && visited[i] == 0){
                visited[i] = 1;
                dfs(visited, isConnected, i);
            }
        }
    }
}

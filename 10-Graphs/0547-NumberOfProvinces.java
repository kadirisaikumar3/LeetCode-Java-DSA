class NumberOfProvinces {
    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;
        for (int city = 0; city < n; city++) {
            if (!visited[city]) {
                provinces++;
                dfs(isConnected, visited, city);
            }   }
        return provinces;
    }
    private static void dfs(int[][] isConnected,
                            boolean[] visited,
                            int city) {
        visited[city] = true;
        for (int neighbor = 0;
             neighbor < isConnected.length;
             neighbor++) {
            if (isConnected[city][neighbor] == 1
                    && !visited[neighbor]) {

                dfs(isConnected, visited, neighbor);    }   }   }
    public static void main(String[] args) {
        int[][] isConnected = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        int result = findCircleNum(isConnected);
        System.out.println("Number of Provinces: " + result);
    }
}
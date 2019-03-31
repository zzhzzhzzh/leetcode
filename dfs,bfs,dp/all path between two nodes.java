public List<String> printPath(int[][] m, int n)
    {         
         List<String> res = new ArrayList<>();
         if (n == 0 || m == null || m.length == 0) {
             return res;
         }
         String path = "";
         dfs(m, n, 0, 0, path, res);        
         return res;
    }
    private void dfs(int[][] m, int n, int x, int y, String path, List<String> res) {
        if(x == n - 1 && y == n - 1) {
            res.add(path);
            path = path.substring(0, path.length() - 1);
            return;
        }
        
        if (x + 1 >= 0 && x + 1 < n && y >= 0 && y < n && m[x + 1][y] == 1) {
            path = path + "D";
            dfs(m, n, x + 1, y, path, res);
            path = path.substring(0, path.length() - 1);
        }
        if (y + 1 >= 0 && y + 1 < n && x >= 0 && x < n && m[x][y + 1] == 1) {
            path = path + "R";
            dfs(m, n, x, y + 1, path, res);
            path = path.substring(0, path.length() - 1);
        }
    }

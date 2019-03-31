class Solution {
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) return false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0, visited)) {
                    return true;
                }
            }
        return false;
    }
    public boolean dfs(char[][] board, String word, int i, int j, int length, boolean[][] visited) {
        if (length == word.length()) return true;
        if (!inBound(board, i, j) || visited[i][j] || board[i][j] != word.charAt(length)) return false;
        
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            
            if (dfs(board, word, i + dx[k], j + dy[k], length + 1, visited)) return true;
            
        }
        visited[i][j] = false;
        return false;
    }
    public boolean inBound(char[][] board, int i, int j) {
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
    }
}

package leetCodes;

public class Interview12 {
    public boolean exist(char[][] board, String word) {
        char[] wd = word.toCharArray();
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (dfs(board, wd, i , j ,0)) return true;
            }
        }
        return false;
    }
    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if (i >= board.length || j >= board[0].length || i < 0 || j < 0 || board[i][j] != word[k]) return false;
        if (k == word.length - 1) return true;
        char tmp = board[i][j];
        board[i][j] = '/';
        boolean ans = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i, j - 1, k + 1);
        board[i][j] = tmp;
        return ans;
    }

}

package $130;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
	public void solveDFS(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        
        int rows = board.length, cols = board[0].length;
        
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') {
                dfs(0, j, board);
            }
            if (board[rows - 1][j] == 'O') {
                dfs(rows - 1, j, board);
            }
        }
        
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                dfs(i, 0, board);
            }
            if (board[i][cols - 1] == 'O') {
                dfs(i, cols - 1, board);
            }
        }
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    void dfs(int row, int col, char[][] board) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != 'O') {
            return;
        }
        board[row][col] = '#';
        dfs(row - 1, col, board);
        dfs(row + 1, col, board);
        dfs(row, col - 1, board);
        dfs(row, col + 1, board);
    }
    
    public void solveBFS(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int rows = board.length, cols = board[0].length;
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') {
                bfs(board, 0, j);
            }
        }
        for (int j = 0; j < cols; j++) {
            if (board[rows - 1][j] == 'O') {
                bfs(board, rows - 1, j);
            }
        }
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                bfs(board, i, 0);
            }
        }
        for (int i = 0; i < rows; i++) {
            if (board[i][cols - 1] == 'O') {
                bfs(board, i, cols - 1);
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    void bfs(char[][] board, int row, int col) {
        int m = board.length, n = board[0].length;
        board[row][col] = '#';
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(row * n + col);
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            int i = curr / n, j = curr % n;
            if (i > 1 && board[i - 1][j] == 'O') {
                board[i - 1][j] = '#';
                queue.offer((i - 1) * n + j);
            }
            if (i + 1 < m && board[i + 1][j] == 'O') {
                board[i + 1][j] = '#';
                queue.offer((i + 1) * n + j);
            }
            if (j > 1 && board[i][j - 1] == 'O') {
                board[i][j - 1] = '#';
                queue.offer(i * n + j - 1);
            }
            if (j + 1 < n && board[i][j + 1] == 'O') {
                board[i][j + 1] = '#';
                queue.offer(i * n + j + 1);
            }
        }
    }
}

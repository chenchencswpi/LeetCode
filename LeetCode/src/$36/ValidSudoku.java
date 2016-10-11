package $36;

import java.util.HashSet;

public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
        //first check all the rows
        for (int row = 0; row < 9; row++) {
            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                if (board[row][i] != '.') {
                    if (set.contains(board[row][i])) {
                        return false;
                    }
                    set.add(board[row][i]);
                }
            }
        }
        //second check all columns
        for (int column = 0; column < 9; column++) {
            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                if (board[i][column] != '.') {
                    if (set.contains(board[i][column])) {
                        return false;
                    }
                    set.add(board[i][column]);
                }
            }
        }
        //finally check all subsquares
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!isValidSub(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    boolean isValidSub(char[][] board, int i, int j) {
        HashSet<Character> set = new HashSet<>();
        for (int row = i * 3; row < i * 3 + 3; row++) {
            for (int col = j * 3; col < j * 3 + 3; col++) {
                if (board[row][col] != '.') {
                    if (set.contains(board[row][col])) {
                        return false;
                    }
                    set.add(board[row][col]);
                }
            }
        }
        return true;
    }
}

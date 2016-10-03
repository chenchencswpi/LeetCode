package $200;

public class NumberOfIslands {
	public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int counts = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                if (grid[row][column] == '1') {
                    counts++;
                    dfs(grid, row, column);
                }
            }
        }
        return counts;
    }
    
    void dfs(char[][] grid, int row, int column) {
        grid[row][column] = '2';
        //go up
        if (row - 1 >= 0 && grid[row - 1][column] == '1') {
            dfs(grid, row - 1, column);
        }
        //go right
        if (column + 1 < grid[0].length && grid[row][column + 1] == '1') {
            dfs(grid, row, column + 1);
        }
        //go down
        if (row + 1 < grid.length && grid[row + 1][column] == '1') {
            dfs(grid, row + 1, column);
        }
        //go left
        if (column - 1 >= 0 && grid[row][column - 1] == '1') {
            dfs(grid, row, column - 1);
        }
    }
}

package $286;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
	public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        for (int row = 0; row < rooms.length; row++) {
            for (int column = 0; column < rooms[0].length; column++) {
                if (rooms[row][column] == 0) {
                    bfs(row, column, rooms);
                }
            }
        }
    }
    
    void bfs(int row, int column, int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        int[] curr = {row, column};
        queue.offer(curr);
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            //check left
            if (now[1] - 1 >= 0 && rooms[now[0]][now[1] - 1] > rooms[now[0]][now[1]] + 1) {
                rooms[now[0]][now[1] - 1] = rooms[now[0]][now[1]] + 1;
                int[] neighbor = {now[0], now[1] - 1};
                queue.offer(neighbor);
            }
            //check up
            if (now[0] - 1 >= 0 && rooms[now[0] - 1][now[1]] > rooms[now[0]][now[1]] + 1) {
                rooms[now[0] - 1][now[1]] = rooms[now[0]][now[1]] + 1;
                int[] neighbor = {now[0] - 1, now[1]};
                queue.offer(neighbor);
            }
            //check right
            if (now[1] + 1 < rooms[0].length && rooms[now[0]][now[1] + 1] > rooms[now[0]][now[1]] + 1) {
                rooms[now[0]][now[1] + 1] = rooms[now[0]][now[1]] + 1;
                int[] neighbor = {now[0], now[1] + 1};
                queue.offer(neighbor);
            }
            //check down
            if (now[0] + 1 < rooms.length && rooms[now[0] + 1][now[1]] > rooms[now[0]][now[1]] + 1) {
                rooms[now[0] + 1][now[1]] = rooms[now[0]][now[1]] + 1;
                int[] neighbor = {now[0] + 1, now[1]};
                queue.offer(neighbor);
            }
        }
    }
}

package $207;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] preCount = new int[numCourses];
        for (int[] prerequisite: prerequisites) {
            preCount[prerequisite[0]]++;
        }
        //loop through all the courses to find those do not need prerequisites
        Queue<Integer> queue = new LinkedList<>();
        int finished = 0;
        for (int i = 0; i < numCourses; i++) {
            if (preCount[i] == 0) {
                queue.offer(i);
            }
        }
        finished = queue.size();
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int[] prerequisite: prerequisites) {
                if (prerequisite[1] == curr) {
                    preCount[prerequisite[0]]--;
                    if (preCount[prerequisite[0]] == 0) {
                        queue.offer(prerequisite[0]);
                        finished++;
                    }
                }
            }
        }
        return finished == numCourses;
    }
}

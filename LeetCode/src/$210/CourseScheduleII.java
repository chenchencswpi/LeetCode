package $210;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> finished = new ArrayList<>();
        int[] preCount = new int[numCourses];
        for (int[] prerequisite: prerequisites) {
            preCount[prerequisite[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        int currIndex = 0;
        for (int i = 0; i < numCourses; i++) {
            if (preCount[i] == 0) {
                queue.add(i);
                finished.add(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int currCourse = queue.poll();
            for (int[] prerequisite: prerequisites) {
                if (prerequisite[1] == currCourse) {
                    preCount[prerequisite[0]]--;
                    if (preCount[prerequisite[0]] == 0) {
                        queue.add(prerequisite[0]);
                        finished.add(prerequisite[0]);
                    }
                }
            }
        }
        if (finished.size() != numCourses) {
            return new int[0];
        }
        int[] res = new int[finished.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = finished.get(i);
        }
        return res;
    }
}

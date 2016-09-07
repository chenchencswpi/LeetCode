package array;

/**<a href="https://leetcode.com/problems/container-with-most-water/">原文链接</a>
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, 
 * which together with x-axis forms a container, such that the container contains the most water.
 */

/**
 * 题目中的container，我们就叫它木桶好了。题目的意思是： 给一个非负数组，每一个数字代表了一条木板的长度。让我们求出哪两个板放一起可以使得容积最大（放最多的水）？
 * 容积的计算公式是长度（坐标差） * Math.min(木板1的高度， 木板2的高度)。为啥？别告诉我你不知道木桶原理。。。
 */
public class ContainerWithMostWater {
	/**
	 * brute force. 列举出所有可能性，保证万无一失。时间复杂度n方。
	 * @param height
	 * @return
	 */
	public int maxArea(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		
        int max = Integer.MIN_VALUE;
        
        for (int left = 0; left < height.length - 1; left++) {
        	for (int right = left + 1; right < height.length; right++) {
        		int area = (right - left) * Math.min(height[left], height[right]);
        		if (area > max) {
        			max = area;
        		}
        	}
        }
        
        return max;
    }
	
	/**
	 * 重复讲了很多次，不要害怕提出蛮力算法。。没啥害羞的。提出蛮力算法后，面试官一般会问你：你还能optimize吗？作为摆渡翁的弟子，你当然要自豪的说：能！
	 * 当然了，牛逼是吹出去了，可咱还是得坐下来静静： 怎么optimize呢？
	 * 我们刚开始拿到这个题的时候就会想，选最两边的木板有没有可能。这样的想法也没啥错，毕竟长度最长。但接下来呢？因为已经看过最两边的木板了，下一步只能往中间看了。
	 * 现在我们有两个指针指向最两边的木板，那么下一步，该挪动哪个指针？应该是长度短的那个。为什么？因为影响容积的，是短板。如果现在挪动长板，体积只可能降（两种情况：
	 * 1.新板比短板长度长：但是短板还是那么短，而且两板距离没以前那么长，所以体积变小；2： 新板比短板还短，那就更没的说了）。那么我们挪动短板，直到发现一个比短板高度
	 * 要高的，我们就停下来，重新计算最大体积。时间复杂度为O(n)。代码如下：
	 * @param height
	 * @return
	 */
	public int maxArea2(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		
		int max = Integer.MIN_VALUE;
		
		int left = 0, right = height.length - 1;
		while (left < right) {
			max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
			if (height[left] <= height[right]) {
				int shortHeight = height[left];
				left++;
				while (left < right) {
					if (height[left] <= shortHeight) {
						left++;
					} else {
						break;
					}
				}
				if (left == right) {
					break;
				}
			} else {
				int shortHeight = height[right];
				right--;
				while (right > left) {
					if (height[right] <= shortHeight) {
						right--;
					} else {
						break;
					}
				}
				if (left == right) {
					break;
				}
			}
		}
		return max;
	}
}

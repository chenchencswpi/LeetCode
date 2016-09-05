package array;

public class MergeSortedArray {
	
	public static void main(String[] args) {
		int[] array1 = {3}, array2 = {1};
		new MergeSortedArraySolution().merge(array1, 0, array2, 1);
		for (int i: array1) {
			System.out.println(i);
		}
	}
}

class MergeSortedArraySolution {
	/**
	 * Create a new array to merge nums1 and nums2. Then assign this new array to m1.
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m + n];
        
        int index1 = 0, index2 = 0;
        int current = 0;
        
        while (index1 < m && index2 < n) {
        	if (nums1[index1] <= nums2[index2]) {
        		res[current++] = nums1[index1++];
        	} else {
        		res[current++] = nums2[index2++];
        	}
        }
        
        if (index1 < m) {
        	while (index1 < m) {
        		res[current++] = nums1[index1++];
        	}
        }
        
        if (index2 < n) {
        	while (index2 < n) {
        		res[current++] = nums2[index2++];
        	}
        }
        
        nums1 = res;
    }
}

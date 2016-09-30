package array;

/**
 * <a href="https://leetcode.com/problems/merge-sorted-array/"></a>
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array. You may assume 
 * that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. 
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 */


public class MergeSortedArray {
	
	/**
	 * Create a new array to merge nums1 and nums2. Then assign this new array to m1.
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
	public int[] merge(int[] nums1, int m, int[] nums2, int n) {
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
        
        return res;
    }

	/**
	 * Notice another hint memtioned in the question: nums1 is long enough to hold additional elements from nums2,
	 * which means, we could somehow store elements from nums2 to nums1.
	 *
	 * Since we are going to merge nums2 into nums1, is it possible for us to start from left to right?
	 * Yes, but it's going to be lots of extra work. If an element from nums2 is inserted into nums1, we have to migrate
     * all elements after this insertion position to right by 1 spot.
     *
     * We can start from back to front, right to left. The advantage is we do not need to relocate the elements after we
     * insert an element from nums2 array.
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 * @return
	 */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        m--;
        n--;

        while (m >= 0 && n >= 0) {
            if (nums2[n] > nums1[m]) {
                nums1[index--] = nums2[n--];
            } else {
                nums1[index--] = nums1[m--];
            }
        }

        if (n >= 0) {
            while (n >= 0) {
                nums1[index--] = nums2[n--];
            }
        }
	}
}


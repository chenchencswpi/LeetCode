package $88;

public class MergeSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int right = m + n - 1;
        m--; n--;
        while (m >= 0 && n >= 0) {
            if (nums1[m] >= nums2[n]) {
                nums1[right--] = nums1[m--];
            } else {
                nums1[right--] = nums2[n--];
            }
        }
        if (n >= 0) {
            for (int i = 0; i <= n; i++) {
                nums1[i] = nums2[i];
            }
        }
    }
}

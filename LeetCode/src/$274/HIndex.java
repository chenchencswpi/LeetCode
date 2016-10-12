package $274;

import java.util.Arrays;
import java.util.Collections;

public class HIndex {
	public int hIndex(int[] citations) {
        if (citations  == null || citations.length <= 0) {
            return 0;
        }
        Integer[] cit = new Integer[citations.length];
        for (int i = 0; i < citations.length; i++) {
            cit[i] = citations[i];
        }
        Arrays.sort(cit, Collections.reverseOrder());
        for (int i = 0; i < cit.length; i++) {
            if (i >= cit[i]) return i;
        }
        return cit.length;
    }
}

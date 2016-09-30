package $339;

import java.util.List;

public class NestedListWeightSum {
	public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null) {
            return 0;
        }
        int sum = 0;
        for (NestedInteger nestedInteger: nestedList) {
            sum += process(nestedInteger, 1);
        }
        return sum;
    }
    
    int process(NestedInteger nest, int weight) {
        if (nest.isInteger()) {
            return weight * nest.getInteger();
        } else {
            int sum = 0;
            for (NestedInteger nestnest: nest.getList()) {
                sum += process(nestnest, weight + 1);
            }
            return sum;
        }
    }
}

interface NestedInteger {
	public boolean isInteger();
	public int getInteger();
	public List<NestedInteger> getList();
}
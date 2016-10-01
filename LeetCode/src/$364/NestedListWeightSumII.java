package $364;

import java.util.ArrayList;
import java.util.List;

public class NestedListWeightSumII {
	public int depthSumInverseDFS(List<NestedInteger> nestedList) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int sum = 0;
        for (NestedInteger ni: nestedList) {
            process(res, ni, 0);
        }
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                sum += (res.size() - i) * res.get(i).get(j);
            }
        }
        return sum;
    }
    
    void process(List<List<Integer>> res, NestedInteger nestedInteger, int depth) {
        List<Integer> list;
        if (depth >= res.size()) {
            res.add(new ArrayList<Integer>());
        }
        list = res.get(depth);
        if (nestedInteger.isInteger()) {
            list.add(nestedInteger.getInteger());
        } else {
            for (NestedInteger ni: nestedInteger.getList()) {
                process(res, ni, depth + 1);
            }
        }
    }
    
    public int depthSumInverseBFS(List<NestedInteger> nestedList) {
        int unweighted=0,weighted = 0;
        while(!nestedList.isEmpty()){
            List<NestedInteger> nextLevel=new ArrayList<>();
            for(NestedInteger ni:nestedList){
                if(ni.isInteger())
                    unweighted+=ni.getInteger();
                else
                    nextLevel.addAll(ni.getList());
            }
            weighted+=unweighted;
            nestedList=nextLevel;
        }
        return weighted;
    }
}

interface NestedInteger{
	public boolean isInteger();
	public Integer getInteger();
	public List<NestedInteger> getList();
}
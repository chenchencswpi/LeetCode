package $347;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TopKFrequentElements {
	public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int number: nums) {
            if (map.containsKey(number)) {
                map.put(number, map.get(number) + 1);
            } else {
                map.put(number, 1);
            }
        }

        class Pair {
            int number;
            int count;

            public Pair(int number, int count) {
                this.number = number;
                this.count = count;
            }
        }

        //我们需要建立一个最小堆
        PriorityQueue<Pair> heap = new PriorityQueue<Pair>(new Comparator<Pair>(){
            public int compare(Pair first, Pair second){
                return first.count - second.count;
            }
        });

        for (int num: map.keySet()) {
            Pair pair = new Pair(num, map.get(num));
            heap.offer(pair);

            if (heap.size() > k) {
                heap.poll();
            }
        }

        List<Integer> list = new ArrayList<Integer>();

        while (!heap.isEmpty()) {
            list.add(heap.poll().number);
        }
        //因为题目没有要求返回的list必须为升序或者降序，所以直接返回即可。
        return list;
    }
}

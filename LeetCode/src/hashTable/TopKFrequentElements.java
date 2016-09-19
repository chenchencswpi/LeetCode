package hashTable;

/**
 * <a href="https://leetcode.com/problems/top-k-frequent-elements/">原文链接</a>
 * Given a non-empty array of integers, return the k most frequent elements.
 */

/**
 * 这道题问的是给一个数组，让我们来寻找出现频率最高的K个元素。
 * 题目其实非常的直接，我们脑子里的第一想法是先用一个哈希表去统计每个元素出现的次数，然后维护一个Collection，但是要限定这个Collection的
 * size只能是K。在读前K个元素的时候，我们只要将其放在Collection就好了。但是对于后面的元素，我们就要和这个Collection里的元素比较，如果
 * 它出现的次数要高于Collection里面元素最低的出现频率，那就把该元素放进去，把出现频率最低的那个元素剔除出来。
 *
 * 那么问题来了，我们要维护怎样的一个Collection呢？
 */

import java.util.*;


public class TopKFrequentElements {
    /**
     * 第一种方法，数组。
     */

    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int number: nums) {
            if (map.containsKey(number)) {
                map.put(number, map.get(number) + 1);
            } else {
                map.put(number, 1);
            }
        }

        class Pair implements Comparable<Pair>{ //定义一个内部类来存储数字及其出现次数的pair.
            int number;
            int count;

            public Pair(int number, int count) {
                this.number = number;
                this.count = count;
            }

            @Override
            public int compareTo(Pair other) {
                if (this.count < other.count) {
                    return -1;
                } else if (this.count == other.count) {
                    return 0;
                } else {
                    return 1;
                }
            }
        }

        Pair[] topK = new Pair[k];
        int currentSize = 0;
        for (int num: map.keySet()) {
            if (currentSize < k) {
                topK[currentSize++] = new Pair(num, map.get(num));
            } else {
                Arrays.sort(topK);
                int occurNumber = map.get(num);
                if (occurNumber > topK[0].count) {
                    topK[0] = new Pair(num, occurNumber);
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for (Pair pair: topK) {
            list.add(pair.number);
        }

        return list;
    }

    /**
     * 可以看到，在第一种解法里，每当我们往数组里插入一个新的元素时，我们都要对整个数组进行排序。这样做非常的啰嗦，那么有没有更好的办法呢？
     * 摆渡翁当然是有更好的解法啦！那就是用 堆！
     * 在Java里，堆的功能是可以用PriorityQueue来实现的。
     */

    public List<Integer> topKFrequent2(int[] nums, int k) {
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

        //我们需要建立一个最小堆，这样每个element只需要和root进行比较就可以了。
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

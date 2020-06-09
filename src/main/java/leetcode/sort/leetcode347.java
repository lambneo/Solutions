package leetcode.sort;



import java.util.*;

/**
 * 出现频率最多的k个元素，先hashmap遍历，之后建立堆，最后输出
 */
public class leetcode347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }


        //自定义排序的写法需要学习
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for (int n : map.keySet()){
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        List<Integer> ans = new LinkedList<>();
        while (!heap.isEmpty())
            ans.add(heap.poll());
        Collections.reverse(ans);

        //java8中，list可以直接转型为int[]
        return ans.stream().mapToInt(Integer::intValue).toArray();
//        int[] res = new int[ans.size()];
//        for (int i = 0; i < ans.size(); i++){
//            res[i] = ans.get(i);
//        }

    }
}

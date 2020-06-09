package leetcode.sort;

import java.util.*;

public class leetcode451 {
    public String frequencySort(String s) {
        if (s.length() <= 1) return s;
        char[] ch = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char i : ch)
            map.put(i, map.getOrDefault(i, 0) + 1);
        PriorityQueue<Character> heap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for (char i : map.keySet())
            heap.add(i);
        StringBuilder ans = new StringBuilder();
        while (!heap.isEmpty()){
            int tmp = map.get(heap.peek());
            char letter = heap.poll();
            for (int i = 0; i < tmp; i++){
                ans.append(letter);
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        leetcode451 test = new leetcode451();
        System.out.println(test.frequencySort("aaaccccd"));
    }
}

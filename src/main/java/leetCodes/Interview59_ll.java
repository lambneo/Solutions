package leetCodes;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 实现最大值队列，借助辅助队列
 */
public class Interview59_ll {
    Deque<Integer> deque;
    Queue<Integer> queue;
    public void MaxQueue() {
        deque = new LinkedList<>();
        queue = new LinkedList<>();
    }

    public int max_value() {
        return deque.size()>0?deque.peekFirst():-1;
    }

    public void push_back(int value) {
        queue.add(value);
        while (deque.size() > 0 && deque.peekLast() < value)
            deque.pollLast();
        deque.offer(value);
    }

    public int pop_front() {
        int ans = queue.size() > 0 ? queue.poll():-1;
        if (deque.size() > 0 && ans == deque.peekFirst())
            deque.pollFirst();
        return ans;
    }
}

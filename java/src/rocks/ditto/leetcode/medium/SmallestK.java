package src.rocks.ditto.leetcode.medium;

import java.util.PriorityQueue;

/**
 * 面试题 17.14. 最小K个数
 * https://leetcode-cn.com/problems/smallest-k-lcci/
 */
public class SmallestK {

    public int[] smallestK(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);

        for (int num : arr){
            if ( k > priorityQueue.size()) {
                priorityQueue.offer(num);
            } else if (priorityQueue.peek() > num){
                priorityQueue.poll();
                priorityQueue.offer(num);
            }
        }
        int[] result = new int[k];
        int i = 0;
        while (!priorityQueue.isEmpty() && (i < k)){
            result[i] = priorityQueue.poll();
            i++;
        }
        return result;
    }
}

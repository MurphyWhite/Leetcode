package src.rocks.ditto.leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 502. IPO
 * https://leetcode-cn.com/problems/ipo/
 */
public class FindMaximizedCapital {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new int[]{capital[i], profits[i]});
        }
        // 按消耗排序
        Collections.sort(list, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
        int i = 0;
        while (k-- > 0){
            // 资本w不会减少
            while ( i < n && list.get(i)[0] <= w ){
                priorityQueue.add(list.get(i++)[1]);
            }
            // 当前资本能做的项目都已经加入到队列中了
            // 如果没有可做资本
            if (priorityQueue.isEmpty()) {
                break;
            }
            w += priorityQueue.poll();
        }
        return w;
    }
}

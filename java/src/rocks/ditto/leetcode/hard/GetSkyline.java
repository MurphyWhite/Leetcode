package src.rocks.ditto.leetcode.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 218. 天际线问题
 * https://leetcode-cn.com/problems/the-skyline-problem/
 */
public class GetSkyline {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans = new ArrayList<>();
        /**
         * 预处理所有的点
         * 左端点高度为负，右端点高度为正
         */
        List<int[]> points = new ArrayList<>();
        for (int[] building : buildings){
            int l = building[0], r = building[1], h = building[2];
            points.add(new int[] {l, -h});
            points.add(new int[] {r, h});
        }
        /**
         * 然后把端点进行排序
         * 先按照横坐标进行排序
         * 如果横坐标相同，则按照左端点排序
         * 如果相同的左/右端点，则按照高度进行排序
         */
        points.sort( (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } 
            return a[1] - b[1];
        } );

        /**
         * 优先队列，高的优先
         */
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>( (a , b) -> b - a);
        /**
         * 之前已经记录的边的高度
         */
        int prev = 0;
        priorityQueue.add(prev);
        /**
         * 遍历的时候由左侧的低点开始
         */
        for ( int[] point : points ) {
            int x = point[0] , height = point[1];
            if (height < 0) {
                priorityQueue.add(-height);
            } else {
                priorityQueue.remove(height);
            }
            int cur = priorityQueue.peek();
            if (cur != prev) {
                List<Integer> list = new ArrayList<>();
                list.add(x);
                list.add(cur);
                ans.add(list); 
                prev = cur;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        
    }
}

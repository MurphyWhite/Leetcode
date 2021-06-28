package src.rocks.ditto.leetcode.hard;

import java.util.*;

/**
 *  815. 公交路线
 *  https://leetcode-cn.com/problems/bus-routes/
 */
public class NumBusesToDestination {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        // 起点是终点
        if (source == target) {
            return 0;
        }

        // 将路线放入图中, station -> set(可以上车的线路)
        Map<Integer, Set<Integer>> map = new HashMap<>();
        // 等待遍历的线路
        Deque<Integer> deque = new ArrayDeque<>();
        // 搭乘上该线路需要换乘多少次
        Map<Integer, Integer> cost = new HashMap<>();
        int n = routes.length;
        for (int i = 0; i < n ; i++){
            for (int station : routes[i]) {
                if (station == source) {
                    // 需要等待遍历的线路
                    deque.add(i);
                    // 这些路线可以直接在起点上车
                    cost.put(i, 1);
                }
                Set<Integer> set = map.getOrDefault(station, new HashSet<>());
                set.add(i);
                map.put(station, set);
            }
        }
        while (!deque.isEmpty()){
            int bus = deque.poll();
            int step = cost.get(bus);

            // 遍历该路线的所有车站
            for (int station : routes[bus]) {
                if (station == target){
                    return step;
                }
                // 把这个站的车加入到队列中
                Set<Integer> lines = map.get(station);
                if (lines == null) {
                    continue;
                }
                for ( Integer line : lines){
                    // 这线路之前没有办法上车
                    if (!cost.containsKey(line)){
                        cost.put(line, step + 1);
                        deque.add(line);
                    }
                }
            }
        }
        return -1;
    }
}

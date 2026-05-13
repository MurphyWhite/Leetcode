package src.rocks.ditto.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 1665. Minimum Initial Energy to Finish Tasks
 * https://leetcode.cn/problems/minimum-initial-energy-to-finish-tasks/?envType=daily-question&envId=2026-05-12
 */
public class MinimumEffort {

    public int minimumEffort(int[][] tasks) {
        List<int[]> list = new ArrayList<>(Arrays.stream(tasks).toList());
        // 排序完，在前面的
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int delta1 = o1[1] - o1[0];
                int delta2 = o2[1] - o2[0];
                if (delta1  == delta2) {
                    return o2[1] - o1[1];
                } else  {
                    return delta1 - delta2;
                }
            }
        });

        //
        int min = 0;
        for (int i = 0; i < list.size(); i++) {
            min += list.get(i)[0];
            if (min < list.get(i)[1]) {
                min = list.get(i)[1];
            }
        }
        return min;
    }

}

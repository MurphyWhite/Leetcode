package src.rocks.ditto.leetcode.hard;

import java.util.*;

/**
 * 354. 俄罗斯套娃信封问题
 * https://leetcode.cn/problems/russian-doll-envelopes/solutions/633231/e-luo-si-tao-wa-xin-feng-wen-ti-by-leetc-wj68/
 */
public class MaxEnvelopes {

    // dynamic plan , 超出时间限制
    public int maxEnvelopes(int[][] envelopes) {

        // no envelopes
        if (envelopes.length == 0) return 0;

        int n = envelopes.length;

        // [1, 1] [1, 2],
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    // sort as decrease then h won't become an increasing subsequence
                    return o2[1] - o1[1];
                }
            }
        });



        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int ans = 1;
        // longest increasing subsequence
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // because height are decrease, so if wide is same, this won't make sense
                if (envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // check longest
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    // 二分查找
    public int maxEnvelopes2(int[][] envelopes) {

        // no envelopes
        if (envelopes.length == 0) return 0;

        int n = envelopes.length;

        /**
         * 排序策略：
         * - 按宽度 w 升序排序
         * - 当 w 相同时，按高度 h 降序排序
         *
         * 为什么不用额外考虑 w：
         * 由于我们只找高度的递增子序列，而同宽度的信封已经按高度降序处理了，
         * 这意味着在递增子序列中，同宽度的信封不可能被同时选中。
         * 例如：相同宽度的信封 [w, h1] 和 [w, h2]，排序后是 [w, max(h1,h2)] 和 [w, min(h1,h2)]
         * 因为 h 是降序的，较小的 h 在后面，不满足 "递增" 的条件，所以不会同时被选入 LIS。
         * 这样就自动保证了选中信封的宽度也是严格递增的。
         */
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    // 相同宽度时，按高度降序排序，确保不会选出两个相同宽度的信封
                    return o2[1] - o1[1];
                }
            }
        });

        ArrayList<Integer> list = new ArrayList<>();
        list.add(envelopes[0][1]);
        // longest increasing subsequence
        for (int i = 1; i < n; i++) {
            int h = envelopes[i][1];
            if (h > list.get(list.size() - 1)) {
                list.add(h);
            } else {
                int index = BinarySearch(list, h);
                list.set(index, h);
            }

        }
        return list.size();
    }


    // 1 2, 3 2
    private int BinarySearch(List<Integer> f, int target) {
        int l = 0 , r = f.size() - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (f.get(mid) < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}


package src.rocks.ditto.leetcode.medium;

/**
 * 274. H 指数
 * https://leetcode-cn.com/problems/h-index/
 */
public class HIndex {

    public int hIndex(int[] citations) {
        int left = 0, right = citations.length;
        while ( left < right) {
            int mid = left + (right - left) / 2 + 1;
            if (check(citations, mid)){
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean check(int[] citations, int mid){
        int ans = 0;
        for (int citation : citations) {
            if (citation >= mid){
                ans++;
            }
        }
        // 如果大于，证明可以
        return ans >= mid;
    }
}

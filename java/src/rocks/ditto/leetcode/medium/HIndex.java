package src.rocks.ditto.leetcode.medium;

/**
 * H 指数
 */
public class HIndex {

    /**
     * 274. H 指数（这题主要是数组并不是有序的，而是无序的）
     * https://leetcode-cn.com/problems/h-index/
     * @param citations
     * @return
     */
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

    /**
     * 275. H 指数 II
     * https://leetcode-cn.com/problems/h-index-ii/
     * @param citations
     * @return
     */
    public int hIndexII(int[] citations){
        int n = citations.length;
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            /**
             * c[i] >= n - i
             * c[i] >= i
             */
            if (citations[mid] >= n - mid){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return citations[right] >= n - right ? n - right : 0;
    }
}

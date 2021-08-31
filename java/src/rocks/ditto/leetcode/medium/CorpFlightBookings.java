package src.rocks.ditto.leetcode.medium;

/**
 *  1109. 航班预订统计
 *  https://leetcode-cn.com/problems/corporate-flight-bookings/submissions/
 */
public class CorpFlightBookings {

    /**
     * 差分
     * @param bookings
     * @param n
     * @return
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        // 前缀和的逆向
        int[] preSum = new int[n + 1];
        // 第i个比第i-1个，差距是preSum[i]
        for (int[] booking : bookings){
            int l = booking[0] - 1, r = booking[1] - 1, seats = booking[2];
            preSum[l] += seats;
            preSum[r + 1] -= seats;
        }

        // 差分法
        int[] ans = new int[n];
        ans[0] = preSum[0];
        for (int i = 1; i < n; i++){
            ans[i] = ans[i - 1] + preSum[i];
        }
        return ans;
    }
}

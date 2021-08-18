package src.rocks.ditto.leetcode.hard;

/**
 * 552. 学生出勤记录 II
 * https://leetcode-cn.com/problems/student-attendance-record-ii/
 */
public class CheckRecordII {

    int mod = (int) 1e9 + 7;

    int[][][] cache;
    // 记忆化搜索
    public int checkRecord(int n) {
        cache = new int[n + 1][2][3];
        for (int i = 0 ; i <= n; i++){
            // A
            for (int j = 0; j < 2; j++){
                for (int k = 0; k < 3; k++){
                    cache[i][j][k] = -1;
                }
            }
        }

        return dfs(n, 0, 0);
    }

    private int dfs(int u, int aCnt, int lCnt){
        // A 超过 2，不成立
        if (aCnt >= 2){
            return 0;
        }
        if (lCnt >= 3){
            return 0;
        }
        if (u == 0){
            return 1;
        }
        // 已经计算过了
        if (cache[u][aCnt][lCnt] != -1){
            return cache[u][aCnt][lCnt];
        }
        int ans = 0;
        ans = dfs(u - 1, aCnt + 1, 0) % mod; // 这位是A的情况
        ans = (ans + dfs(u - 1, aCnt, lCnt + 1)) % mod; // 这位是L的情况
        ans = (ans + dfs(u - 1, aCnt, 0) )% mod; // 这位是P的情况
        cache[u][aCnt][lCnt] = ans;
        return ans;
    }
}

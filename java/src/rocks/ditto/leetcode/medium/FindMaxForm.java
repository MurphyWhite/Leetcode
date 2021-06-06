package src.rocks.ditto.leetcode.medium;

/**
 * 474. 一和零
 * https://leetcode-cn.com/problems/ones-and-zeroes/
 */
public class FindMaxForm {

    /**
     *
     * @param strs
     * @param m 0的数量
     * @param n 1的数量
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
        // 01 背包
        int length = strs.length;
        // 成本计算
        int[][] cnt = new int[length][2];
        for (int i=0; i<length; i++){
            String str = strs[i];
            int zero = 0, one = 0;
            for (char c : str.toCharArray()){
                if (c == '0'){
                    zero++;
                } else {
                    one++;
                }
            }
            // 成本计算
            cnt[i] = new int[]{zero, one};
        }

        //01 背包
        // f[k][i][j] 代表考虑前 k 件物品，在数字 1 容量不超过 i，数字 0 容量不超过 j 的条件下的「最大价值」（每个字符串的价值均为 1）。
        int[][][] f = new int[length][m+1][n+1];
        // 第一个物品
        for (int i=0; i<=m; i++){
            for (int j=0; j<=n; j++)
            f[0][i][j] = (i>=cnt[0][0] && j>=cnt[0][1]) ? 1:0;
        }
        for (int k=1; k< length; k++){
            for (int i=0; i<=m; i++){
                for (int j=0; j<=n; j++){
                    int no = f[k-1][i][j];
                    int with = (i>= cnt[k][0] && j>= cnt[k][1]) ? f[k-1][i-cnt[k][0]][j-cnt[k][1]] + 1 : 0;
                    f[k][i][j] = Math.max(no, with);
                }
            }
        }
        return f[length-1][m][n];
    }
}

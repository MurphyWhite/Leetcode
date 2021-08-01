package src.rocks.ditto.leetcode.easy;

import java.util.PriorityQueue;

/**
 * 1337. 矩阵中战斗力最弱的 K 行
 * https://leetcode-cn.com/problems/the-k-weakest-rows-in-a-matrix/
 */
public class KWeakestRows {

    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        // 军人数量多(a[0])的排前面, 行号大(a[1])的排前面 战力大根堆
        PriorityQueue<int[]> queue = new PriorityQueue<>( (a,b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            } else {
                return b[0] - a[0];
            }
        });
        // 返回queue[0]
        for (int i = 0; i < m; i++){
            int left = 0, right = n - 1;
            while (left < right) {
                int mid = (left + right + 1) >> 1;
                if (check(mat[i][mid])){
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            // 如果当前是1的话，数量需要加一，不等于1，证明该列没有军人，即为0
            int cur = mat[i][left] == 1 ? left + 1 : left;
            // 队列已经满了，判断军人数量是否比较大，如果等于的话，先进入队列的战斗力肯定较弱，不用poll
            // 战斗力强的出队
            if ((queue.size() == k) && (queue.peek()[0] > cur)) {
                queue.poll();
            }
            if (queue.size() < k){
                queue.add(new int[] {cur, i});
            }
        }
        int[] ans = new int[k];
        for (int idx = k - 1; idx >= 0; idx--){
            ans[idx] = queue.poll()[1];
        }
        return ans;
    }

    // 二分判断是否还在军人组中（尽量向右找到最后一个军人）
    private boolean check(int pos) {
        if (pos == 1){
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        KWeakestRows k = new KWeakestRows();
        k.kWeakestRows(new int[][]{{1,0},{0,0},{1,0}}, 2);
    }
}

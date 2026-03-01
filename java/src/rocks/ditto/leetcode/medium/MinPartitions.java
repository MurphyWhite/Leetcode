package src.rocks.ditto.leetcode.medium;

/**
 * 1689. 十-二进制数的最少数目
 * https://leetcode.cn/problems/partitioning-into-minimum-number-of-deci-binary-numbers/description/?envType=daily-question&envId=2026-03-01
 *
 */
public class MinPartitions {

    public int minPartitions(String n) {
        int res = 0;
        //贪心， 先把每一位尽量多的放1，那最大的放位就限制了操作的最小数
        for (char c : n.toCharArray()){
            res = Math.max(res, c - '0');
        }
        return res;
    }
}

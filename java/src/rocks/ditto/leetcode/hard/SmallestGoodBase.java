package src.rocks.ditto.leetcode.hard;

/**
 * 483. 最小好进制
 * https://leetcode-cn.com/problems/smallest-good-base/
 */
public class SmallestGoodBase {

    public String smallestGoodBase(String n) {
        // n < 1e+18 10的18次方
        // 所以位数不会超过60
        Long num = Long.parseLong(n);
        // 最大位数是2进制，最小位数是n-1进制
        // 如何计算2进制的时候的位数
        int max = (int)(Math.log(num) / Math.log(2) + 1);
        for (int i = max; i >= 3; i-- ){
            long temp = 0;
            long k = (long) Math.pow(num, 1.0/ (i - 1));
            for (int j = 0 ; j < i; j++ ){
                temp = temp * k + 1;
            }
            if (temp == num){
                return String.valueOf(k);
            }
        }
        // 找不到答案的时候，只有两位, n - 1进制
        return String.valueOf(num - 1);
    }
}

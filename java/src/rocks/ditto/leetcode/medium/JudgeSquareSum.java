package src.rocks.ditto.leetcode.medium;

/**
 * 平方数之和
 * https://leetcode-cn.com/problems/sum-of-square-numbers/
 */
public class JudgeSquareSum {

    public boolean judgeSquareSum(int c) {
        for (long i = 0; i*i <= c; i++){
            double j = Math.sqrt(c - i * i);
            // 如果是整数，返回结果
            if (j == (int) j ){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        JudgeSquareSum judgeSquareSum = new JudgeSquareSum();
        System.out.println(judgeSquareSum.judgeSquareSum(0));
    }
}

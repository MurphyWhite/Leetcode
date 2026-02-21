package src.rocks.ditto.leetcode.easy;

/**
 868. 二进制间距
 https://leetcode.cn/problems/binary-gap/description/?envType=daily-question&envId=2026-02-22
 */
public class BinaryGap {
    // 模拟
    public int binaryGap(int n) {
        int last = -1;
        int ans = 0;
        int i = 0;
        while( n > 0){
            if((n & 1) != 0){
                if (last!= -1){
                    ans = Math.max(ans, i - last);
                }
                last = i;
            }
            n>>=1;
            i++;
        }
        return ans;
    }

}

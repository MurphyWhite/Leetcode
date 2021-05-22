package src.rocks.ditto.leetcode.hard;


/**
 * 黑板异或游戏
 * 两个比较重要的题解
 * https://leetcode-cn.com/problems/chalkboard-xor-game/solution/hei-ban-yi-huo-you-xi-by-leetcode-soluti-eb0c/
 * https://leetcode-cn.com/problems/chalkboard-xor-game/solution/gong-shui-san-xie-noxiang-xin-ke-xue-xi-ges7k/
 */
public class XorGame {

    // 数学题，先判断奇偶个数，再讨论先手必胜态，还是后手必胜态
    public boolean xorGame(int[] nums) {
        // Alice 先手的时候，如果是偶数，一定赢
        // 如果不是偶数，只有异或和为0时，才能赢
        if (nums.length % 2 == 0){
            return true;
        }
        int xor = 0;
        for (int num: nums){
            xor ^= num;
        }
        return xor == 0;
    }
}

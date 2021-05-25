package src.rocks.ditto.leetcode.hard;


/**
 * 黑板异或游戏
 * 两个比较重要的题解
 * https://leetcode-cn.com/problems/chalkboard-xor-game/solution/hei-ban-yi-huo-you-xi-by-leetcode-soluti-eb0c/
 * https://leetcode-cn.com/problems/chalkboard-xor-game/solution/gong-shui-san-xie-noxiang-xin-ke-xue-xi-ges7k/
 */
public class XorGame {

    // 数学题，先判断奇偶个数，再讨论先手必胜态，还是后手必胜态

    /**
     * 原问题可以转化为：只要此轮擦除结束后数组异或结果不为0即此轮不输，反之则输
     * 策略：如果先手xor == 0，先手直接取胜，如果数组为大小为偶数，先手取胜，反之后手取胜
     * 分析：
     * ① xor == 0: 先手直接取胜
     * <p>
     * ② xor != 0 时，若nums数组为偶数数组
     * xor = nums[0]^nums[1]^...^nums[n - 1] (n为偶数，即偶数个异或)
     * 若去掉元素nums[i]后的异或值记为 Si = xor ^ nums[i], i = 0, 1,.., n - 1
     * 反证法：假设对于所有的 Si==0，则必有S0^S1^...^Sn-1 = 0 (n个0异或为0)
     * 但是S0^S1^...Sn-1 = (xor ^ nums[0]) ^ (xor ^ nums[1]) ^...^(xor ^ nums[n - 1])
     * = (xor ^ xor ^...^ xor) [n个xor] ^ (nums[0] ^ nums[1]^ ... ^nums[n - 1])
     * = xor ^ xor ^...^ xor [n+1(奇数)个xor]
     * = xor != 0 与原假设矛盾
     * 可得：存在Si != 0 此时先手选择擦除nums[i]即可保证此轮不输，后续先手数组仍为偶数数组，必胜
     * <p>
     * ③ xor != 0 时，若nums数组为奇数数组
     * 同理可得 S0^S1^...Sn-1 = xor ^ xor ^...^ xor [注：n+1(偶数)个xor] = 0
     * 原假设成立，则对于所有 Si，有Si == 0，此时先手擦除任何nums[i]均会输，必输
     **/
    public boolean xorGame(int[] nums) {
        // Alice 先手的时候，如果是偶数，一定赢
        // 如果不是偶数，只有异或和为0时，才能赢
        if (nums.length % 2 == 0) {
            return true;
        }
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor == 0;
    }
}

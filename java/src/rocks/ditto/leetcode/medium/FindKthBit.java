package src.rocks.ditto.leetcode.medium;

/**
 * 1545. 找出第 N 个二进制字符串中的第 K 位
 * https://leetcode.cn/problems/find-kth-bit-in-nth-binary-string/description/?envType=daily-question&envId=2026-03-03
 */
public class FindKthBit {

    /**
     * 找出第 N 个二进制字符串中的第 K 位
     *
     * 字符串构造规则：
     * - S1 = "0"
     * - Sn = Sn-1 + "1" + invert(Sn-1)
     *   其中 invert 是将所有位取反（0变1，1变0）
     *
     * 例如：
     * - S1 = "0"
     * - S2 = "0" + "1" + "1" = "011"
     * - S3 = "011" + "1" + "100" = "0111100"
     *
     * @param n 第 n 个字符串
     * @param k 第 k 位（从 1 开始计数）
     * @return 第 n 个字符串中第 k 位的字符
     */
    public char findKthBit(int n, int k) {
        // 递归终止条件：S1 = "0"，第1位是 '0'
        if (n == 1) {
            return '0';
        }

        // 计算 Sn 的中间位置 = 2^(n-1)
        // Sn 的结构：Sn-1 | 1 | invert(Sn-1)
        //           ^^^^^  ^^^  ^^^^^^^^^^^^
        //           长度=2^(n-1)  1  长度=2^(n-1)
        int mid = 1 << (n - 1);

        // 中间位置是 '1'
        if (k == mid) {
            return '1';
        }

        // 如果 k 在左半部分 Sn-1 中，递归到 Sn-1 中查找
        if (k < mid) {
            return findKthBit(n - 1, k);
        }

        // 如果 k 在右半部分 invert(Sn-1) 中
        // 需要映射到 Sn-1 中的对应位置：k' = 2^n - k
        // 然后对结果取反（因为在 invert 部分）
        char res = findKthBit(n - 1, (1 << n) - k);
        return (char) (res ^ 1);
    }

    static void main() {
        FindKthBit findKthBit = new FindKthBit();

        // 生成 1 到 20 的测试用例
        for (int n = 1; n <= 20; n++) {
            // Sn 的长度是 2^n - 1，打印前几个和最后几个位置
            int len = (1 << n) - 1;
            System.out.print("n=" + n + " (len=" + len + "): ");

            // 打印前 10 个字符（如果长度不够则打印全部）
            int printCount = Math.min(10, len);
            for (int k = 1; k <= printCount; k++) {
                System.out.print(findKthBit.findKthBit(n, k));
            }
            if (len > 10) {
                System.out.print("...");
            }
            System.out.println();
        }
    }
}
package src.rocks.ditto.leetcode.medium;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 313. 超级丑数
 * https://leetcode-cn.com/problems/super-ugly-number/
 */
public class NthSuperUglyNumber {

    public int nthSuperUglyNumber(int n, int[] primes) {
        Set<Long> set = new HashSet<>();
        PriorityQueue<Long> queue = new PriorityQueue<>();
        // 最小丑数
        queue.add(1L);
        set.add(1L);
        // 当第n个数出队列的时候，就是所要的数
        while (n-- > 0 && !queue.isEmpty()) {
            long x = queue.poll();
            if (n == 0) {
                return (int) x;
            }
            // 如果primes跨度很大很多的话，可能会生成很多没用的数据
            // 很大的质数
            for (int k : primes) {
                if (!set.contains(x * k)) {
                    queue.add(x * k);
                    set.add(x * k);
                }
            }
        }
        return -1;
    }


}

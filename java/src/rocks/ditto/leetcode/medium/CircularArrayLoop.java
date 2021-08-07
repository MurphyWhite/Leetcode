package src.rocks.ditto.leetcode.medium;

/**
 * 457. 环形数组是否存在循环
 * https://leetcode-cn.com/problems/circular-array-loop/
 */
public class CircularArrayLoop {

    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        // 快慢指针, 遍历所有节点当出发点
        for (int i = 0; i < n; i++){
            int slow = i, fast = next(nums, i);
            // 还没有追上的时候
            // 如果nums[slow] 和 nums[fast]反向
            while (nums[slow] * nums[fast] > 0 && nums[slow] * nums[next(nums, fast)] > 0){
                // 已经追上了
                if (slow == fast) {
                    // 环不能小于等于1
                    if (slow != next(nums, slow)) {
                        return true;
                    } else {
                        break;
                    }
                }
                // slow走一步
                slow = next(nums, slow);
                // fast走两步
                fast = next(nums, next(nums, fast));
            }
            int point = i;
            // 证明上面走不通一个环
            // 所有将经过的点，变为0
            while (nums[point] * nums[next(nums, point)] > 0) {
                int tmp = next(nums, point);
                nums[point] = 0;
                point = tmp;
            }
        }
        return false;
    }

    /**
     * 返回下一个位置的下标
     * @param nums 数组
     * @param cur 当前下标
     * @return
     */
    private int next(int[] nums, int cur){
        int n = nums.length;
        // 有负数的情况，所以要加n
        return ((cur + nums[cur]) %n + n) % n;
    }

    public static void main(String[] args) {
        CircularArrayLoop c = new CircularArrayLoop();
        c.circularArrayLoop(new int[] {2,-1,1,2,2});
    }
}

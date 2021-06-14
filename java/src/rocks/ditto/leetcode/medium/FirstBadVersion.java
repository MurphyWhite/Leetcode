package src.rocks.ditto.leetcode.medium;

/**
 * 278. 第一个错误的版本
 * https://leetcode-cn.com/problems/first-bad-version/
 */
public class FirstBadVersion {

    public int firstBadVersion(int n) {
        int left=0, right = n;
        // 二分法
        while (left < right){
            // 防止计算溢出
            int mid = left + (right - left) / 2;
            // 能够满足的话
            if (isBadVersion(mid)){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    int badVersion;

    private boolean isBadVersion(int version){
        return badVersion <= version;
    }
}

package src.rocks.ditto.leetcode.hard;

import java.util.Arrays;

/**
 * 1723. 完成所有工作的最短时间
 * https://leetcode-cn.com/problems/find-minimum-time-to-finish-all-jobs/
 */
public class MinimumTimeRequired {

    public int minimumTimeRequired(int[] jobs, int k) {
        Arrays.sort(jobs);
        int low = 0, high = jobs.length - 1;
        // 需要从大到小的jobs列表
        while( low < high){
            int temp = jobs[low];
            jobs[low] = jobs[high];
            jobs[high] = temp;
            low++;
            high--;
        }
        int l = jobs[0], r = Arrays.stream(jobs).sum();

        // 二分法
        while (l < r){
            int mid = (l + r) / 2;
            // 能够满足的话
            if (check(jobs, k, mid)){
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    // 检查是否可以分配
    private boolean check(int[] jobs, int k, int limit){
        int[] workloads = new int[k];
        return backtrack(jobs, workloads, 0, limit);
    }

    // 递归判断
    // i 当前分配的工作
    private boolean backtrack(int[] jobs, int[] workloads, int i, int limit){
        //所有工作都分配完了
        if (i >= jobs.length){
            return true;
        }
        // 分配当前的工作
        int cur = jobs[i];
        for (int j=0; j < workloads.length; j++){
            // 尝试分配给第j个工人
            if (workloads[j] + cur <= limit){
                workloads[j] += cur;
                // 继续递归，如果都能通过
                if (backtrack(jobs, workloads, i+1, limit)){
                    return true;
                }
                // 否则减回去，分配给下一个工人
                workloads[j] -= cur;
            }

            // 剪枝
            // 如果第j个工人未被分配工作,但是仍然不能，现有的操作是不能完成的，提前结束
            // 如果恰好等于分配上限，但是仍不能完成的话，也是不可能实现分配的
            if (workloads[j] == 0 || cur + workloads[j] == limit){
                break;
            }
        }
        return false;
    }
}

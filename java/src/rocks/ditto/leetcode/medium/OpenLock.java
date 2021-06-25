package src.rocks.ditto.leetcode.medium;

import java.util.*;

/**
 * 752. 打开转盘锁
 * https://leetcode-cn.com/problems/open-the-lock/
 */
public class OpenLock {

    public int openLock(String[] deadends, String target) {
        if ("0000".equals(target)) {
            return 0;
        }
        Set<String> dead = new HashSet<>();
        for (String deadend : deadends){
            dead.add(deadend);
        }
        if (dead.contains("0000")){
            // 起始状态
            return -1;
        }
        // 待检查队列 add和offer是一样的
        PriorityQueue<LockStatus> checkQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.f));
        checkQueue.offer(new LockStatus("0000", target, 0));
        // 已经检查过的set
        Set<String> checked = new HashSet<>();
        checked.add("0000");
        while (!checkQueue.isEmpty()){
            LockStatus curStatus = checkQueue.poll();
            for (String nextStatus : turn(curStatus)){
                // 判断这个状态能不能加入队列
                if (!dead.contains(nextStatus) && !checked.contains(nextStatus)){
                    // 到达终点
                    if (nextStatus.equals(target)){
                        return curStatus.g + 1;
                    }
                    checkQueue.offer(new LockStatus(nextStatus, target, curStatus.g + 1));
                    checked.add(nextStatus);
                }
            }
        }
        return -1;
    }

    // 尝试转动锁
    private List<String> turn(LockStatus cur){
        List<String> nextStatuses = new ArrayList<>();
        char[] numArray = cur.curStatus.toCharArray();
        for (int i=0; i < 4; i++){
            char num = numArray[i];
            numArray[i] = turnPre(num);
            nextStatuses.add(new String(numArray));
            numArray[i] = turnNext(num);
            nextStatuses.add(new String(numArray));
            numArray[i] = num;
        }
        return nextStatuses;
    }

    // 向上转动
    char turnPre(char x){
        if (x == '0'){
            return '9';
        } else {
            return (char) (x - 1);
        }
    }

    // 向下转动
    char turnNext(char x){
        if (x == '9'){
            return '0';
        } else {
            return (char) (x + 1);
        }
    }

    // A* 算法
    private class LockStatus{
        String curStatus;
        // 现在的代价（到起点的代价）
        int g;
        // 启发函数(到终点可能代价)
        int h;
        // 综合代价
        int f;

        LockStatus(String cur, String target, int g){
            this.curStatus = cur;
            this.g = g;
            this.h = getH(cur, target);
            this.f = this.g + this.h;
        }

        // 计算启发函数（到目标终点的可能代价）
        private int getH(String cur, String target){
            int h = 0;
            for (int i =0; i < 4; i++){
                int dist = Math.abs(target.charAt(i) - cur.charAt(i));
                // 正向扭还是反向扭
                h += Math.min(dist, 10 - dist);
            }
            return h;
        }
    }

    public static void main(String[] args) {
        OpenLock openLock = new OpenLock();
        String[] deadends = new String[] {"0201","0101","0102","1212","2002"};
        openLock.openLock(deadends, "0202");
    }

}

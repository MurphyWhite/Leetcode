package src.rocks.ditto.leetcode.hard;

import java.util.*;

/**
 * 773. 滑动谜题
 * https://leetcode-cn.com/problems/sliding-puzzle/submissions/
 */
public class SlidingPuzzle {

    public int slidingPuzzle(int[][] board) {
        String s = "";
        String target = "123450";
        // 把数组转为一维数组
        for (int i = 0; i < 2; i++){
            for (int j = 0; j< 3; j++){
                s += board[i][j];
            }
        }
        if (s.equals(target)){
            return 0;
        }
        // 待检查队列 add和offer是一样的
        PriorityQueue<NumberStatus> checkQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.f));
        checkQueue.offer(new NumberStatus(s, target, 0));
        // 已经检查过的set
        Set<String> checked = new HashSet<>();
        checked.add("0000");

        // A* 算法模版
        while (!checkQueue.isEmpty()){
            NumberStatus curStatus = checkQueue.poll();
            for (String nextStatus : next(curStatus)){
                // 判断这个状态能不能加入队列
                if (!checked.contains(nextStatus)){
                    // 到达终点
                    if (nextStatus.equals(target)){
                        return curStatus.g + 1;
                    }
                    checkQueue.offer(new NumberStatus(nextStatus, target, curStatus.g + 1));
                    checked.add(nextStatus);
                }
            }
        }
        return -1;
    }

    // 提前计算好的可移动的位置 0 - {1,3}
    int[][] neighbors = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};

    // 尝试转动锁
    private List<String> next(NumberStatus cur){
        int x = cur.curStatus.indexOf('0');
        List<String> nexts = new ArrayList<>();
        char[] nextStatus = cur.curStatus.toCharArray();
        for (int neighbor : neighbors[x]){
            swap(nextStatus, x, neighbor);
            nexts.add(new String(nextStatus));
            swap(nextStatus, x, neighbor);
        }
        return nexts;
    }

    private void swap(char[] ch, int x, int y){
        char tmp = ch[x];
        ch[x] = ch[y];
        ch[y] = tmp;
    }

    // A* 算法
    private class NumberStatus{
        String curStatus;
        // 现在的代价（到起点的代价）
        int g;
        // 启发函数(到终点可能代价)
        int h;
        // 综合代价
        int f;

        NumberStatus(String cur, String target, int g){
            this.curStatus = cur;
            this.g = g;
            this.h = getH(cur, target);
            this.f = this.g + this.h;
        }

        // 计算启发函数（到目标终点的可能代价）
        // 使用曼哈顿距离计算, 这个用的是宫水三叶的启发公式计算
        // https://leetcode-cn.com/problems/sliding-puzzle/solution/gong-shui-san-xie-fa-hui-a-suan-fa-zui-d-3go8/
        private int getH(String cur, String target){
            int h = 0;
            char[] ch1 = cur.toCharArray(), ch2 = target.toCharArray();
            for (int i = 0; i < 2; i++){
                for (int j = 0; j < 3 ; j++){
                    int index = i * 3 + j;
                    // 不计算0
                    if ((ch1[i * 3 + j] == '0') || (ch2[i * 3 + j] == '0')){
                        continue;
                    }
                    int deltaX = Math.abs((ch1[index] - ch2[index]) / 3);
                    int deltaY = Math.abs((ch1[index] - ch2[index]) % 3);
                    h += deltaX + deltaY;
                }
            }
            return h;
        }
    }
}

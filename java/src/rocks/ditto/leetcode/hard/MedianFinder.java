package src.rocks.ditto.leetcode.hard;

import java.util.PriorityQueue;

/**
 * 295. 数据流的中位数
 * https://leetcode-cn.com/problems/find-median-from-data-stream/
 */
public class MedianFinder {
    /**
     * initialize your data structure here.
     */

    private final PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> b - a);
    private final PriorityQueue<Integer> right = new PriorityQueue<>((a, b) -> a - b);

    public MedianFinder() {

    }

    public void addNum(int num) {
        int ll = left.size(), rl = right.size();
        // 尽量保证left比right多一个，或者相等
        if (ll == rl) {
            if (left.isEmpty() || num <= left.peek()) {
                left.add(num);
            } else {
                left.add(right.poll());
                right.add(num);
            }
        } else {
            if ( num <= left.peek()) {
                right.add(left.poll());
                left.add(num);
            } else {
                right.add(num);
            }
        }
    }

    public double findMedian() {
        int ll = left.size(), rl = right.size();
        if (ll == 0 && rl == 0){
            return 0;
        }
        if (ll == rl) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return left.peek();
        }
    }
}


/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

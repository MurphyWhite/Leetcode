package src.rocks.ditto.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 找到 K 个最接近的元素
 * https://leetcode-cn.com/problems/find-k-closest-elements/
 */
public class FindClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        /**
         *
         */
        int[] tmp = new int[arr.length + 1];
        tmp[0] = x;
        for (int i = 0; i < arr.length; i++) {
            tmp[i + 1] = arr[i];
        }
        int xPoint = quickSort(tmp, 0, tmp.length - 1);
        if (k == 0) {
            return new ArrayList<>();
        }
        int[] result = new int[k];
        int num = 0;
        int left = xPoint - 1;
        int right = xPoint + 1;
        while (num < k) {
            if ((left <= -1 && right < tmp.length) || (left == xPoint)) {
                result[num] = tmp[right];
                right++;
                num++;
                continue;
            }
            if ((left > -1 && right >= tmp.length) || (right == xPoint)) {
                result[num] = tmp[left];
                left--;
                num++;
                continue;
            }
            if (Math.abs(tmp[left] - x) <= Math.abs(tmp[right] - x)) {
                result[num] = tmp[left];
                left--;
                num++;
            } else {
                result[num] = tmp[right];
                right++;
                num++;
            }
        }
        quickSort(result, 0, k - 1);
        List<Integer> res = new ArrayList<>(k);
        for (int i = 0; i < k; i++){
            res.add(result[i]);
        }
        return res;
    }

    /**
     * 并返回x的位置
     *
     * @param sort
     * @param begin
     * @param end
     * @return
     */
    private int quickSort(int sort[], int begin, int end) {
        if (begin < end) {
            int key = sort[begin];
            int i = begin;
            int j = end;
            while (i < j) {
                while (i < j && sort[j] > key) {
                    j--;
                }
                if (i < j) {
                    sort[i] = sort[j];
                    i++;
                }
                while (i < j && sort[i] < key) {
                    i++;
                }
                if (i < j) {
                    sort[j] = sort[i];
                }
            }
            sort[i] = key;
            quickSort(sort, begin, i - 1);
            quickSort(sort, i + 1, end);
            // 只有第一次用，返回中间值的位置
            return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        FindClosestElements solution = new FindClosestElements();
        List<Integer> result = solution.findClosestElements(array, 4, 3);
        System.out.print(result.toString());
    }

    private void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}

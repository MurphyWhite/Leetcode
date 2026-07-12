package src.rocks.ditto.shl;

import java.util.Scanner;

/**
 * Question: Less Than K (Duplicate of Q15)
 * ---------------------
 * This is a duplicate of Question 15 - Count Less Than K.
 * Count elements strictly less than K.
 *
 * Algorithm: Linear Scan
 * ---------------------
 * Same as Q15 - O(n) scan counting elements < K.
 */
public class LessThanK {

    public static int countLessThan(int[] arr, int K) {
        int count = 0;
        for (int num : arr) if (num < K) count++;
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] elements = new int[length];
        for (int i = 0; i < length; i++) {
            elements[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        System.out.println(countLessThan(elements, target));
        sc.close();
    }
}

package src.rocks.ditto.shl;

import java.util.Scanner;

/**
 * Question: Swap Index (Duplicate of Q05)
 * ---------------------
 * This is a duplicate of Question 5 - Index Value Replacement.
 * Replace each number with its index value.
 *
 * Algorithm: Direct Index Mapping
 * ---------------------
 * Same as Q05 - Use result[arr[i]] = i.
 */
public class SwapIndex {

    public static int[] replaceWithIndex(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[arr[i]] = i;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int[] result = replaceWithIndex(arr);
        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + (i < n - 1 ? " " : ""));
        }
        scanner.close();
    }
}

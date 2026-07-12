package src.rocks.ditto.shl;

import java.util.Scanner;

/**
 * Question: Needle in Haystack (Duplicate of Q60)
 * ---------------------
 * Count occurrences of a digit in a number.
 * Similar to Q60 - Needle In Haystack Count.
 *
 * Algorithm: Character Scan
 * ---------------------
 * Convert number to string, count occurrences of needle digit.
 */
public class NeedleInHaystack {

    public static int countOccurrences(long haystack, int needle) {
        String hay = String.valueOf(haystack);
        String needleStr = String.valueOf(needle);
        int count = 0, idx = 0;
        while ((idx = hay.indexOf(needleStr, idx)) != -1) {
            count++;
            idx++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int needle = sc.nextInt();
        long haystack = sc.nextLong();
        System.out.println(countOccurrences(haystack, needle));
        sc.close();
    }
}
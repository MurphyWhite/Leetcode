package src.rocks.ditto.shl;

/**
 * Question: Alumni Seat Arrangement
 * ---------------------
 * A University has invited N alumni for a dinner. The dinner table has a circular shape.
 * Each alumnus is assigned an invitation ID from 0 to N-1. Each alumnus likes exactly one fellow alumnus
 * and will attend the dinner only if he/she can be seated next to the person he/she likes.
 * Write an algorithm to find the IDs of the alumni in a lexicographical order so that
 * maximum number of alumni attend the dinner.
 *
 * Algorithm: Graph Cycle Detection / Topological Sort
 * ---------------------
 * 1. Model as graph where each alumnus points to the person they like
 * 2. Find cycles in the graph (people who like each other form a cycle)
 * 3. People in cycles can all attend; others depend on cycle members
 * 4. Find maximum set of alumni who can be seated together
 *
 * Why it works: If alumnus A likes B, A can only attend if B is seated next to A.
 * This forms a directed graph. People in a cycle can all attend since each person
 * in the cycle has their liked person next to them. The problem reduces to finding
 * maximum cycle cover in a functional graph.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class AlumniSeat {
    public static int[] findSeating(int[] likes) {
        // Implementation: Find alumni who can attend
        return new int[0];
    }
}

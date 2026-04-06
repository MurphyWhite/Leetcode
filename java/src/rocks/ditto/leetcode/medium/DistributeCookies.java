package src.rocks.ditto.leetcode.medium;

/**
 * 2305. Fair Distribution of Cookies
 * https://leetcode.com/problems/fair-distribution-of-cookies/description/
 */
public class DistributeCookies {

    public int distributeCookies(int[] cookies, int k) {
        // children's cookies
        int[] distributeCookies = new int[k];
        return dfs(0, distributeCookies, cookies, k, k);
    }

    private int dfs(int i, int[] distribute, int[] cookies, int k, int zeroCount){
        // can't distribute to all children
        if ((cookies.length - i) < zeroCount){
            // return a very big results means invalid
            return Integer.MAX_VALUE;
        }

        // finish the distribution
        if (cookies.length == i){
            int unfairness = -1;
            for (int distri : distribute){
                unfairness = Math.max(unfairness, distri);
            }
            return unfairness;
        }

        int result = Integer.MAX_VALUE;
        // deep find search every child
        for (int j = 0; j < k; j++) {
            if (distribute[j] == 0){
                // distribute to a no cookies child
                zeroCount--;
            }
            distribute[j] += cookies[i];

            // min this route unfairness
            result = Math.min(result, dfs(i + 1, distribute, cookies, k, zeroCount));

            // return back
            distribute[j] -= cookies[i];
            if (distribute[j] == 0){
                // distribute to a no cookies child
                zeroCount++;
            }
        }
        return result;
    }
}

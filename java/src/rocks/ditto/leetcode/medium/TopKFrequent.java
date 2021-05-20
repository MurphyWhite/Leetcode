package src.rocks.ditto.leetcode.medium;

import java.util.*;

/**
 * 前K个高频单词
 * https://leetcode-cn.com/problems/top-k-frequent-words/
 */
public class TopKFrequent {

    public List<String> topKFrequent(String[] words, int k) {
        // 计算词频
        HashMap<String, Integer> frequent = new HashMap<>();
        for (String word : words){
            frequent.put(word, frequent.getOrDefault(word, 0) + 1);
        }
        // 优先队列获取
        PriorityQueue<Object[]> queue = new PriorityQueue<>(k , (a,b) ->{
            // 词频不同，按照升序排列
            int n1 = (Integer) a[1], n2 = (Integer) b[1];
            if (n1 != n2) {
                return n1-n2;
            }
            // 按照字母的先后顺序排
            String s1 = (String) a[0], s2 = (String) b[0];
            return s2.compareTo(s1);
        });
        for (String key : frequent.keySet()){
            int cnt = frequent.get(key);
            // 判断现在数量是否足够，不足够直接入队
            if (queue.size() < k){
                // 重新构建一个数组存储word和次数
                queue.add(new Object[] {key, cnt});
            } else {
                // 如果已经超出了
                Object[] peek = queue.peek();
                // 大于顶部替换
                if ( cnt > (Integer) peek[1]){
                    queue.poll();
                    queue.add(new Object[] {key, cnt});
                } else if (cnt == (Integer) peek[1]){
                    // 比较字母顺序
                    String s = (String) peek[0];
                    if (key.compareTo(s) < 0){
                        queue.poll();
                        queue.add(new Object[] {key, cnt});
                    }

                }
            }
        }

        List<String> result = new ArrayList<>();
        while (!queue.isEmpty()){
            result.add((String)queue.poll()[0]);
        }
        Collections.reverse(result);
        return result;
    }
}

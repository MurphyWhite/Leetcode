package src.rocks.ditto.leetcode.medium;

import java.util.*;

/**
 * 面试题 10.02. 变位词组
 * https://leetcode-cn.com/problems/group-anagrams-lcci/
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 相同变位词map， key为排序完的
        Map<String, List<String>> groupMap = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for (String str : strs) {
            // 将字母排序后当成key，确保相同字母组成的单词key相同
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> group = groupMap.getOrDefault(key, new ArrayList<>());
            group.add(str);
            groupMap.put(key, group);
        }
        // 组成答案
        result.addAll(groupMap.values());
        return result;
    }
}

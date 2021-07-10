package src.rocks.ditto.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 981. 基于时间的键值存储
 * https://leetcode-cn.com/problems/time-based-key-value-store/
 */
class TimeMap {

    /**
     * timemap的最小单元
     */
    class TimeNode {

        private String key;
        private String value;
        private Integer timestamp;

        TimeNode(String key, String value, Integer timestamp){
            this.key = key;
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    // timemap 总体存储
    private HashMap<String, TreeMap<Integer, TimeNode>> instance;

    /** Initialize your data structure here. */
    public TimeMap() {
        instance = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, TimeNode> treeMap = instance.getOrDefault(key, new TreeMap<>());
        treeMap.put(timestamp, new TimeNode(key, value, timestamp));
        instance.put(key, treeMap);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, TimeNode> treeMap = instance.get(key);
        if (treeMap != null) {
            Map.Entry<Integer, TimeNode> entry = treeMap.floorEntry(timestamp);
            if (entry != null) {
                return entry.getValue().value;
            }
        }
        return "";
    }
}

package src.rocks.ditto.leetcode.medium;

import java.util.*;

/**
 * 1418. 点菜展示表
 * https://leetcode-cn.com/problems/display-table-of-food-orders-in-a-restaurant/
 */
public class DisplayTable {

    public List<List<String>> displayTable(List<List<String>> orders) {

        Set<String> foodSet = new TreeSet<>();

        Map<Integer, Map<String,Integer>> tables = new TreeMap<>();

        // 处理订单
        for (List<String> order : orders) {
            Integer tableNum = Integer.parseInt(order.get(1));
            String foodName = order.get(2);
            Map<String, Integer> table = tables.getOrDefault(tableNum, new HashMap<>());
            // 如果没有，就创建
            table.put(foodName, table.getOrDefault(foodName, 0) + 1);
            // 食物列表
            foodSet.add(foodName);

            // 桌子
            tables.put(tableNum, table);
        }

        List<List<String>> ans = new ArrayList<>();
        // title
        List<String> titles = new ArrayList<>();
        titles.add("Table");
        // 放入食物表头
        titles.addAll(foodSet);
        ans.add(titles);

        // treeMap 的keyset 按照字典顺序返回数据
        for (Integer tableIndex : tables.keySet()){
            List<String> menu = new ArrayList<>();
            // 添加桌号
            menu.add(String.valueOf(tableIndex));
            // 添加食物数量
            Map<String, Integer> table = tables.get(tableIndex);
            for (String food : foodSet){
                menu.add(String.valueOf(table.getOrDefault(food, 0)));
            }
            ans.add(menu);
        }
        return ans;
    }
}

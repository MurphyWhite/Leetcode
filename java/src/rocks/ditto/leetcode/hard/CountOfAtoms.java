package src.rocks.ditto.leetcode.hard;

import java.util.*;

/**
 * 726. 原子的数量
 * https://leetcode-cn.com/problems/number-of-atoms/
 */
public class CountOfAtoms {

    Integer i = 0;
    Integer n;
    String s;
    Map<String, Integer> countMap = new HashMap<>();

    public String countOfAtoms(String formula) {
        this.s = formula;
        n = s.length();
        // 栈
        Deque<String> stack = new ArrayDeque<>();
        int idx = 0;
        while (i < n) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == ')') {
                stack.addLast(String.valueOf(ch));
                i++;
            } else {
                if (Character.isDigit(ch)) {
                    int num = parseNum();
                    // 这个数字对应()
                    if (!stack.isEmpty() && stack.peekLast().equals(")")) {
                        List<String> tmp = new ArrayList<>();
                        // pop掉')'
                        stack.pollLast();
                        while (!stack.isEmpty() && !stack.peekLast().equals("(")) {
                            String cur = stack.pollLast();
                            // 把括号里的元素添加上括号的num
                            countMap.put(cur, countMap.getOrDefault(cur, 1) * num);
                            tmp.add(cur);
                        }
                        // pop掉'('
                        stack.pollLast();

                        // 重新把括号里的元素加回去，用以多层括号
                        for (int tmpIndex = tmp.size() - 1; tmpIndex >= 0; tmpIndex--) {
                            stack.addLast(tmp.get(tmpIndex));
                        }
                    } else {
                        // 没有括号的赋值情况
                        String cur = stack.pollLast();
                        countMap.put(cur, countMap.getOrDefault(cur, 1) * num);
                        stack.addLast(cur);
                    }
                } else {
                    // 弄出元素
                    String key = parseAtom();
                    key = key + "_" + idx++;
                    countMap.put(key, countMap.getOrDefault(key, 0) + 1);
                    stack.addLast(key);
                }
            }
        }
        // 将不同编号，相同的元素合并在一起, treeMap可以根据key做字典排序
        TreeMap<String, Integer> newCountMap = new TreeMap<>();
        for (String key : countMap.keySet()) {
            String atom = key.split("_")[0];
            int count = countMap.get(key);
            newCountMap.put(atom, newCountMap.getOrDefault(atom, 0) + count);
        }
        StringBuilder sb = new StringBuilder();
        // 用treemap解决字典排序问题
        for (Map.Entry<String, Integer> entry : newCountMap.entrySet()) {
            String atom = entry.getKey();
            int count = entry.getValue();
            sb.append(atom);
            if (count > 1) {
                sb.append(count);
            }
        }
        return sb.toString();
    }

    // 转化成元素
    private String parseAtom() {
        // 大写开头
        StringBuilder cur = new StringBuilder(String.valueOf(s.charAt(i)));
        this.i++;
        // 看后面是否接着小写
        while (i < n && Character.isLowerCase(s.charAt(i))) {
            // 继续拼接
            cur.append(s.charAt(i++));
        }
        return cur.toString();
    }

    // 转换成数字
    private int parseNum() {
        // 如果后面没有跟数字，就返回1
        if (i.equals(n) || !Character.isDigit(s.charAt(i))) {
            return 1;
        }
        int num = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            num = num * 10 + s.charAt(i++) - '0';
        }
        return num;
    }

    public static void main(String[] args) {
        CountOfAtoms solution = new CountOfAtoms();
        solution.countOfAtoms("Mg(OH)2");
    }
}

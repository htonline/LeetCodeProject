package algorithm;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author Zuohaitao
 * @date 2023-02-18 19:43
 * @describe
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 */
public class Solution_020 {
    public static boolean isValid(String s) {

//        如果字符串是奇数，则肯定不闭合
        if (s.length() % 2 != 0) {
            return false;
        }

        Map<Character, Character> hashMap = new HashMap<Character, Character>();
        hashMap.put(')', '(');
        hashMap.put('}', '{');
        hashMap.put(']', '[');

        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (hashMap.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != hashMap.get(ch)) {
                    return false;
                }
                stack.pop();
            }
            else {
                stack.push(ch);
            }
        }
//        如果最后栈为空了，说明闭合了; 否则没闭合
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "{{}}([]";
        System.out.println(isValid(s));
    }
}

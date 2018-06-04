package ACM;

import java.util.Scanner;
import java.util.Stack;

/**
 * leetcode844
 * 844. 比较含退格的字符串
 * 给定 S 和 T 两个字符串，
 * 当它们分别被输入到空白的文本编辑器后，
 * 判断二者是否相等，并返回结果。 # 代表退格字符
 */
public class leetcode844 {

    public static String toStrings(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length();i++) {
            if(s.charAt(i) != '#') {
                stack.push(s.charAt(i));
            } else {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return  sb.toString();
    }
    public static boolean backspaceCompare(String s,String s1) {
        String s2 = toStrings(s);
        String s3 = toStrings(s1);
        System.out.println(s2);
        System.out.println(s3);
        if(s2.equals(s3)) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String s1 = in.next();
        System.out.println(backspaceCompare(s, s1));
    }
}

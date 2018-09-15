package Java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }

}
public class Main {

    public static  int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int i = 0, j = 0;
        HashSet<Character> set = new HashSet<>();
        int ans = 0;
        while (i < len && j < len) {
           if (!set.contains(s.charAt(j)))  {
              set.add(s.charAt(j++));
              ans = Math.max(ans , j - i);
           } else {
               set.remove(s.charAt(i++));
           }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    }
}

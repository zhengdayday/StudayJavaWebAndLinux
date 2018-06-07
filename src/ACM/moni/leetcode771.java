package ACM.moni;

import java.util.HashMap;
import java.util.Scanner;

public class leetcode771 {

    public static int numJewelsInStones(String J, String S) {
        int cnt = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < J.length();i++) {
            Character c = J.charAt(i);
            map.put(c.toString(), 1);
        }
        for(int i = 0; i < S.length();i++) {
            Character c = S.charAt(i);
            String s = c.toString();
            if(map.containsKey(s) ){
                cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String J = in.next();
        String S = in.next();
        System.out.println(numJewelsInStones(J,S));
    }
}

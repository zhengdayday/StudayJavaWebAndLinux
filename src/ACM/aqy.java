package ACM;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 给任意三个整数a b c
 操作一：任意取其中两个数+1
 操作二：任意取其中一个数+2
 求最少的操作步骤数使得最后三个数相等
 没告诉范围据说是爱奇艺面试题
 */
public class aqy {
    public static int cnt = 0;
    public static void dfs(int[] a){
        if(a[0] == a[1] && a[1] == a[2]) return;
        Arrays.sort(a);
        if(a[0] + 2 <= a[2]) {
            cnt++;
            a[0] += 2;
        } else {
            a[0]++;
            a[1]++;
            cnt++;
        }
        dfs(a);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] a = new int[3];
        for(int i = 0; i < 3;i++) a[i] = in.nextInt();
        dfs(a);
        System.out.println(cnt);
    }
}

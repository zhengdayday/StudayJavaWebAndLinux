package  ACM.binarySearch;

import java.util.Scanner;

public class leetcode74 {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int len = matrix.length * matrix[0].length;
        int n = matrix.length;
        int m = matrix[0].length;
     //   System.out.println(len);
        int l = 0;
        int r = len - 1;
        while(l<=r) {
            int mid = (l+r)/2;
            int n1 = mid/m;
            int m1 = mid%m;
            if(matrix[n1][m1] > target) {
                r = mid - 1;
            } else if (matrix[n1][m1] < target) {
                l = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int target = in.nextInt();
        int[][] martix = new int[n][m];
        for(int i = 0; i <n; i++) {
            for(int j = 0;j < m;j ++){
                martix[i][j] = in.nextInt();
            }
        }
        /*
        for(int i = 0; i < n*m;i++){
            System.out.println(i/m + " " + i%m);
        }*/
       System.out.println(searchMatrix(martix, target));
    }
}

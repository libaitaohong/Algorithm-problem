package Algorithms;

import java.util.*;
/**
 * Created by Tars on 2017/7/12 0012.
 * 最长公共子序列（不是连续的）
 * dp经典问题
 *            |0,                              i = 0/j = 0
 * LCS(i,j) = |max{LCS(i-1, j),LCS(i, j-1)} ,  A[i] != B[j]
 *            |LCS(i-1, j-1) + 1,              A[i] = B[j]
 *可以设假设两个字符串有两个指针，同时向后移动，若不同则跳过i或者j，并记录当前最大数；相同则当前最大长度+1
 *
 * 输出最长公共子序列的时候，当A[i] = B[j]时，记录符号，并i、j下标减一
 * 当A[i] != B[j]时，当count[n-1][m] != count[n][m-1]时，寻找较大的那个下标，当相等时，递归遍历两个方向
 */

public class LCS {
    //求最长公共子序列
    public int findLCS(String A, int n, String B, int m) {
        if(n <=0 || m <=0) return 0;
        int[][] count =new int [n+1][m+1];
        for (int i = 1; i <= n; i++){ //这里的下标是二维数组的下表
            for (int j = 1; j <= m; j++) {
                if (A.charAt(i-1) == B.charAt(j-1)) //这里的下标是字符串的下标，比数组的小1
                    count[i][j] = count[i-1][j-1]+1;
                else
                    count[i][j] = Math.max(count[i-1][j],count[i][j-1]);
            }
        }
        //调用输出子序列函数
        LinkedList<String> list = new LinkedList<>();
        String s="";
        soutLCS(count, A, n, B ,m, s, list);
        for (String ss : list){
            for (int i = ss.length()-1; i >=0; i--) //逆序输出
                System.out.print(ss.charAt(i));
            System.out.println();
        }

        return count[n][m];
    }
    //输出最长公共子序列
    public void soutLCS(int[][] count,String A, int n, String B, int m, String s, LinkedList<String> list){

        while(n > 0 && m > 0){
            if (A.charAt(n-1) == B.charAt(m-1)){
                s +=(A.charAt(n-1));
                n--;
                m--;
            }else if (count[n-1][m] != count[n][m-1]){
                if (count[n-1][m] > count[n][m-1])
                    n--;
                else
                    m--;
            }else{
                soutLCS(count, A, n-1, B, m, s, list);
                soutLCS(count, A, n, B, m-1, s, list);
                return;
            }
        }
        list.add(s);
    }

    public static void main(String[] args) {
        LCS l = new LCS();
        int res = l.findLCS("ABCBDAB",7,"BDCABA",6);
        System.out.println(res);
    }
}

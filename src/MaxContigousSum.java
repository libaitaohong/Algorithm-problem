package Algorithms;

import java.util.Scanner;

/**
 * Created by 张鹤 on 2017/7/13 0013.
 * 连续子序列最大和
 * MaxContigousSum是正经的连续子序列最大和
 *
 * main函数里的：连续子序列最大和外，增加一个要求，即还需要输出该子序列的第一个和最后一个元素
 * 输入描述:
 *  测试输入包含若干测试用例，每个测试用例占2行，第1行给出正整数K( K< 10000 )，第2行给出K个整数，中间用空格分隔。当K为0时，输入结束，该用例不被处理。
 * 输出描述:
 *  对每个测试用例，在1行里输出最大和、最大连续子序列的第一个和最后一个元素，中间用空格分隔。
 * 如果最大连续子序列不唯一，则输出序号i和j最小的那个（如输入样例的第2、3组）。若所有K个元素都是负数，则定义其最大和为0，输出整个序列的首尾元素。
 * 输入
 6
 -2 11 -4 13 -5 -2
 10
 -10 1 2 3 4 -5 -23 3 7 -21
 6
 5 -8 3 2 5 0
 1
 10
 3
 -1 -5 -2
 3
 -1 0 -2
 0

 输出
 20 11 13
 10 1 4
 10 3 5
 10 10 10
 0 -1 -2
 0 0 0
 */
public class MaxContigousSum {
    //连续子序列最大和
    public int  MaxContigousSum(int[] a){
        int sum = 0;
        int max = 0;
        for (int i = 0; i < a.length; i++){
            sum += a[i];
            if (sum < 0){
                sum = 0;
            }else {
                if (sum > max)
                    max = sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int k = in.nextInt();
            if (k ==0) break;
            int[] num = new int[k];
            for (int i = 0; i < k; i++) {
                num[i] = in.nextInt();
            }
            int count = 0;
            for (int i = 0; i < k; i++) {
                if (num[i] >= 0)
                    break;
                count++;
            }
            if (count == k){
                System.out.println(0 + " " + num[0] + " " +num[k-1]);
                break;
            }
            int max = 0;
            int sum = 0;
            int s = 0;
            int e = k-1;
            int[] temp = new int[k];


            for (int i = 0; i < k; i++ ){
                sum += num[i];
                if (sum < 0){
                    sum = 0;
                    temp[i] = -1;
                } else {
                    if (sum > max || (sum ==0 && max == 0)){
                        max = sum;
                        temp[i] = max;
                        e = i;
                    }
                }
            }
            for (int i = e; i >= 0; i-- ){
                if (temp[i] == -1){
                    s = i+1;
                    break;
                }
            }
            System.out.println(max + " " + num[s] + " " +num[e]);

        }

    }
}

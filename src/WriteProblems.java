import java.util.Arrays;
import java.util.Scanner;

/**
 * 工程: Algorithm problem 包名: PACKAGE_NAME 类名: WriteProblems
 * 作者: zhanghe
 * 时间: 2017/3/29 19:21
 * 题目: 出题目
 * 内容:一场考试包含3道开放性题目，假设他们的难度从小到大分别为a, b, c，我们希望这3道题能满足下列条件：
 * a＜= b＜= c
 * b - a＜= 10
 * c - b＜= 10
 * 所有出题人一共出了n道开放性题目。现在我们想把这n道题分布到若干场考试中（1场或多场，每道题都必须使用且只能用一次），
 * 然而由于上述条件的限制，可能有一些考试没法凑够3道题，因此出题人就需要多出一些适当难度的题目来让每场考试都达到要求。
 * 然而我们出题已经出得很累了，你能计算出我们最少还需要再出几道题吗？
 * 样例输入
 * 4
 * 20 35 23 40
 * 样例输出
 * 2
 * 版本:
 * 运行时间:
 * 思路：排序后从头至尾遍历，第一第二个数相差>10，加2.第二第三个数相差>10，加1.最后两位要特殊处理。
 * 备注:今日头条
 */
public class WriteProblems {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nums = in.nextInt();
        int[] subject = new int[nums];
        for (int i = 0; i < nums; i++){
            subject[i] = in.nextInt();
        }
        Arrays.sort(subject);
        int res = 0;
        int i;
        for (i = 0; i < nums-2; i++){
            if (subject[i+1] - subject[i] >10){
                res = res + 2;
            }else if (subject[i+2] - subject[i+1] >10){
                res++;
                i = i+1;
            }else
                i = i+2;
        }
        if (i == nums-2){
            if (subject[i+1] - subject[i] > 10)
                res = res + 4;
            else
                res = res + 1;
        }else if (i == nums-1){
            res = res + 2;
        }
        System.out.println(res);
    }
}

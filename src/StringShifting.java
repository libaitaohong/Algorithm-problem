import java.util.Scanner;

/**
 * 工程: Algorithm problem 包名: PACKAGE_NAME 类名: StringShifting
 * 作者: zhanghe
 * 时间: 2017/3/29 20:15
 * 题目:StringShifting
 * 内容:我们规定对一个字符串的shift操作如下：
 shift(“ABCD”, 0) = “ABCD”
 shift(“ABCD”, 1) = “BCDA”
 shift(“ABCD”, 2) = “CDAB”
 换言之, 我们把最左侧的N个字符剪切下来, 按序附加到了右侧。
 给定一个长度为n的字符串，我们规定最多可以进行n次向左的循环shift操作。如果shift(string, x) = string (0＜= x ＜n),
 我们称其为一次匹配(match)。求在shift过程中出现匹配的次数。
 输入 ：byebyebye  输出：3
 * 版本:
 * 运行时间:
 * 备注:今日头条
 * 思路：找字符串中重复子串有几个。从头到尾遍历。
 */
public class StringShifting {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        char[] shift = str.toCharArray();
        int s = 0; //重复子串头
        int e = 0; //子串尾
        int count = 0;
        for (int i = 1; i < shift.length; i++){
            if (shift[i] != shift[s]){ //如果当前遍历与头字母不同，将尾指到当前位置
                e = i;
                count = 0;
            }else{
                int j;
                for (j = s; j <= e; j++, i++){ //否则看是否是一个重复子串
                    if (shift[i] != shift[j]){
                        break;
                    }
                }
                if (j-1 == e){
                    count++;
                } else{
                    count = 0;
                    e = j-1;
                }
                i--;
            }
        }
        System.out.println(count+1);
    }
}

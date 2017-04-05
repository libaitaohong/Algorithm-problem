import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 工程: Algorithm problem 包名: PACKAGE_NAME 类名: Collection
 * 作者: zhanghe
 * 时间: 2017/4/5 19:04
 * 题目:集合（京东2017秋招真题）
 * 内容:给你两个集合，要求 {A} + {B}。 注：同一个集合中不会有两个相同的元素。
 * 输入：
 * 多组（不超过 5 组）数据。
 * 每组输入数据分为三行，第一行有两个数字 n,m($0＜n,m\leq10000$)，分别表示集合 A 和集合 B 的元素个数。
 * 后两行分别表示集合 A 和集合 B。每个元素为不超出 int 范围的整数，每个元素之间有一个空格隔开。
 * 输出：
 * 针对每组数据输出一行数据，表示合并后的集合，要求从小到大输出，每个元素之间有一个空格隔开。
 * 样例输入
 * 1 2
 * 1
 * 2 3
 * 1 2
 * 1
 * 1 2
 * 样例输出
 * 1 2 3
 * 1 2
 * 版本:
 * 运行时间:
 * 备注:
 */
public class Collection {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n,m;
        TreeSet<Integer> coll;
        while(in.hasNext()) {
            n = in.nextInt();
            m = in.nextInt();
            coll = new TreeSet<>();
            for (int i = 0; i < m + n; i++) {
                coll.add(in.nextInt());
            }
            Iterator iter = coll.iterator();
            for (int i = 0; i < coll.size()-1; i++) {
                System.out.print(iter.next() + " ");
            }
            System.out.println(iter.next());
        }

    }
}

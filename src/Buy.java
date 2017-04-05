import java.util.*;
/**
 * 工程: Algorithm problem 包名: PACKAGE_NAME 类名: Buy
 * 作者: zhanghe
 * 时间: 2017/4/5 19:54
 * 题目:采购单（京东2017秋招真题）
 * 内容:过年啦！小B高兴的不行了，她收到了很多红包，可以实现好多的愿望呢。小B可是对商店货架上心仪的货物红眼好久了，只因囊中羞涩作罢，
 * 这次她可是要大大的shopping一番。小B想去购物时，总是习惯性的把要买的东西列在一个购买清单上，每个物品单独列一行（即便要买多个某种物品），
 * 这次也不例外。小B早早的来到了商店，由于她太激动，以至于她到达商店的时候，服务员还没有把各个商品的价签排好，所有的价签还都在柜台上。
 * 因此还需要一段时间，等服务器把价签放到对应的商品处，小B才能弄清她的购买清单所需的费用。
 * 小B都有些迫不及待了，她希望你能够根据购买清单，帮她算算最好和最坏的情况下所需的费用，你能帮她吗？
 * 输入:
 * 输入中有多组测试数据。每组测试数据的第一行为两个整数n和m（1=＜n, m=＜1000），分别表示价签的数量以及小B的购买清单中所列的物品数。
 * 第二行为空格分隔的n个正整数，表示货架上各类物品的价格，每个数的大小不超过100000。随后的m行为购买清单中物品的名称，
 * 所有物品名称为非空的不超过32个拉丁字母构成的字符串，保证清单中不同的物品种类数不超过n，且商店有小B想要购买的所有物品。
 * 输出:
 * 对每组测试数据，在单独的行中输出两个数a和b，表示购买清单上所有的物品可能需要的最小和最大费用。
 * 样例输入
 * 5 3
 * 4 2 1 10 5
 * apple
 * orange
 * mango
 * 6 5
 * 3 5 1 6 8 1
 * peach
 * grapefruit
 * banana
 * orange
 * orange
 * 样例输出
 * 7 19
 * 11 30
 * 版本:
 * 运行时间:
 * 备注:使用了hashmap，存储每种水果以及要购买的次数，与价钱相乘即可
 */
public class Buy {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n,m;
        String obj = "";
        int[] tag;
        HashMap<String, Integer> list = new HashMap<>();
        while(in.hasNext()){
            n = in.nextInt();
            m = in.nextInt();
            tag = new int[n];
            for (int i = 0; i < n ;i++){
                tag[i] = in.nextInt();
            }
            for (int j = 0; j < m; j++){
                obj = in.next();
                if (!list.containsKey(obj)){
                    list.put(obj, 1);
                }else{
                    int num = list.get(obj);
                    list.put(obj, num+1);
                }
            }
            int[] fruit = new int[list.size()];
            int i = 0;
            Iterator iter = list.entrySet().iterator();
            while(iter.hasNext()){
                Map.Entry entry = (Map.Entry)iter.next();
                fruit[i] = (Integer)entry.getValue();
                i++;
            }
            Arrays.sort(fruit);
            Arrays.sort(tag);
            int min = 0;
            int max = 0;
            for (int k = 0; k < fruit.length; k++){
                min += fruit[fruit.length-1-k] * tag[k];
                max += fruit[fruit.length-1-k] * tag[tag.length-1-k];
            }
            System.out.println(min + " "+ max);
            list.clear();
        }
    }
}

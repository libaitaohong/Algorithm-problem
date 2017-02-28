/**
 * Created by zhanghe on 2017/2/28.
 * 腾讯2016笔试算法题
 * 春节期间小明使用微信收到很多个红包，非常开心。在查看领取红包记录时发现，
 * 某个红包金额出现的次数超过了红包总数的一半。请帮小明找到该红包金额。
 * 写出具体算法思路和代码实现，要求算法尽可能高效。
 * 给定一个红包的金额数组gifts及它的大小n，请返回所求红包的金额。若没有金额超过总数的一半，返回0。
 * 思路：设定两个值cur和num，从头遍历数组，cur=gifts[i]，num++，否则num--。直到num=0，换cur
 * 这样如果有符合条件的数，剩下的那个一定是。
 */
import java.util.*;
public class Gift {
    public int getValue(int[] gifts, int n) {
        if(n == 0)
        return 0;
        int cur = gifts[0];
        int num = 1;
        for(int i = 1; i < n; i++){
            if(cur == gifts[i])
                num++;
            else{
                num--;
                if(num == 0){
                    cur = gifts[i];
                    num = 1;
                }
            }
        }
        num = 0;
        for(int i = 0; i < n; i++){
            if(cur == gifts[i])
                num++;
        }
        if(num == n/2)
        return cur;
        else
        return 0;
    }
}

package test;

/**
 * @Author: L.N
 * @Date: 2023/6/12 20:49
 * @Description: 两数之和
 * https://leetcode.cn/problems/two-sum/
 */

import java.util.HashMap;

/**
 * 方法一：暴力破解;
 * 思路：使用双重循环。拿一个数值与其他所有的数值进行累加，在判断是否和目标值相等，相等就输出相加的两个元素，
 * 大循环的循环轮数是元素个数 -1 。所以循环次数是数组的长度-2
 * 小循环的循环是从大循环的下标值+1 到 最后一个值，都与数组的长度相关
 * 时间复杂度：双重循环   O(n的2次方)
 * 空间复杂度：常数个临时变量    O(1) ；
 *
 * 方法二：查找表法
 * 在遍历的时候，记录一些信息，以省去一层循环，是用空间换时间的想法。
 * 需要记录已经遍历的数据和所对应的下标。可以借助查找表实现
 * 查找表有2个常用的实现
 * 哈希表：
 * 平衡二叉树：
 * 因为我们无需维护哈希表中元素的顺序性，因此可以使用hash表
 * 思路 : 在for循环中查找hash表中是否有目标值与自身的差值，如果有输出两个下标。
 * 时间复杂度: for循环 O(n)
 * 空间复杂度：hashmap的空间O(n)
 */
public class Example1 {
    //方法一 ：暴力解法
    public static int[] twoSum(int[] nums, int target) {
        int [] answer = new int[2];
        for(int i = 0 ; i < nums.length - 1;i++){
            for(int j = i + 1 ;j <nums.length ;j++){
                if(nums[i] + nums[j] == target){
                    if(i != j){
                        answer[0] = i;
                        answer[1] = j;
                    } else {
                        answer[0] = i;
                    }
                    return answer;
                }
            }
        }
        return answer;
    }

    //方法二 :查找表法
    public static  int[] twoSum2(int[] nums, int target){
        HashMap<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for(int i = 0;i < nums.length;i++){

            if (hashtable.containsKey(target - nums[i])){
                return new int[] {hashtable.get(target-nums[i]),i};
            }
            hashtable.put(nums[i],i);

        }
        throw new IllegalArgumentException("No two sum Solution");
    }



    public static void main(String[] args) {
        for (int i : twoSum(new int[]{2, 7, 11, 15}, 9)) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
        for (int i : twoSum(new int[]{3, 2, 4}, 6)) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
        for (int i : twoSum2(new int[]{2, 7, 11, 15}, 9)) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
        for (int i : twoSum2(new int[]{3, 2, 4}, 6)) {
            System.out.print(i + " ");
        }

    }


}

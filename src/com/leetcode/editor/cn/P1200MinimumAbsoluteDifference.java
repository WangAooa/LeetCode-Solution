package com.leetcode.editor.cn;
//给你个整数数组 arr，其中每个元素都 不相同。 
//
// 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [4,2,1,3]
//输出：[[1,2],[2,3],[3,4]]
// 
//
// 示例 2： 
//
// 输入：arr = [1,3,6,10,15]
//输出：[[1,3]]
// 
//
// 示例 3： 
//
// 输入：arr = [3,8,-10,23,19,-4,-14,27]
//输出：[[-14,-10],[19,23],[23,27]]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= arr.length <= 10^5 
// -10^6 <= arr[i] <= 10^6 
// 
// Related Topics 数组 排序 
// 👍 104 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P1200MinimumAbsoluteDifference{
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int min_margin = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for(int i = 0; i < arr.length - 1; i++){
            min_margin = Math.min(min_margin, arr[i+1] - arr[i]);
        }
        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i+1] - arr[i] == min_margin){
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(arr[i]);
                temp.add(arr[i+1]);
                result.add(temp);
            }

        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
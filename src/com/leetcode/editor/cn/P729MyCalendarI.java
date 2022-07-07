package com.leetcode.editor.cn;
//实现一个 MyCalendar 类来存放你的日程安排。如果要添加的日程安排不会造成 重复预订 ，则可以存储这个新的日程安排。 
//
// 当两个日程安排有一些时间上的交叉时（例如两个日程安排都在同一时间内），就会产生 重复预订 。 
//
// 日程可以用一对整数 start 和 end 表示，这里的时间是半开区间，即 [start, end), 实数 x 的范围为， start <= x < e
//nd 。 
//
// 实现 MyCalendar 类： 
//
// 
// MyCalendar() 初始化日历对象。 
// boolean book(int start, int end) 如果可以将日程安排成功添加到日历中而不会导致重复预订，返回 true 。否则，返回 fa
//lse 并且不要将该日程安排添加到日历中。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["MyCalendar", "book", "book", "book"]
//[[], [10, 20], [15, 25], [20, 30]]
//输出：
//[null, true, false, true]
//
//解释：
//MyCalendar myCalendar = new MyCalendar();
//myCalendar.book(10, 20); // return True
//myCalendar.book(15, 25); // return False ，这个日程安排不能添加到日历中，因为时间 15 已经被另一个日程安排预订了
//。
//myCalendar.book(20, 30); // return True ，这个日程安排可以添加到日历中，因为第一个日程安排预订的每个时间都小于 20
// ，且不包含时间 20 。 
//
// 
//
// 提示： 
//
// 
// 0 <= start < end <= 109 
// 每个测试用例，调用 book 方法的次数最多不超过 1000 次。 
// 
// Related Topics 设计 线段树 二分查找 有序集合 
// 👍 155 👎 0

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

public class P729MyCalendarI {
    //leetcode submit region begin(Prohibit modification and deletion)
    class MyCalendar {
        TreeSet<int[]> set = null;

        public MyCalendar() {
            set = new TreeSet<int[]>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    int res = o1[0] - o2[0];

                    return res;
                }
            });
        }

        public boolean book(int start, int end) {
            if (this.set.size() == 0) {
                int[] temp = {start, end};
                set.add(temp);
                return true;
            }
            int[] larger_time = set.ceiling(new int[]{end, 0});
            int[] pre_time = set.last();
            if (larger_time != null) {
                pre_time = set.lower(larger_time);
            }
            boolean flag = false;
            if (larger_time == null) {
                if (start >= pre_time[1]) {
                    flag = true;
                }
            } else if (pre_time == null) {
                if (end <= larger_time[0]) {
                    flag = true;
                }
            } else {
                if (start >= pre_time[1] && end <= larger_time[0]) {
                    flag = true;
                }
            }
            if (flag) {
                set.add(new int[]{start, end});
            }
            return flag;

        }
    }

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
//leetcode submit region end(Prohibit modification and deletion)
}

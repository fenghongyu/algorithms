//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Java：全排列
public class P46Permutations {
    public static void main(String[] args) {
        Solution solution = new P46Permutations().new Solution();
        // TO TEST
        solution.permute(new int[]{1, 2, 3});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> result = new ArrayList<>();
        public List<List<Integer>> permute(int[] nums) {
            LinkedList<Integer> curRout = new LinkedList<>();
            doPermute(nums, curRout);
            return result;
        }

        private void doPermute(int[] nums, LinkedList<Integer> curRout) {
            if(nums.length == curRout.size()) {
                result.add(new LinkedList<>(curRout));
                return;
            }

            for(int i=0;i<nums.length;i++) {
                if(curRout.contains(nums[i])) {
                    //重复出现的，跳过
                    continue;
                }
                curRout.add(nums[i]);
                doPermute(nums, curRout);
                curRout.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
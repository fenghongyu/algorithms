//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Java：组合
public class P77Combinations {
    public static void main(String[] args) {
        Solution solution = new P77Combinations().new Solution();
        // TO TEST
        List<List<Integer>> result = solution.combine(4,2);
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            if (n == 0 || k == 0 || n < k) {
                return result;
            }
            LinkedList<Integer> track = new LinkedList<>();
            doConbine(n, k, track);
            return result;
        }

        private void doConbine(int n, int k, LinkedList<Integer> track) {
            if(track.size() == k) {
                result.add(new LinkedList<>(track));
                return;
            }

            for(int i=n;i>=1;i--) {
                if(track.contains(n)) {
                    continue;
                }
                track.add(i);
                doConbine(i-1, k, track);
                track.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
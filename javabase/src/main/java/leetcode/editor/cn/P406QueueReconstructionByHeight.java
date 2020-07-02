//假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来
//重建这个队列。 
//
// 注意： 
//总人数少于1100人。 
//
// 示例 
//
// 
//输入:
//[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
//
//输出:
//[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
// 
// Related Topics 贪心算法


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

//Java：根据身高重建队列
public class P406QueueReconstructionByHeight{
    public static void main(String[] args) {
        Solution solution = new P406QueueReconstructionByHeight().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        //1.根据身高先排序
        Arrays.sort(people, new Comparator<int[]>(){

            @Override
            public int compare(int[] o1, int[] o2) {
                //如果身高一样，则根据k 值排序
                return o1[0] == o2[0] ? o1[1]-o2[1] : o2[0]-o1[0];
            }
        });

        //2.再根据k 的索引位置进行插入
        List<int[]> list = new LinkedList<>();
        for(int[] p : people) {
            list.add(p[1], p);
        }
        int n = people.length;
        return list.toArray(new int[n][2]);
    }

//        public int[][] reconstructQueue2(int[][] people) {
//            Arrays.sort(people, new Comparator<int[]>() {
//                @Override
//                public int compare(int[] o1, int[] o2) {
//                    // if the heights are equal, compare k-values
//                    return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
//                }
//            });
//
//            List<int[]> output = new LinkedList<>();
//            for(int[] p : people){
//                output.add(p[1], p);
//            }
//
//            int n = people.length;
//            return output.toArray(new int[n][2]);
//        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
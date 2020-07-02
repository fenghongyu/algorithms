package mc_leetcode;

/**
 * @CLASSNAME:
 * @AUTHOR: fenghongyu
 * @TIME: 2020/5/25 08:54
 * 对一个有序数组进行二分法查找
 */
public class No1BinarySearch {

    public int search(int[] arr, int n, int target) {
        //查找在[i,....,j]范围内的目标数据，并返回索引位置
        int i=0,j=n-1;
        while (i<=j){
//            int mid = (i+j)/2; 这里 i+j容易产生整形 最大值溢出问题
            int mid = i+(j-i)/2;
            if(arr[mid] == target) {
                return mid;
            }
            if(arr[mid]<target) {
                j=mid-1;
            }
            if(arr[mid] > target) {
                i = mid +1;
            }
        }
        return -1;

    }

    public static void main(String[] args) {

    }
}

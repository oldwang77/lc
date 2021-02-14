import com.sun.org.apache.xpath.internal.SourceTree;

class SolutionQuickSort {

    int[] a = { 3, 1, 2, 5, 4, 6 };

    public void quickSort(int start, int end) {
        if (start > end) {
            return;
        }
        int startNum = a[start];
        int left = start;
        int right = end;

        // 当左右标记没有遇到的时候
        while (left != right) {
            while (left < right && a[right] >= startNum) {
                right--;
            }
            while (left < right && a[left] <= startNum) {
                left++;
            }
            // 当上述条件不成立时，交换左右两个元素
            int tmp = a[left];
            a[left] = a[right];
            a[right] = tmp;
        }

        // 左右相遇位置和哨兵进行交换
        a[start] = a[left];
        a[left] = startNum;

        quickSort(left + 1, end);
        quickSort(start, right - 1);
    }

    public static void main(String[] args) {
        SolutionQuickSort s = new SolutionQuickSort();
        s.quickSort(0, 5);
        for (int x : s.a) {
            System.out.println(x);
        }
    }
}
class SolutionTest {
    public void bubbleSort(int[] arr, int cnt) {
        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j < cnt - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int ans = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = ans;
                }
            }
        }

        for (int i = 0; i < cnt; i++) {
            System.out.print(arr[i]);
        }
    }

    /**
     * 快速排序
     * 
     * @param arr
     * @param start
     * @param end
     */
    // public void quickSort(int[] a, int start, int end) {
    // if (start > end) {
    // return;
    // }
    // // 定义边界左，右和哨兵结点
    // int left = start, right = end, startNum = a[start];
    // while (left < right) {
    // while (left < right && a[right] >= startNum) {
    // right--;
    // }
    // while (left < right && a[left] <= startNum) {
    // left++;
    // }
    // // 交换左右的俩个结点
    // int tmp = a[left];
    // a[left] = a[right];
    // a[right] = tmp;
    // }
    // // 将相遇的结点和哨兵结点交换
    // a[start] = a[left];
    // a[left] = startNum;

    // quickSort(a, left + 1, end);
    // quickSort(a, start, right - 1);
    // }

    public void quickSort(int[] a, int start, int end) {
        if (start > end) {
            return;
        }
        int left = start, right = end, startNum = a[start];
        while (left < right) {
            while (left < right && a[right] >= startNum) {
                right--;
            }
            while (left < right && a[left] <= startNum) {
                left++;
            }
            int tmp = a[left];
            a[left] = a[right];
            a[right] = tmp;
        }
        a[start] = a[left];
        a[left] = startNum;

        quickSort(a, left + 1, end);
        quickSort(a, start, right - 1);
    }

    public static void main(String[] args) {
        int[] arr = { 3, 2, 1 };
        SolutionTest s = new SolutionTest();
        // s.bubbleSort(arr, 4);
        s.quickSort(arr, 0, 2);
        for (int i = 0; i < 3; i++) {
            System.out.print(arr[i]);
        }
    }

}
class Solution {
    public static void bubbleSort(int[] arr, int cnt) {
        for (int i = 0; i < cnt; i++) {
            for (int j = i; j < cnt - 1; j++) {
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

    public static void main(String[] args) {
        int[] arr = { 3, 4, 2, 1 };
        bubbleSort(arr, 4);
    }

}
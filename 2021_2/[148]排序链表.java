import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
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

    public ListNode sortList(ListNode head) {
        int[] arr = new int[50010];
        ListNode tmp = new ListNode(0);
        tmp = head;

        int cnt = 0;
        while (tmp != null) {
            arr[cnt++] = tmp.val;
            tmp = tmp.next;
        }

        // quickSort时间复杂度O(nlogn)
        quickSort(arr, 0, cnt - 1);

        // 按照顺序，依次赋值
        ListNode tmp2 = head;
        for (int i = 0; i < cnt; i++) {
            tmp2.val = arr[i];
            tmp2 = tmp2.next;
        }
        return head;
    }

    // public static void main(String[] args) {
    // ListNode ans1 = new ListNode(3);
    // ListNode ans2 = new ListNode(2);
    // ListNode ans3 = new ListNode(1);
    // ans1.next = ans2;
    // ans2.next = ans3;
    // Solution22 s = new Solution22();
    // ListNode ans = s.sortList(ans1);
    // while (ans != null) {
    // System.out.println(ans.val);
    // ans = ans.next;
    // }
    // }
}
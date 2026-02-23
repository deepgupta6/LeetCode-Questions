class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int n = 0;

        while (head != null) {
            n++;
            head = head.next;
        }
        ListNode prev = dummy;
        head = dummy.next;
        n /= k;

        while (n-- > 0) {
            ListNode next = head.next;
            for (int i = 1; i < k; i++) {
                next = head.next;
                head.next = next.next;
                next.next = prev.next;
                prev.next = next;
            }
            prev = head;
            head = head.next;
        }
        return dummy.next;
    }
}
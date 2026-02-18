class Solution {

    public void helper(ListNode l1, ListNode l2, int carry, ListNode res) {

        if(l1 == null && l2 == null) {
            if(carry > 0) {
                res.next = new ListNode(carry);
            }
            return;
        }

        int val1 = (l1 != null) ? l1.val : 0;
        int val2 = (l2 != null) ? l2.val : 0;

        int sum = val1 + val2 + carry;

        res.next = new ListNode(sum % 10);

        helper(
            (l1 != null) ? l1.next : null,
            (l2 != null) ? l2.next : null,
            sum / 10,
            res.next
        );
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        helper(l1, l2, 0, dummy);
        return dummy.next;
    }
}

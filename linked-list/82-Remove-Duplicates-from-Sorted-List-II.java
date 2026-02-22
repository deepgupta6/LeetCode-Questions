// my code
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode dummy = new ListNode(101);
        dummy.next = head;
        ListNode ptr = head;
        ListNode prev = dummy;

        while (ptr != null) {
            boolean x = false;
            while (ptr.next != null && ptr.val == ptr.next.val) {
                x= true;
                ptr = ptr.next;
            }
            if (x) {
                prev.next = ptr.next;
                ptr = ptr.next;
            } else {
                prev = ptr;
                ptr = ptr.next;
            }

        }

        return dummy.next;

    }
}

// more cleaner version

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;

        ListNode dummy = new ListNode(101);
        dummy.next = head;
        ListNode ptr = head;
        ListNode prev = dummy;

        while (ptr != null) {
            if (ptr.next != null && ptr.val == ptr.next.val) {
                int duplicate = ptr.val;
                while (ptr != null && ptr.val == duplicate) {
                    ptr = ptr.next;
                }
                prev.next = ptr;
            } else {
                prev = ptr;
                ptr = ptr.next;
            }
        }

        return dummy.next;

    }
}
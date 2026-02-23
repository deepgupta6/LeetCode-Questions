//traversal and modification in same list approach

class Solution {
    public ListNode partition(ListNode head, int x) {
        
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode tail = head;
        ListNode curr = head;
        ListNode prev = dummy;
        int n = 1;

        while (tail.next != null) {
            tail = tail.next;
            n++;
        }

        while (n-- > 0) {
            
            if (curr.val >= x && curr.next!=null) {
                ListNode nextNode = curr.next;
                prev.next = nextNode;
                tail.next = curr;
                tail = curr;
                tail.next = null;
                curr = nextNode;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}

//using two list approach

class Solution {
    public ListNode partition(ListNode head, int x) {
        
        ListNode beforeHead = new ListNode(0);
        ListNode afterHead = new ListNode(0);
        
        ListNode before = beforeHead;
        ListNode after = afterHead;
        
        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        
        after.next = null;     
        before.next = afterHead.next;
        
        return beforeHead.next;
    }
}
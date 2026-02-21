class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        
        if (head == null || head.next == null || k == 0)
            return head;
        
        ListNode temp = head;
        int n = 0;
      
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        
        k = k % n;
        if (k == 0) return head;
        
        int stepsToNewHead = n - k;
        
        ListNode ptr = head;
        
        for (int i = 1; i < stepsToNewHead; i++) {
            ptr = ptr.next;
        }
        
        ListNode newHead = ptr.next;
        ptr.next = null;
        
        ListNode tail = newHead;
        while (tail.next != null) {
            tail = tail.next;
        }
        
        tail.next = head;
        
        return newHead;
    }
}
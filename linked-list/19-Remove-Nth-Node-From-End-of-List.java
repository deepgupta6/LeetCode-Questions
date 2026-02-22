
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int i =0;
        ListNode ptr = head;

        while(ptr!=null){
            i++;
            ptr=ptr.next;
        }
        if(n==i) return head.next;

        i-=n;
        ptr = head;

        while(i-->1){
            ptr=ptr.next;
        }
        ptr.next = ptr.next.next;

        return head;
        
    }
}
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;

        ListNode res = list1;
        if(list1.val > list2.val){
            res = list2;
            list2 = list2.next;
        } else {
            list1 = list1.next;
        }

        ListNode curr = res;

        while(list1!=null && list2!=null){
            if(list1.val > list2.val){
               curr.next = list2;
               list2 = list2.next;
            } else {
                curr.next = list1;
                list1 = list1.next;
            }
            curr = curr.next;
        }

          if(list1==null)
            curr.next = list2;
          else
            curr.next = list1;
            
        return res;
        
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ret = null;
        ListNode cur = null;
        
        while(l1 != null || l2 != null){
            if(l2==null || (l1!=null && l1.val<l2.val)){
                //pick from l1
                if(ret==null){
                    ret = l1;
                    cur = l1;
                    l1 = l1.next;
                }else{
                    //cur: 1, l1 = 2 -> 3
                    //1->2
                    //cur:2
                    //li:3
                    cur.next = l1;
                    cur = l1;
                    l1 = l1.next;
                }
            }else{
                //pick from l2
                if(ret==null){
                    ret = l2;
                    cur = l2;
                    l2 = l2.next;
                }else{
                    //cur: 1, l1 = 2 -> 3
                    //1->2
                    //cur:2
                    //li:3
                    cur.next = l2;
                    cur = l2;
                    l2 = l2.next;
                }
            }
        }
        
        return ret;
    }
}
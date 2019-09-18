/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    //워커 러너 테크닉
    //walker : 한번에 한칸씩
    //runner : 한번에 두칸씩
    //runser가 끝나면 walker는 중간에 와있음
    //구현을 위한 브레인 스토밍
    //walker: 1 2x
    //runner: 1 2x nullx
    //
    //walker: 1 2x 3
    //runser: 1 2 3 nullx
    //while loop마다
    //러너 1칸 전진 워커 1칸 전진 러너 1칸 전진
    public ListNode middleNode(ListNode head) {
        ListNode walker = head;
        ListNode runner = head;
        while(runner!=null){
            runner = runner.next;
            if(runner!=null){
                walker = walker.next;
                runner = runner.next;
            }
        }
        return walker;
    }
}

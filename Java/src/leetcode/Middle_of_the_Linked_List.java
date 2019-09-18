/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    //��Ŀ ���� ��ũ��
    //walker : �ѹ��� ��ĭ��
    //runner : �ѹ��� ��ĭ��
    //runser�� ������ walker�� �߰��� ������
    //������ ���� �극�� �����
    //walker: 1 2x
    //runner: 1 2x nullx
    //
    //walker: 1 2x 3
    //runser: 1 2 3 nullx
    //while loop����
    //���� 1ĭ ���� ��Ŀ 1ĭ ���� ���� 1ĭ ����
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

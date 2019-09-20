class Solution {
    public int hammingDistance(int x, int y) {
        /*
        a = 3 -> 11
        b = 2 -> 10
        
        a & b = 10 ; �κ�Ʈ�� ��� 1�̸� 1, �ƴϸ� 0
        a | b = 11 ; �κ�Ʈ�� �ϳ��� 1�̸� 1, �ƴϸ� 0
        a ^ b = 01 ; �κ�Ʈ�� �ٸ��� 1, �ƴϸ� 0
        
        a >> i; a�� ��� ��Ʈ�� ���������� i��ŭ �а�, �ǿ����� 0���� ä��
        a << i; a�� ��� ��Ʈ�� �������� i��ŭ �а�, �ǿ������� 0���� ä��
        */
        int xor = x^y;
        int cnt = 0;
        for(int i=0;i<32;i++){
            cnt += (xor >> i) & 1;
        }
        return cnt;
    }
}
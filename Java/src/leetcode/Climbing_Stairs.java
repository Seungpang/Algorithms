class Solution {
    /*
    1 2 3 5 8: �Ǻ���ġ ����
    f(n)=f(n-1)+f(n-2)
    f(5)=f(4)+f(3)
    f(4)=f(3)+f(2)
    �׳� ��ͱ����� �ϸ�: �������⵵ O(1) �ð����⵵ O(2^n)
    f(2)=2
    f(3)=3
    ���̳��� ���α׷��� -> �������⵵ O(n) �ð����⵵ O(n)
    ��ȭ���� ã�ƾ��Ѵ�.
    */
    public int climbStairs(int n) {
        if(n<=0) return 0;
        if(n==1) return 1;
        int [] d = new int[n+1];
        d[1]=1;
        d[2]=2;
        for(int i =3; i<=n;i++){
            d[i]=d[i-1]+d[i-2];
        }
        return d[n];
        
    }
}
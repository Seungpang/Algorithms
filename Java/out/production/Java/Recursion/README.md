# 순환(Recursion)

## 순환이란?
+ 자기 자신을 호출하는 함수

```c
int func(int n) {
    if (n==0)    //Base case: 적어도 하나의 recursion에 빠지지 않는 경우가 존재해야 한다.
        return 0;
    else
        return n + func(n-1); //Recursive case: recursion을 반복하다보면 결국 base case로 수렴해야 한다.
}
```

+ Factorial: n!
```c
int factorial(int n)
{
    if (n==0)
        return 1;
    else
        return n*factorial(n-1);
}
```

+ x^n
```c
double power(double x, int n) {
    if(n==0)
        return 1;
    else
        return x*power(x, n-1);
}
```

+ Fibonacci Number
```c
int fibonacci(int n) {
    if (n<2)
        return n;
    else
        return fibonacci(n-1) + fibonacci(n-2);
}
```

+ 최대공약수: Euclid Method
```c
int gcd(int p, int q) {
    if (q==0)
        return p;
    else
        return gcd(q, p%q);
}
```

## Recursive Thinking
수학함수 뿐만 아니라 다른 많은 문제들을 recursion으로 해결할 수 있다.
+ 문자열 길이 계산
```c
int length(char *str) {
    if (*str == '\0')
        return 0;
    else
        return 1 + length(str+1);
}
```

+ 순차 탐색
```c
int search(int data[], int n, int target) {
    if (n <= 0)
        return -1;
    else if (target == items[n-1])
        returm n-1;
    else
        return search(data, n-1, target);
}
```

+ 최대값 찾기
```c
int findMax(int n, int data[]) {
    if (n==1)
        return data[0];
    else
        return max(data[n-1], findMax(n-1, data));
}
```

+ Disjoint Sets
```c
bool isDisjoint(int m, int A[], int n, int B[])
{
    if(m<0 || n<0)
        return true;
    else if (A[m-1]==B[n-1])
        return false;
    else if (A[m-1]>B[n-1])
        return isDisjoint(m-1, A, n, B);
    else
        return isDisjoint(m, A, n-1, B);
}
```

## Recursion vs Iteration
+ 모든 순환함수는 반복문으로 변경 가능
+ 그 역도 성립함. 즉 ___모든 반복문은 recursion으로 표현 가능함___
+ 순환함수는 복잡한 알고리즘을 단순하고 알기 쉽게 표현하는 것을 가능하게 함
+ 하지만 함수 호출에 따른 오버해드가 있음(매개변수 전달, 액티베이션 프레임 생성 등)

## 순환적 알고리즘 설계
+ 적어도 하나의 base case, 즉 순환하지 않고 종료되는 케이스가 있어야 함
+ 모든 case는 결국 base case로 수렴해야 함

암시적(implicit) 매개변수를 *명시적(explicit) 매개변수*로 바꾸어라
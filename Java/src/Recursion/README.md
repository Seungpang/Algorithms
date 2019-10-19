#순환(Recursion)

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


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
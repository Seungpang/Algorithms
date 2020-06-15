# 미로찾기 

### Recursive Thinking

+ 현재 위치에서 출구까지 가능 경로가 있으려면
    + 현재 위치가 출구이거나 혹은
    + 이웃한 셀들 중 하나에서 ___현재 위치를 지나지 않고___ 출구까지 가는 경로가 있거나
    
 
```c
boolean findPath(x, y)
    if (x, y) is the exit
        return true;
    else
        for each neighbouing cell (x', y') of (x, y) do
            if (x', y') is on the pathway
                if findPath(x', y')
                    return true;
        return false;
```  
+ 무한루프에 빠지지 않는가를 고민해야함 !


```c
boolean findPath(x, y)
    if (x, y) is the exit
        return true;
    else
        mark (x, y) as a visited cell;
        for each neighbouing cell (x', y') of (x, y) do
            if (x', y') is on the pathway
                if findPath(x', y')
                    return true;
        return false;
```  

```
boolean findPath(x,y)
    if (x,y) is either on the wall or a visited cell
        return false;
    else if (x,y) is the exit
        return true;
    else
        mark (x,y) as a visited cell;
        for each neighbouring cell (x’,y’) of (x,y) do
            if findPath(x’,y’)
                return true;
        return false;
```
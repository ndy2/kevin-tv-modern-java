> High Order Function 
> 아래의 조건 중 하나 이상을 만족하는 함수 
> - function 이 다른 function 을 받는 함수
> - return 이 function 인 함수
> - e.g.
>  - Function<Function<Integer,String>, String>>
>  - Function<Integer, Function<Integer,String>> 
>    - f = i-> (i2 -> i+i2)
>    - (f.apply(1)).apply(9) = 10

package demo.tv.kevin.episode_07.example;

import java.math.BigDecimal;

public class CustomFunctionalInterfaceExample {


    public static void main(String[] args) {
        BigDecimalToCurrency bd = value -> "$" + value.toString();
        System.out.println(bd.toCurrency(new BigDecimal("120.00")));

        InvalidFunctionalInterface invalidFI = new InvalidFunctionalInterface() {
            @Override
            public <T> String myToString(T value) {
                return value.toString();
            }
        };

        System.out.println("anonymous class = " + invalidFI.myToString(123));

        //안됨 - Target Method 만 Generic 이면 안됨 - 타입 추론이 안됨
//        InvalidFunctionalInterface invalidFI2 = value -> value.toString();
//        System.out.println("Error" + invalidFI2.toString(123));
    }
}

@FunctionalInterface
interface BigDecimalToCurrency {
    String toCurrency(BigDecimal value);
}

//컴파일 에러가 안남
@FunctionalInterface
interface InvalidFunctionalInterface{
    <T> String myToString(T value);
}
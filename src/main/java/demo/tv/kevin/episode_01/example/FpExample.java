package demo.tv.kevin.episode_01.example;

public class FpExample {

    /**
     * 필드로 전략을 포함하는 Strategy Pattern과 달리
     * 실행할 메서드를 하나 포함한 calculation 인터페이스를 전달함 - Template Method ?
     *
     * Effective Java 같은 책에서는 Function "Object"를 사용하는 방식도 OOP의 Strategy Pattern으로 본다.
     * function 이 없던 Java 에서 사용하던 방식
     */
    static class FpCalculatorService{
        public int calculate (Calculation calculation, int a, int b){
            if(a > 10 && b < a){
                return calculation.calculate(a,b);
            }else{
                throw new IllegalArgumentException("Invalid input a : " + a + " b : " + b);
            }
        }
    }

    public static void main(String[] args) {
        final FpCalculatorService calculatorService = new FpCalculatorService();
        System.out.println("      addition : " + calculatorService.calculate(new Addition(), 20, 2));
        System.out.println("   subtraction : " + calculatorService.calculate(new Subtraction(), 20, 2));
        System.out.println("multiplication : " + calculatorService.calculate(new Multiplication(), 20, 2));
        System.out.println("      division : " + calculatorService.calculate(new Division(), 20, 2));


        System.out.println("      addition : " + calculatorService.calculate((a,b) -> a+b, 20, 2));
        System.out.println("   subtraction : " + calculatorService.calculate((a,b) -> a-b, 20, 2));
        System.out.println("multiplication : " + calculatorService.calculate((a,b) -> a*b, 20, 2));
        System.out.println("      division : " + calculatorService.calculate((a,b) -> a/b, 20, 2));
        System.out.println("   custom calc : " + calculatorService.calculate((a,b) -> (a+b)/2, 20, 2));

    }
}

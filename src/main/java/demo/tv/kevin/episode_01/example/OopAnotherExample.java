package demo.tv.kevin.episode_01.example;

// SRP - 한가지 목적으로만 변화해야함
public class OopAnotherExample {

    public static void main(String[] args) {
//        CalculatorServiceV0 calculatorService = new CalculatorServiceV0();
        CalculatorServiceV1 calculatorService = new CalculatorServiceV1(new Addition());

//        int add = calculatorService.calculate('+',1, 2);
        calculatorService = new CalculatorServiceV1(new Addition());
        int add = calculatorService.calculate(1, 2);

        System.out.println(add);

//        int sub = calculatorService.calculate('-',1, 2);
        calculatorService = new CalculatorServiceV1(new Subtraction());
        int sub = calculatorService.calculate(1, 2);
        System.out.println(sub);

//        int mul = calculatorService.calculate('*',1, 2);
        calculatorService = new CalculatorServiceV1(new Multiplication());
        int mul = calculatorService.calculate(1, 2);
        System.out.println(mul);

//        int div = calculatorService.calculate('/',1, 2);
        calculatorService = new CalculatorServiceV1(new Division());
        int div = calculatorService.calculate(1, 2);
        System.out.println(div);
    }
}

class CalculatorServiceV0{
    public int calculate(char op, int a, int b){
        if(op == '+'){
            return a+b;
        }else if(op == '-'){
            return a-b;
        }else if(op == '*'){
            return a*b;
        }else if(op == '/'){
            return a/b;
        }else{
            throw new IllegalStateException("Unknown opcode : "+op);
        }
    }
}

//=====================================================//
interface Calculation{
    int calculate(int a, int b);
}

class Addition implements Calculation{

    @Override
    public int calculate(int a, int b) {
        return a+b;
    }
}

class Subtraction implements Calculation{

    @Override
    public int calculate(int a, int b) {
        return a-b;
    }
}

class Multiplication implements Calculation{

    @Override
    public int calculate(int a, int b) {
        return a*b;
    }
}

class Division implements Calculation{

    @Override
    public int calculate(int a, int b) {
        return a/b;
    }
}

/**
 * Strategy Pattern
 */
class CalculatorServiceV1{
    private final Calculation calculation;

    public CalculatorServiceV1(Calculation calculation) {
        this.calculation = calculation;
    }

    public int calculate(int a, int b){
        return calculation.calculate(a,b);
    }
}

//====================================//
class CalculatorServiceV2{
    private final Calculation calculation1;
    private final Calculation calculation2;

    public CalculatorServiceV2(Calculation calculation1,Calculation calculation2) {
        this.calculation1 = calculation1;
        this.calculation2 = calculation2;

    }

    public int calculate(int a, int b){
        if(a > 10 && b < a){
            return calculation1.calculate(a,b);
        }else{
            throw new IllegalArgumentException("Invalid input a : " + a + " b : " + b);
        }
    }

    public int compute(int a, int b){
        if(a > 10 && b < a){
            return calculation2.calculate(a,b);
        }else{
            throw new IllegalArgumentException("Invalid input a : " + a + " b : " + b);
        }
    }
}
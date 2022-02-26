package demo.tv.kevin.episode_01.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorServiceTest {

    CalculatorServiceV0 calculatorServiceV0 = new CalculatorServiceV0();
    CalculatorServiceV1 calculatorServiceV1 = new CalculatorServiceV1(new Division());

    @Test
    void testCalculateAdd(){
        int actual = calculatorServiceV0.calculate('+', 2, 1);
        assertThat(actual).isEqualTo(3);
    }

    @Test
    void testCalculateSub(){
        int actual = calculatorServiceV0.calculate('-', 2, 1);
        assertThat(actual).isEqualTo(1);
    }


    @Test
    void testCalculateMul(){
        int actual = calculatorServiceV0.calculate('*', 2, 1);
        assertThat(actual).isEqualTo(2);
    }

    @Test
    void testCalculateDiv(){
        int actual = calculatorServiceV0.calculate('/', 2, 1);
        assertThat(actual).isEqualTo(2);
    }

    @Test
    void testCalculateDivZero(){
        assertThatThrownBy(()-> calculatorServiceV1.calculate(2, 0));
    }

    @Test
    void calculationTest(){
        assertThat(new Addition().calculate(1,2)).isEqualTo(3);
        assertThat(new Subtraction().calculate(1,2)).isEqualTo(-1);
        assertThat(new Multiplication().calculate(1,2)).isEqualTo(2);
        assertThat(new Division().calculate(1,2)).isEqualTo(0);

        assertThatThrownBy(()-> new Division().calculate(2, 0));
    }
}
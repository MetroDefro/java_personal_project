package calculator;

public class DivideOperator extends Operator {
    @Override
    public int operate(int firstNumber, int secondNumber) { // 나누기 기능을 하는 메서드 구현
        return firstNumber / secondNumber;
    }
}

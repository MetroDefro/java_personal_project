package calculator;

public class SubstractOperator extends Operator {
    @Override
    public int operate(int firstNumber, int secondNumber) { // 빼기 기능을 하는 메서드 구현
        return firstNumber - secondNumber;
    }
}
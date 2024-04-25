package calculator;

public class AddOperator extends Operator {
    @Override
    public int operate(int firstNumber, int secondNumber) { // 더하기 기능을 하는 메서드 구현
        return firstNumber + secondNumber;
    }
}

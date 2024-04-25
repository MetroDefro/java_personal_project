package calculator;

public class ModOperator extends Operator {
    @Override
    public int operate(int firstNumber, int secondNumber) { // 추상 메서드 상속 받아 나머지 기능 구현
        return firstNumber % secondNumber;
    }
}
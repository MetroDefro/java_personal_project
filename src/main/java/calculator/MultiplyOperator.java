package calculator;

public class MultiplyOperator extends Operator {
    @Override
    public <T extends Number> double operate(T firstNumber, T secondNumber) { // 곱하기 기능을 하는 메서드 구현
        if(firstNumber.getClass() == Double.class) // 리플렉션을 사용해 제너럴 타입을 재분석하여 Double, Integer 따로 계산하였다.
            return firstNumber.doubleValue() * secondNumber.doubleValue(); // Double이 들어왔을 경우
        else
            return firstNumber.intValue() * secondNumber.intValue(); // Integer가 들어왔을 경우
    }
}

package calculator;

public class SubstractOperator <T extends Number> extends Operator<T>  {
    @Override
    public T operate(T firstNumber, T secondNumber) {
        if(firstNumber.getClass() == Double.class) // 리플렉션을 사용해 제너럴 타입을 재분석하여 Double, Integer 따로 계산하였다.
            return (T)Double.valueOf(firstNumber.doubleValue() - secondNumber.doubleValue()); // Double이 들어왔을 경우
        else
            return (T)Integer.valueOf(firstNumber.intValue() - secondNumber.intValue()); // Integer가 들어왔을 경우
    }
}

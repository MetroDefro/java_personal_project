package calculator;

public class AddOperator <T extends Number> extends Operator<T> {
    @Override
    public T operate(T firstNumber, T secondNumber) {
        // 들어온 타입이 무엇인지 검사해서 해당 타입으로 변환기에 전달합니다.
        return (T)NumberConversionUtils.convertNumberToType(firstNumber.doubleValue() + secondNumber.doubleValue(), firstNumber.getClass());
    }
}
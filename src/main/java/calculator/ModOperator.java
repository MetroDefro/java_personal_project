package calculator;

public class ModOperator <T extends Number> extends Operator<T>  {
    @Override
    public T operate(T firstNumber, T secondNumber) {
        return (T)NumberConversionUtils.convertNumberToType(firstNumber.doubleValue() % secondNumber.doubleValue(), firstNumber.getClass());
    }
}
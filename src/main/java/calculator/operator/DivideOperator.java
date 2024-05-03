package calculator.operator;

import calculator.InputErrorException;
import calculator.NumberConversionUtils;

public class DivideOperator <T extends Number> extends Operator<T>  {
    @Override
    public T operate(T firstNumber, T secondNumber){
        try { // throw 하는 부분을 DivideOperator 안으로 보냈다.
            if(secondNumber.doubleValue() == 0) // 분모가 0일 경우 exception 발생!
                throw new InputErrorException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다."); // exception 만들어 던짐
        } catch (InputErrorException e) {
            throw new RuntimeException(e);
        }
        return (T) NumberConversionUtils.convertNumberToType(firstNumber.doubleValue() / secondNumber.doubleValue(), firstNumber.getClass());
    }
}

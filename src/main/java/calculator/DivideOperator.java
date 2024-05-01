package calculator;

public class DivideOperator <T extends Number> extends Operator<T>  {
    @Override
    public T operate(T firstNumber, T secondNumber){
        try { // throw 하는 부분을 DivideOperator 안으로 보냈다.
            if(secondNumber.doubleValue() == 0) // 분모가 0일 경우 exception 발생!
                throw new InputErrorException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다."); // exception 만들어 던짐
        } catch (InputErrorException e) {
            throw new RuntimeException(e);
        }
        if(firstNumber.getClass() == Double.class) // 리플렉션을 사용해 제너럴 타입을 재분석하여 Double, Integer 따로 계산하였다.
            return (T)Double.valueOf(firstNumber.doubleValue() / secondNumber.doubleValue()); // Double이 들어왔을 경우
        else
            return (T)Integer.valueOf(firstNumber.intValue() / secondNumber.intValue()); // Integer가 들어왔을 경우
    }
}

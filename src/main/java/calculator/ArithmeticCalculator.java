package calculator;

public class ArithmeticCalculator extends Calculator {

    // 사용할 오버라이딩 메서드는 public으로 변경
    // 2. 지금까지는 ArithmeticCalculator, 즉 사칙연산 계산기는 양의 정수(0 포함)를 매개변수로 전달받아 연산을 수행했습니다.
    @Override
    public <T extends Number> double calculate(T firstNumber, T secondNumber, char operator) throws InputErrorException {
        double result = 0;
        // 기존에는 switch 문을 사용했지만 상수값이 아니라 OperatorType.getSignal()로 char값을 얻어올 것이기 때문에
        // if 문으로 수정하였습니다.
        if(operator == OperatorType.ADD.getSignal()) { // enum 값에 매핑된 char 값과 대조한다.
            result = OperatorType.ADD.operate(firstNumber, secondNumber); // enum 값에서 operate 호출. 반환값은 result에 저장된다.
        }
        else if(operator == OperatorType.SUB.getSignal()) {
            result = OperatorType.SUB.operate(firstNumber, secondNumber);
        }
        else if(operator == OperatorType.MUL.getSignal()) {
            result = OperatorType.MUL.operate(firstNumber, secondNumber);
        }
        else if(operator == OperatorType.DIV.getSignal()) {
            if((int)secondNumber == 0) // 분모가 0일 경우 exception 발생!
                throw new InputErrorException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다."); // exception 만들어 던짐
            else
                result = OperatorType.DIV.operate(firstNumber, secondNumber);
        } else if(operator == OperatorType.MOD.getSignal()) {
            result = OperatorType.MOD.operate(firstNumber, secondNumber);
        }
        return result;
    }

    // 사용하지 않는 오버라이딩 메서드는 protected로 밖에서 접근 불가능하게 하였다
    @Override
    protected double calculate(int radius) {
        return 0;
    }
}

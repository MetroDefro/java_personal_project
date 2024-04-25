package calculator;

public class ArithmeticCalculator extends Calculator {
    private AddOperator addOperator; // 사칙연산 클래스 필드들 선언
    private SubstractOperator substractOperator;
    private MultiplyOperator multiplyOperator;
    private DivideOperator divideOperator;
    private ModOperator modOperator;

    public ArithmeticCalculator() {
        // 부모의 생성자는 자동으로 호출 된다.
        addOperator = new AddOperator(); // 사칙연산 클래스 필드들 생성
        substractOperator = new SubstractOperator();
        multiplyOperator = new MultiplyOperator();
        divideOperator = new DivideOperator();
        modOperator = new ModOperator();
    }

    // 사용할 오버라이딩 메서드는 public으로 변경
    @Override
    public double calculate(int firstNumber, int secondNumber, char operator) throws InputErrorException {
        double result = 0;
        switch (operator) { // operator 값에 따라 네 가지 case로 분류
            case '+': // 덧셈 연산 수행하여 result에 저장
                result = addOperator.operate(firstNumber, secondNumber); // 사칙연산 클래스로 책임을 분산하였다.
                break;
            case '-': // 뺄셈 연산 수행하여 result에 저장
                result = substractOperator.operate(firstNumber, secondNumber);
                break;
            case '*': // 곱샘 연산 수행하여 result에 저장
                result = multiplyOperator.operate(firstNumber, secondNumber);
                break;
            case '/': // 나눗셈 연산 수행하여 result에 저장
                if(secondNumber == 0) // 분모가 0일 경우 exception 발생!
                    throw new InputErrorException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다."); // exception 만들어 던짐
                else
                    result = divideOperator.operate(firstNumber, secondNumber);
                break;
            case '%': // 나머지 연산 수행하여 result에 저장
                result = modOperator.operate(firstNumber, secondNumber);
                break;
        }

        return result;
    }

    // 사용하지 않는 오버라이딩 메서드는 protected로 밖에서 접근 불가능하게 하였다
    @Override
    protected double calculate(int radius) {
        return 0;
    }

}

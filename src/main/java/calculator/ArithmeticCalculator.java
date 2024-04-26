package calculator;

import java.util.List;

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

    // 3. 저장된 연산 결과들 중 Scanner로 입력받은 값보다 큰 결과 값 들을 출력하고 싶습니다.
    public void inquiryBigger(double number) {
        // 람다, 스트림 적용.
        List<Double> biggerResults = results.stream().filter(o -> o > number).toList(); // 필터로 더 큰 숫자들만 뽑아 list화
        for(double element : biggerResults ) { // foreach 문 사용하여 results linkedlist 순회
            System.out.print(element + " "); // 출력하고 한 칸 띄기
        }
        System.out.println(); // 구분을 위한 한 줄 내리기
    }
}

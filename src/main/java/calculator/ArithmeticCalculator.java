package calculator;

import java.util.List;

public class ArithmeticCalculator<T extends Number> extends Calculator {

    public T calculate(T firstNumber, T secondNumber, char operator) throws InputErrorException {
        T result = null;
        switch (operator) {
            case '+':
                result = OperatorType.ADD.operate(firstNumber, secondNumber); // enum 값에서 operate 호출. 반환값은 result에 저장된다.
            case '-':
                result = OperatorType.SUB.operate(firstNumber, secondNumber); // enum 값에서 operate 호출. 반환값은 result에 저장된다.
            case '*':
                result = OperatorType.MUL.operate(firstNumber, secondNumber); // enum 값에서 operate 호출. 반환값은 result에 저장된다.
            case '/':
                if((int)secondNumber == 0) // 분모가 0일 경우 exception 발생!
                    throw new InputErrorException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다."); // exception 만들어 던짐
                else
                    result = OperatorType.DIV.operate(firstNumber, secondNumber);
            case '%':
                result = OperatorType.MOD.operate(firstNumber, secondNumber); // enum 값에서 operate 호출. 반환값은 result에 저장된다.
        }
        return result;
    }

    public void inquiryBigger(double number) {
        // 람다, 스트림 적용.
        List<Double> biggerResults = results.stream().filter(o -> o > number).toList(); // 필터로 더 큰 숫자들만 뽑아 list화
        for(double element : biggerResults ) { // foreach 문 사용하여 results linkedlist 순회
            System.out.print(element + " "); // 출력하고 한 칸 띄기
        }
        System.out.println(); // 구분을 위한 한 줄 내리기
    }
}

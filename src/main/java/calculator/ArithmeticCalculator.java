package calculator;

import java.util.List;

public class ArithmeticCalculator<T extends Number> extends Calculator {

    private final OperatorFactory<T> operatorFactory;

    public ArithmeticCalculator() {
        this.operatorFactory = new OperatorFactory<>();
    }

    // 계산을 진행할 메서드
    public T calculate(T firstNumber, T secondNumber, char operator) {
        // operatorFactory 객체로부터 operator 타입에 맞는 operator를 받아 operate 호출하여 계산한다.
        return operatorFactory.GetOperator(OperatorType.fromOperator(operator)).operate(firstNumber, secondNumber);
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

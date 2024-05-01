package calculator;

import java.util.List;

public class ArithmeticCalculator<T extends Number> extends Calculator {

    // 계산을 진행할 메서드
    public T calculate(T firstNumber, T secondNumber, char operator) {
        // operatorFactory 메서드에서 받은 operator로 operator 호출하여 계산한다.
        return operatorFactory(operator).operate(firstNumber, secondNumber);
    }

    // operator 기호로부터 해당하는 Operator를 리턴받기 위한 메서드
    private Operator<T> operatorFactory(char operator) {
        // 향상된 switch!
        return switch (OperatorType.fromOperator(operator)) { // char 기호를 OperatorType으로 변환
            case ADD -> new AddOperator(); // OperatorType에 따라 해당하는 Operator 리턴
            case SUB -> new SubstractOperator();
            case MUL -> new MultiplyOperator();
            case DIV -> new DivideOperator();
            case MOD -> new ModOperator();
        };
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

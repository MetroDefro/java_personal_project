package calculator.operator;

// 1. 현재 사칙연산 계산기는 +, -, *, /, % 이렇게 총 5가지 연산 타입으로 구성되어있습니다.
public enum OperatorType { // 연산 타입을 나타내는 enum
    ADD('+'), // 연산 기호인 char에 매핑하였다.
    SUB('-'),
    MUL('*'),
    DIV('/'),
    MOD('%');

    private final char signal; // 연산 기호를 매핑하기 위한 char signal

    OperatorType(char signal) {
        this.signal = signal; // 매핑 진행
    }

    // char를 받아 OperatorType으로 변환해 주는 static 메서드
    public static OperatorType fromOperator(char operator) {
        for (OperatorType type : OperatorType.values()) { // 전체 타입 순회
            if(type.signal == operator) { // 입력값과 일치하는 기호 나오면
                return type; // 반환
            }
        }
        throw new IllegalArgumentException("해당하는 연산자가 없습니다. " + operator); // 일치하는 게 없으면 예외처리
    }
}
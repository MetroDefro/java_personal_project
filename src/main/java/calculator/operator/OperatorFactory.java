package calculator.operator;

// 오퍼레이터들을 생성하는 클래스
public class OperatorFactory <T extends Number> {
    private final AddOperator<T> addOperator; // 오퍼레이터들 변할 일 없으므로 final로 선언
    private final SubstractOperator<T> substractOperator;
    private final MultiplyOperator<T> multiplyOperator;
    private final DivideOperator<T> divideOperator;
    private final ModOperator<T> modOperator;

    // 생성자에서 오퍼레이터 생성
    public OperatorFactory() {
        addOperator = new AddOperator<>();
        substractOperator = new SubstractOperator<>();
        multiplyOperator = new MultiplyOperator<>();
        divideOperator = new DivideOperator<>();
        modOperator = new ModOperator<>();
    }

    public Operator<T> GetOperator(OperatorType type) {
        return switch (type) { // OperatorType에 따라 해당하는 Operator 리턴
            case ADD -> addOperator;
            case SUB -> substractOperator;
            case MUL -> multiplyOperator;
            case DIV -> divideOperator;
            case MOD -> modOperator;
        };
    }
}

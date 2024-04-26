package calculator;

// 1. 현재 사칙연산 계산기는 +, -, *, /, % 이렇게 총 5가지 연산 타입으로 구성되어있습니다.
public enum OperatorType { // 연산 타입을 나타내는 enum
    ADD('+') { // char와 매핑해 주고 확장 메서드를 사용합니다
        public double operate(int a, int b) {
            return addOperator.operate(a, b); // 그대로 클래스의 operate를 호출합니다.
        }
    },
    SUB('-') {
        public double operate(int a, int b) {
            return substractOperator.operate(a, b);
        }
    },
    MUL('*') {
        public double operate(int a, int b) {
            return multiplyOperator.operate(a, b);
        }
    },
    DIV('/') {
        public double operate(int a, int b) {
            return divideOperator.operate(a, b);
        }
    },
    MOD('%') {
        public double operate(int a, int b) {
            return modOperator.operate(a, b);
        }
    };

    // 사칙연산 인스턴트은 enum에 생성한다.
    // 즉 ArithmeticCalculator는 이 클래스를 알 필요가 없다.
    // enum은 처음에 한 번 생성되고 유지된다. (싱글턴)
    // 그래서 final static으로 하지 않으면 나중에 변경 가능성이 생기기 때문인지 오류가 발생했습니다.
    private final static AddOperator addOperator  = new AddOperator();;
    private final static SubstractOperator substractOperator = new SubstractOperator();
    private final static MultiplyOperator multiplyOperator = new MultiplyOperator();
    private final static DivideOperator divideOperator = new DivideOperator();
    private final static ModOperator modOperator = new ModOperator();

    private final char signal; // 연산 기호를 매핑하기 위한 char signal

    OperatorType(char signal) {
        this.signal = signal; // 매핑 진행
    }

    public char getSignal() {
        return signal; // enum의 char 값을 얻기 위함
    }

    public abstract double operate(int a, int b); // 추상 클래스. 그대로 operator의 operate 메서드를 반환할 예정이라 똑같은 형태.
}
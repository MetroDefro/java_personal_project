package calculator;

public abstract class Operator {
    // 사칙 연산 메서드가 전부 같은 형태로 이루어져 있기 때문에 추상 메서드로 만듦
    public abstract <T extends Number> double operate(T firstNumber, T secondNumber);
}

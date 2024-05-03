package calculator.calculator;

public class CircleCalculator extends Calculator {
    private static final double PI = 3.14; // 절대 변할 일 없는 필드이기 때문에 static final 활용

    public double calculate(int radius) {
        return PI * radius * radius; // 원 넓이 구하는 공식
    }
}

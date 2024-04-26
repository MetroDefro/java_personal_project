package calculator;

public class CircleCalculator extends Calculator {
    private static final double PI = 3.14; // 절대 변할 일 없는 필드이기 때문에 static final 활용

    // 사용하지 않는 오버라이딩 메서드는 protected로 밖에서 접근 불가능하게 하였다
    @Override
    protected <T extends Number> double calculate(T firstNumber, T secondNumber, char operator) throws InputErrorException {
        return 0;
    }

    // 사용할 오버라이딩 메서드는 public으로 변경
    @Override
    public double calculate(int radius) {
        return PI * radius * radius; // 원 넓이 구하는 공식
    }
}

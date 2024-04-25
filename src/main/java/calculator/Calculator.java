package calculator;

import java.util.LinkedList;

public class Calculator {
    // 1. 양의 정수 2개(0 포함)와 연산 기호를 매개변수로 받아 사칙연산(+,-,*,/)
    // 2. 기능을 수행한 후 결과 값을 반환하는 메서드와 연산 결과를 저장하는 컬렉션 타입 필드를 가진 Calculator 클래스를 생성합니다.
    // 3. App 클래스의 main 메서드에서 Calculator 클래스의 연산 결과를 저장하고 있는 컬렉션 필드에 직접 접근하지 못하도록 수정합니다. (캡슐화)
    private LinkedList<Integer> results = new LinkedList<>(); // 연산 결과를 저장하기 적합한 컬렉션인 LinkedList private로 선언 및 생성

    public LinkedList<Integer> getResults() { // results getter
        return results;
    };

    public void setResults(LinkedList<Integer> results) { // results setter
        this.results = results;
    }

    public int calculate(int firstNumber, int secondNumber, char operator) throws InputErrorException {
        int result = 0;
        switch (operator) { // operator 값에 따라 네 가지 case로 분류
            case '+': // 덧셈 연산 수행하여 result에 저장
                result = firstNumber + secondNumber;
                break;
            case '-': // 뺄셈 연산 수행하여 result에 저장
                result = firstNumber - secondNumber;
                break;
            case '*': // 곱샘 연산 수행하여 result에 저장
                result = firstNumber * secondNumber;
                break;
            case '/': // 나눗셈 연산 수행하여 result에 저장
                if(secondNumber == 0) // 분모가 0일 경우 exception 발생!
                    throw new InputErrorException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다."); // exception 만들어 던짐
                else
                    result = firstNumber / secondNumber;
                break;
        }

        return result;
    }
}

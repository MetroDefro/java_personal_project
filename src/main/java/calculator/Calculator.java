package calculator;

import java.util.LinkedList;

public class Calculator {
    // 1. 양의 정수 2개(0 포함)와 연산 기호를 매개변수로 받아 사칙연산(+,-,*,/)
    // 2. 기능을 수행한 후 결과 값을 반환하는 메서드와 연산 결과를 저장하는 컬렉션 타입 필드를 가진 Calculator 클래스를 생성합니다.
    // 3. App 클래스의 main 메서드에서 Calculator 클래스의 연산 결과를 저장하고 있는 컬렉션 필드에 직접 접근하지 못하도록 수정합니다. (캡슐화)
    private LinkedList<Integer> results; // 연산 결과를 저장하기 적합한 컬렉션인 LinkedList private로 선언

    public LinkedList<Integer> getResults() { // results getter
        return results;
    };

    // 6. Calculator 인스턴스를 생성(new)할 때 생성자를 통해 연산 결과를 저장하고 있는 컬렉션 필드가 초기화 되도록 수정합니다
    public Calculator() {
        results = new LinkedList<>(); // 생성자에서 컬렉션 필드를 초기화
    }

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

    // 4. Calculator 클래스에 저장된 연산 결과들 중
    // 가장 먼저 저장된 데이터를 삭제하는 기능을 가진 메서드를 구현한 후 App 클래스의 main 메서드에 삭제 메서드가 활용될 수 있도록 수정합니다.
    public void removeResult() {
        results.removeFirst(); // 첫 결과 삭제
    }

    // 5. Calculator 클래스에 저장된 연산 결과들을 조회하는 기능을 가진 메서드를 구현한 후
    // App 클래스의 main 메서드에 조회 메서드가 활용될 수 있도록 수정합니다.
    public void inquiryResults() {
        for(int element : results ) { // foreach 문 사용하여 results linkedlist 순회
            System.out.print(element + " "); // 출력하고 한 칸 띄기
        }
        System.out.println(); // 구분을 위한 한 줄 내리기
    }
}

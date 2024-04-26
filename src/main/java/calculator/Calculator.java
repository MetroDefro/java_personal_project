package calculator;

import java.util.LinkedList;

public abstract class Calculator {
    private LinkedList<Double> results; // 결과를 저장하는 컬렉션 타입의 필드 선언

    public Calculator() {
        results = new LinkedList<>(); // 생성자에서 컬렉션 필드를 초기화
    }

    public LinkedList<Double> getResults() { // results getter
        return results;
    };

    public void setResults(LinkedList<Double> results) { // results setter
        this.results = results;
    }

    // calculate는 두 경우에 매개 변수를 다르게 받아야 해서 오버로딩 하였다.
    // Integer, Double 모두 Number를 상속받기 때문에 Number와 그 자식 클래스로 한정지었다.
    // 반환값은 Double로 저장하고 있기 때문에 전부 T가 아니라 double이다.
    protected abstract <T extends Number> double calculate(T firstNumber, T secondNumber, char operator) throws InputErrorException;
    protected abstract double calculate(int number);

    public void removeResult() { // 첫 결과 삭제 메서드
        results.removeFirst(); // 첫 결과 삭제
    }

    public void inquiryResults() { // 컬렉션 조회 메서드
        for(double element : results ) { // foreach 문 사용하여 results linkedlist 순회
            System.out.print(element + " "); // 출력하고 한 칸 띄기
        }
        System.out.println(); // 구분을 위한 한 줄 내리기
    }
}

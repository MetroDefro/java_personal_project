package calculator.calculator;

import calculator.InputErrorException;

import java.util.LinkedList;

public abstract class Calculator {
    // 자식 클래스에서도 접근 가능하도록 protected로 수정
    protected LinkedList<Double> results; // 결과를 저장하는 컬렉션 타입의 필드 선언

    public Calculator() {
        results = new LinkedList<>(); // 생성자에서 컬렉션 필드를 초기화
    }

    public LinkedList<Double> getResults() { // results getter
        return results;
    };

    public void setResults(LinkedList<Double> results) { // results setter
        this.results = results;
    }

    // calculate는 추상 메서드 구현을 하지 않는 것으로 변경하였다. 매개변수가 달라서 어차피 오버로딩 하던 것이라 상속의 의미 없음.

    public void removeResult() { // 첫 결과 삭제 메서드
        results.removeFirst(); // 첫 결과 삭제
    }

    public void inquiryResults() { // 컬렉션 조회 메서드
        for(double element : results ) { // foreach 문 사용하여 results linkedlist 순회
            System.out.print(element + " "); // 출력하고 한 칸 띄기
        }
        System.out.println(); // 구분을 위한 한 줄 내리기
    }

    // 파싱하는 부분은 인스턴스 별로 있을 이유가 없어서 static으로 만들었다.
    public static int parseInputToOption(String input, int optionCount) throws InputErrorException { // int 파싱
        // 옵션 수 보다 많은 값 of 0이하 값 입력
        int result = parseInputToInt(input);
        if(result <= 0 || result > optionCount) { // 정규식 검사
            throw new InputErrorException("옵션에 해당하는 값을 입력해주세요."); // exception 만들어 던짐
        }

        return  result;
    }

    public static int parseInputToInt(String input) throws InputErrorException { // int 파싱
        // 양수가 들어오지 않을 경우 예외처리
        if(input.matches("^[0-9]+$")) { // 정규식 검사
            return Integer.parseInt(input);
        } else {
            throw new InputErrorException("0을 포함한 양의 정수를 입력해야 합니다."); // exception 만들어 던짐
        }
    }

    public static double parseInputToDouble(String input) throws InputErrorException { // double 파싱
        // 양수가 들어오지 않을 경우 예외처리
        if(input.matches("^[^0]\\d*|^[^0]\\d*\\.{1}\\d*[^0]$|^(0.)\\d*[^0]$")) {
            return Double.parseDouble(input);
        } else {
            throw new InputErrorException("0을 포함한 양의 실수를 입력해야 합니다."); // exception 만들어 던짐
        }
    }
}

package calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // 사칙연산, 원 넓이 계산기 각각 생성
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator();
        CircleCalculator circleCalculator = new CircleCalculator();

        Scanner sc = new Scanner(System.in); // 스캐너 생성

        boolean isEnd = false; // 종료 할지 여부를 boolean에 저장하기 위해 변수 생성.
        do { // 첫번째는 무조건 실행.
            System.out.println("계산기 옵션(번호 입력): 1. 사칙연산, 2. 원의 너비 구하기"); // 사칙연산 원의 너비 중 선택하도록 제시
            try {
                switch (Calculator.parseInputToOption(sc.nextLine(), 2)) {
                    case 1: // 사칙 연산 로직
                        // double, int 중 선택하도록 제시
                        System.out.print("계산 할 타입을 선택해주세요(번호 입력): 1. 정수, 2. 실수 ");
                        int type = Calculator.parseInputToOption(sc.nextLine(), 2); // 무슨 타입인지 받는다
                        double result = 0; // result를 if 문 밖으로 뺐다.

                        if (type == 1) { // 정수 선택
                            System.out.print("첫 번째 숫자를 입력하세요: ");
                            int firstNumber = Calculator.parseInputToInt(sc.nextLine()); // int를 입력받아 파싱.
                            System.out.print("두 번째 숫자를 입력하세요: ");
                            int secondNumber = Calculator.parseInputToInt(sc.nextLine()); // int를 입력받아 파싱.

                            System.out.print("사칙연산 기호를 입력하세요: ");
                            char operator = sc.nextLine().charAt(0); // 입력 받은 string의 인덱스 0번 char을 가져온다.

                            result = (int)arithmeticCalculator.calculate(firstNumber, secondNumber, operator);
                        } else if (type == 2) { // 실수 선택
                            System.out.print("첫 번째 숫자를 입력하세요: ");
                            double firstNumber = Calculator.parseInputToDouble(sc.nextLine()); // double 입력 받는다.
                            System.out.print("두 번째 숫자를 입력하세요: ");
                            double secondNumber = Calculator.parseInputToDouble(sc.nextLine()); // double 입력 받는다.

                            System.out.print("사칙연산 기호를 입력하세요: ");
                            char operator = sc.nextLine().charAt(0); // 입력 받은 string의 인덱스 0번 char을 가져온다.

                            result = (double)arithmeticCalculator.calculate(firstNumber, secondNumber, operator);
                        }

                        System.out.println("결과: " + result);

                        arithmeticCalculator.getResults().add(result); // 리스트에 결과 추가

                        System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
                        if (sc.nextLine().equals("remove")) { // 입력 받은 답변이 "remove"일 경우
                            arithmeticCalculator.removeResult(); // 첫 결과 삭제
                        }

                        System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                        if (sc.nextLine().equals("inquiry")) { // 입력 받은 답변이 "inquiry"일 경우
                            arithmeticCalculator.inquiryResults(); // 결과 조회
                        }

                        System.out.println("입력 값보다 더 큰 값을 조회하겠습니다. 기준 숫자를 입력하세요.");
                        double standardNumber = Calculator.parseInputToDouble(sc.nextLine()); // double 입력 받는다.
                        arithmeticCalculator.inquiryBigger(standardNumber); // 결과 조회

                        System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
                        isEnd = sc.nextLine().equals("exit"); // 입력 받은 답변이 "exit"라면 isEnd는 true 아니면 false 유지

                        break;
                    case 2: // 원의 너비 구하기 로직
                        System.out.print("원의 반지름을 입력하세요: ");
                        int radius = Calculator.parseInputToInt(sc.nextLine()); // int를 입력 받는다.

                        result = circleCalculator.calculate(radius); // 원 넓이 구하는 메서드 호출하고 값 result에 저장

                        System.out.println("결과: " + result);

                        circleCalculator.getResults().add(result); // 컬렉션에 결과 저장
                        circleCalculator.inquiryResults(); // 원의 넓기 결과들 바로 전체 조회
                        System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
                        isEnd = sc.nextLine().equals("exit"); // 입력 받은 답변이 "exit"라면 isEnd는 true 아니면 false 유지
                        break;
                }
            } catch (InputErrorException e) {
                System.out.println(e.getMessage());
            }
        } while (!isEnd);
    }
}

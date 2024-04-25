package calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // 8. 사칙연산을 수행하는 계산기 ArithmeticCalculator 클래스와 원과 관련된 연산을 수행하는 계산기 CircleCalculator 클래스 2개를 구현합니다.
        // 사칙연산, 원 넓이 계산기 각각 생성
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator();
        CircleCalculator circleCalculator = new CircleCalculator();

        Scanner sc = new Scanner(System.in); // 스캐너 생성

        boolean isEnd = false; // 종료 할지 여부를 boolean에 저장하기 위해 변수 생성.
        do { // 첫번째는 무조건 실행.
            System.out.println("계산기 옵션(번호 입력): 1. 사칙연산, 2. 원의 너비 구하기"); // 사칙연산 원의 너비 중 선택하도록 제시
            switch (sc.nextInt()) { // 입력 받은 값에 따라 두 갈래로 나뉜다.
                case 1: // 사칙 연산 로직
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    int firstNumber = sc.nextInt(); // int를 입력 받는다.
                    System.out.print("두 번째 숫자를 입력하세요: ");
                    int secondNumber = sc.nextInt(); // int를 입력 받는다.

                    System.out.print("사칙연산 기호를 입력하세요: ");
                    char operator = sc.next().charAt(0); // 입력 받은 string의 인덱스 0번 char을 가져온다.

                    try {
                        double result = arithmeticCalculator.calculate(firstNumber, secondNumber, operator);

                        System.out.println("결과: " + result);

                        arithmeticCalculator.getResults().add(result); // 리스트에 결과 추가

                        System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
                        if(sc.next().equals("remove")) { // 입력 받은 답변이 "remove"일 경우
                            arithmeticCalculator.removeResult(); // 첫 결과 삭제
                        }

                        System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                        if(sc.next().equals("inquiry")) { // 입력 받은 답변이 "inquiry"일 경우
                            arithmeticCalculator.inquiryResults(); // 결과 조회
                        }

                        System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
                        isEnd = sc.next().equals("exit"); // 입력 받은 답변이 "exit"라면 isEnd는 true 아니면 false 유지

                    } catch (InputErrorException e) {
                        System.out.println(e.getMessage()); // 예외 발생시 로그 출력
                    }
                    break;
                case 2: // 원의 너비 구하기 로직
                    System.out.print("원의 반지름을 입력하세요: ");
                    int radius = sc.nextInt(); // int를 입력 받는다.

                    double result = circleCalculator.calculate(radius); // 원 넓이 구하는 메서드 호출하고 값 result에 저장

                    System.out.println("결과: " + result);

                    circleCalculator.getResults().add(result); // 컬렉션에 결과 저장
                    circleCalculator.inquiryResults(); // 원의 넓기 결과들 바로 전체 조회
                    System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
                    isEnd = sc.next().equals("exit"); // 입력 받은 답변이 "exit"라면 isEnd는 true 아니면 false 유지
                    break;
            }
        } while (!isEnd);
    }
}

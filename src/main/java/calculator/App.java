package calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // 2. Level 1에서 구현한 App 클래스의 main 메서드에 Calculator 클래스가 활용될 수 있도록 수정합니다.
        Calculator calculator = new Calculator();

        Scanner sc = new Scanner(System.in); // 스캐너 생성

        boolean isEnd = false; // 종료 할지 여부를 boolean에 저장하기 위해 변수 생성.
        do { // 첫번째는 무조건 실행.
            // 7. Calculator 클래스에 반지름을 매개변수로 전달받아 원의 넓이를 계산하여 반환해주는 메서드를 구현합니다.
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
                        int result = calculator.calculate(firstNumber, secondNumber, operator);

                        System.out.println("결과: " + result);

                        // 3. App 클래스의 main 메서드에서 Calculator 클래스의 연산 결과를 저장하고 있는 컬렉션 필드에 직접 접근하지 못하도록 수정합니다. (캡슐화)
                        calculator.getResults().add(result); // 리스트에 결과 추가

                        System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
                        // 4. Calculator 클래스에 저장된 연산 결과들 중
                        // 가장 먼저 저장된 데이터를 삭제하는 기능을 가진 메서드를 구현한 후 App 클래스의 main 메서드에 삭제 메서드가 활용될 수 있도록 수정합니다.
                        if(sc.next().equals("remove")) { // 입력 받은 답변이 "remove"일 경우
                            calculator.removeResult(); // 첫 결과 삭제
                        }

                        // 5. Calculator 클래스에 저장된 연산 결과들을 조회하는 기능을 가진 메서드를 구현한 후
                        // App 클래스의 main 메서드에 조회 메서드가 활용될 수 있도록 수정합니다.
                        System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                        if(sc.next().equals("inquiry")) { // 입력 받은 답변이 "inquiry"일 경우
                            calculator.inquiryResults(); // 결과 조회
                        }

                        System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
                        isEnd = sc.next().equals("exit"); // 입력 받은 답변이 "exit"라면 isEnd는 true 아니면 false 유지

                    } catch (InputErrorException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                // 7. Calculator 클래스에 반지름을 매개변수로 전달받아 원의 넓이를 계산하여 반환해주는 메서드를 구현합니다.
                case 2: // 원의 너비 구하기 로직
                    System.out.print("원의 반지름을 입력하세요: ");
                    int radius = sc.nextInt(); // int를 입력 받는다.

                    double result = calculator.calculateCircleArea(radius); // 원 넓이 구하는 메서드 호출하고 값 result에 저장

                    System.out.println("결과: " + result);

                    calculator.getCircleAreaResult().add(result); // 컬렉션에 결과 저장
                    calculator.inquiryCircleAreaResult(); // 원의 넓기 결과들 바로 전체 조회
                    System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
                    isEnd = sc.next().equals("exit"); // 입력 받은 답변이 "exit"라면 isEnd는 true 아니면 false 유지
                    break;
            }
        } while (!isEnd);
    }
}

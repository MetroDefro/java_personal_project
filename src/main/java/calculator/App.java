package calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // 2. Level 1에서 구현한 App 클래스의 main 메서드에 Calculator 클래스가 활용될 수 있도록 수정합니다.
        Calculator calculator = new Calculator();

        Scanner sc = new Scanner(System.in); // 스캐너 생성

        boolean isEnd = false; // 종료 할지 여부를 boolean에 저장하기 위해 변수 생성.
        do { // 첫번째는 무조건 실행.
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int firstNumber = sc.nextInt(); // int를 입력 받는다.
            System.out.print("두 번째 숫자를 입력하세요: ");
            int secondNumber = sc.nextInt(); // int를 입력 받는다.

            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0); // 입력 받은 string의 인덱스 0번 char을 가져온다.

            try {
                int result = calculator.calculate(firstNumber, secondNumber, operator);

                System.out.println("결과: " + result);

                calculator.results.add(result); // 리스트에 결과 추가

                System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
                if(sc.next().equals("remove")) { // 입력 받은 답변이 "remove"일 경우
                    calculator.results.removeFirst(); // 첫 결과 삭제
                }

                System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                if(sc.next().equals("inquiry")) { // 입력 받은 답변이 "inquiry"일 경우
                    for(int element : calculator.results ) { // foreach 문 사용하여 results linkedlist 순회
                        System.out.print(element + " "); // 출력하고 한 칸 띄기
                    }
                    System.out.println(); // 구분을 위한 한 줄 내리기
                }

                System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
                isEnd = sc.next().equals("exit"); // 입력 받은 답변이 "exit"라면 isEnd는 true 아니면 false 유지
            } catch (InputErrorException e) {
                System.out.println(e.getMessage());
            }

        } while (!isEnd);
    }
}

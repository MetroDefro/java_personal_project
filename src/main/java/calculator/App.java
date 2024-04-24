package calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // 1. Scanner를 사용하여 양의 정수 2개(0 포함)를 전달 받을 수 있습니다.
        Scanner sc = new Scanner(System.in); // 스캐너 생성

        // 4. 반복문을 사용하여 반복의 종료를 알려주는 “exit” 문자열을 입력하기 전까지 무한으로 계산을 진행할 수 있도록 소스 코드를 수정합니다.
        boolean isEnd = false; // 종료 할지 여부를 boolean에 저장하기 위해 변수 생성.
        do { // 첫번째는 무조건 실행.
            // 1. Scanner를 사용하여 양의 정수 2개(0 포함)를 전달 받을 수 있습니다.
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int firstNumber = sc.nextInt(); // int를 입력 받는다.
            System.out.print("두 번째 숫자를 입력하세요: ");
            int secondNumber = sc.nextInt(); // int를 입력 받는다.

            // 2. Scanner를 사용하여 사칙연산 기호를 전달 받을 수 있습니다.
            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0); // 입력 받은 string의 인덱스 0번 char을 가져온다.

            // 3. 입력받은 양의 정수 2개와 사칙연산 기호를 사용하여 연산을 진행한 후 결과값을 출력합니다.
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
                    if(secondNumber == 0) // 분모가 0일 경우 아래 문구 출력
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    else
                        result = firstNumber / secondNumber;
                    break;
            }

            System.out.println("결과: " + result);
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            isEnd = sc.next().equals("exit"); // 입력 받은 답변이 "exit"라면 isEnd는 true 아니면 false 유지
        } while (!isEnd);
    }
}

package calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // 1. Scanner를 사용하여 양의 정수 2개(0 포함)를 전달 받을 수 있습니다.
        Scanner sc = new Scanner(System.in); // 스캐너 생성
        System.out.print("첫 번째 숫자를 입력하세요: ");
        int firstNumber = sc.nextInt(); // int를 입력 받는다.
        System.out.print("두 번째 숫자를 입력하세요: ");
        int secondNumber = sc.nextInt(); // int를 입력 받는다.

        // 2. Scanner를 사용하여 사칙연산 기호를 전달 받을 수 있습니다.
        System.out.print("사칙연산 기호를 입력하세요: ");
        char operator = sc.next().charAt(0); // 입력 받은 string의 인덱스 0번 char을 가져온다.
    }
}

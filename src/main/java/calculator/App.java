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
    }
}

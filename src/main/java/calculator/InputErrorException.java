package calculator;

public class InputErrorException extends Exception{ // 인풋에 문제가 있다는 걸 알리는 Exception 생성
    public InputErrorException(String msg){ // 생성자. 파라미터로 메세지를 받는다.
        super(msg); // 부모 생성자로 전달
    }
}

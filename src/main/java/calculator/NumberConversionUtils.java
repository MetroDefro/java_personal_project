package calculator;

public class NumberConversionUtils {
    @SuppressWarnings("unchecked") // 경고 문구 나오지 않도록
    public static <T extends Number> T convertNumberToType(Number result, Class<T> type) {
        if(type == Integer.class) { // 타입이 Inteager인지 Double인지 검사하고
            return (T) Integer.valueOf(result.intValue()); // 타입 변환하여 리턴합니다.
        } else if(type == Double.class) {
            return (T) Double.valueOf(result.doubleValue());
        } else {
            throw new IllegalArgumentException("지원하지 않는 타입입니다. " + type); // 이상한 타입 들어올 경우 예외처리
        }
    }
}

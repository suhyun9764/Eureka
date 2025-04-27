package ch11;

// 사용자 정의 예외
// extends RuntimeException 일 경우 compile 오류 발생 x
public class InsufficientException extends RuntimeException {
    public InsufficientException(String message) {
        super(message);
    }

    public InsufficientException() {
    }
}

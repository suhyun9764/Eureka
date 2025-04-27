package singleton;

import java.time.LocalDateTime;

// Singleton
public class Logger {

    // #3 필드로 Logger 변수 필요
    private static Logger logger;
    // #1 생성자를 private 으로
    private Logger(){}

    // #2 자신 객체를 생성, 전달하는 메서드를 제공
    // 외부에서 logger 객체 생성 없이 호출 가능
    public static Logger getInstance(){
//        return logger;
        if(logger == null){
            logger = new Logger();
        }
        return logger;  // Lazy Loading
    }
    public void log(String message) {
        LocalDateTime ldt = LocalDateTime.now();
        String date = ldt.getYear() + "/" + ldt.getMonthValue() + "/" + ldt.getDayOfMonth();
        String time = ldt.getHour() + ":" + ldt.getMinute() + ":" + ldt.getSecond();

        System.out.println("[" + date + " " + time + "] " + message);
    }
}

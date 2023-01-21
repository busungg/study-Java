# java.time 패키지

1. Date와 Calendar가 가지고 있던 단점들을 해소하기 위해 JDK1.8부터 'java.time패키지'가 추가되었다.
2. java.time, java.time.chrono, java.time.format, java.time.temporal, java.time.zome 패키지에 속한 클래스들의 가장 큰 특징은  
   String 클래스처럼 불변(immutable)이라는 것이다.  
   그래서 날짜나 시간을 변경하는 메서드들은 기존의 객체를 변경하는 대신 항상 변경된 새로운 객체를 반환한다.  
   **_기존 Calendar 클래스는 변경 가능하므로 멀티 쓰레드 환경에서 안전하지 못하다._**

### 1. java.time 패키지의 핵심 클래스

1. LocalDate(날짜) + LocalTime(시간) => LocalDateTime(날짜 & 시간)
2. LocalDateTime + 시간대 => ZonedDateTime

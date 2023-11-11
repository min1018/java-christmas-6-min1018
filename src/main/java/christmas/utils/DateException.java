package christmas.utils;

public class DateException {
    static final String DATE_IN_RANGE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";

    public static void isDateValid(int date) {
        isDateInRange(date);
    }
    public static void isDateInRange(int date) {
        if( date < 1 || date > 31) {
            throw new IllegalArgumentException(DATE_IN_RANGE);
        }
    }


}

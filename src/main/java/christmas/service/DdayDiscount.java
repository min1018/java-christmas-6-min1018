package christmas.service;

public class DdayDiscount {
    public static int calcDday(int date) {
        return (date-1) *100 + 1000;
    }
}

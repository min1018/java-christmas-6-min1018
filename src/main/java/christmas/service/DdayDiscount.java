package christmas.service;

import christmas.domain.User;

public class DdayDiscount {
    public static int calcDday(User user) {
        return (user.getDate() -1) *100 + 1000;
    }
}

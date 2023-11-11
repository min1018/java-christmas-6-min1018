package christmas.service;

import christmas.domain.User;

public class DdayDiscount {
    public static int calcDday(User user) {
        if (user.getDate() <= 25) {
            return (user.getDate() -1) *100 + 1000;
        }
        return 0;
    }
}

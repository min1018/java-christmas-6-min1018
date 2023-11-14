package christmas.service;

import christmas.domain.User;

public class DdayDiscount {
    public static User calcDday(User user) {
        if (user.getDate() <= 25) {
            user.moreDiscount((user.getDate()-1)*100 +1000,"디데이");
        }
        return user;
    }
}

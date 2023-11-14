package christmas.service;

import christmas.domain.User;

public class BonusDiscount {
    public static User isAvaliable(User user) {
        if(user.getTotalOrderBeforeDiscount() > 120000) {
            user.moreDiscount(25000, "증정");
        }
        return user;
    }
}

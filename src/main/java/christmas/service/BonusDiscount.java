package christmas.service;

import christmas.domain.DiscountHistory;
import christmas.domain.User;

public class BonusDiscount {
    public static DiscountHistory isAvaliable(User user, DiscountHistory discountHistory) {
        if(user.getTotalOrderBeforeDiscount() > 120000) {
            discountHistory.updateBonus(25000);
            return discountHistory;
        }
        return discountHistory;
    }
}

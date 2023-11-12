package christmas.service;

import christmas.domain.DiscountHistory;
import christmas.domain.User;

public class DdayDiscount {
    public static DiscountHistory calcDday(User user, DiscountHistory discountHistory) {
        if (user.getDate() <= 25) {
            discountHistory.updateDday((user.getDate()-1)*100 +1000);
            return discountHistory;
        }
        return discountHistory;
    }
}

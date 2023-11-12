package christmas.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import christmas.domain.DiscountHistory;
import christmas.domain.User;

public class SpecialDiscount {
    private static final List<Integer> specialDayDiscount = new ArrayList<>(Arrays.asList(3, 10, 17, 24, 31, 25));

    public static DiscountHistory isAvailable(User user, DiscountHistory discountHistory) {
        if (specialDayDiscount.contains(user.getDate())) {
            discountHistory.updateSpecial(1000);
            return discountHistory;
        }
        return discountHistory;
    }

}

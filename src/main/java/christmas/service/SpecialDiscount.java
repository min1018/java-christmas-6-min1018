package christmas.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import christmas.domain.DiscountOption;
import christmas.domain.User;

public class SpecialDiscount {
    private static final List<Integer> specialDayDiscount = new ArrayList<>(Arrays.asList(3, 10, 17, 24, 31, 25));

    public static User isAvailable(User user) {
        if (specialDayDiscount.contains(user.getDate())) {
            user.moreDiscount(1000,"특별");
        }
        return user;
    }

}

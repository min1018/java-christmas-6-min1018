package christmas.service;

import christmas.domain.DiscountOption;
import christmas.domain.Menus;
import christmas.domain.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WeekendWeekdayDiscount {
    private static final List<Integer> mainMenuDiscount = new ArrayList<>(Arrays.asList(1, 2, 8, 9, 15, 16, 22, 23, 29, 30));
    public static User whichDiscountAvailable(User user) {
        List<Menus> menus = user.getOrderedMenus();

        if (mainMenuDiscount.contains(user.getDate())) {
            return weekendsDiscount(user, menus);
        }
        return weekdaysDiscount(user,menus);
    }

    private static User weekdaysDiscount(User user, List<Menus> menus) {
        int totalDiscount = 0;
        for(Menus menu : menus) {
            if (menu.getCategory() == "디저트") {
                totalDiscount += 2023 * menu.getCount();
            }
        }
        user.moreDiscount(totalDiscount, "평일");
        return user;
    }

    private static User weekendsDiscount(User user, List<Menus> menus) {
        int totalDiscount = 0;
        for (Menus menu: menus) {
            if (menu.getCategory() == "메인") {
                totalDiscount += 2023 * menu.getCount();
            }
        }
        user.moreDiscount(totalDiscount, "주말");
        return user;
    }
}

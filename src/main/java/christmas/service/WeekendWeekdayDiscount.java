package christmas.service;

import christmas.domain.DiscountHistory;
import christmas.domain.Menus;
import christmas.domain.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WeekendWeekdayDiscount {
    private static final List<Integer> mainMenuDiscount = new ArrayList<>(Arrays.asList(1, 2, 8, 9, 15, 16, 22, 23, 29, 30));
    public static DiscountHistory whichDiscountAvailable(User user, DiscountHistory discountHistory) {
        List<Menus> menus = user.getOrderedMenus();

        if (mainMenuDiscount.contains(user.getDate())) {
            return weekendsDiscount(discountHistory, menus);
        }
        return weekdaysDiscount(discountHistory,menus);
    }

    private static DiscountHistory weekdaysDiscount(DiscountHistory discountHistory,List<Menus> menus) {
        int totalDiscount = 0;
        for(Menus menu : menus) {
            if (menu.getCategory() == "디저트") {
                totalDiscount += 2023;
            }
        }
        discountHistory.updateWeekdays(totalDiscount);
        return discountHistory;
    }

    private static DiscountHistory weekendsDiscount(DiscountHistory discountHistory, List<Menus> menus) {
        int totalDiscount = 0;
        for (Menus menu: menus) {
            if (menu.getCategory() == "메인") {
                totalDiscount += 2023;
            }
        }
        discountHistory.updateWeekend(totalDiscount);
        return discountHistory;
    }
}

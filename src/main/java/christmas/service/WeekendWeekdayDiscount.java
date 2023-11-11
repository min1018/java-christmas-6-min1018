package christmas.service;

import christmas.domain.Menus;
import christmas.domain.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WeekendWeekdayDiscount {
    private static final List<Integer> mainMenuDiscount = new ArrayList<>(Arrays.asList(1, 2, 8, 9, 15, 16, 22, 23, 29, 30));
    public static void whichDiscountAvailable(User user) {
        List<Menus> menus = user.getOrderedMenus();
        if (mainMenuDiscount.contains(user.getDate())) {
            weekendsDiscount(menus);
        }
        weekdaysDiscount(menus);
    }

    private static int weekdaysDiscount(List<Menus> menus) {
        int totalDiscount = 0;
        for(Menus menu : menus) {
            if (menu.getCategory() == "디저트") {
                totalDiscount += 2023;
            }
        }
        return totalDiscount;
    }

    private static int weekendsDiscount(List<Menus> menus) {
        int totalDiscount = 0;
        for (Menus menu: menus) {
            if (menu.getCategory() == "디저트") {
                totalDiscount += 2023;
            }
        }
        return totalDiscount;
    }
}

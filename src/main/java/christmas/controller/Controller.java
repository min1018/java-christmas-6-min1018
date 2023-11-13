package christmas.controller;

import christmas.domain.Menus;
import christmas.domain.User;
import christmas.service.BonusDiscount;
import christmas.service.DdayDiscount;
import christmas.service.SpecialDiscount;
import christmas.service.WeekendWeekdayDiscount;
import christmas.utils.DateException;
import christmas.utils.MenuException;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;

public class Controller {
    public static void run () {
        User user = userReservationSetting();
        user = orderHistoryBeforeDiscount(user);
        showDiscountHistory(user);
    }
    private static User userReservationSetting() {
        InputView.introducePlanner();
        User user = new User(reservationDateSetting(), reservationMenuSetting());
        return user;
    }
     private static int reservationDateSetting() {
        int date = 0;
        try {
            date = InputView.requestDate();
            DateException.isDateValid(date);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            date = reservationDateSetting();
        }
        return date;
    }

    private static List<Menus> reservationMenuSetting() {
        List<Menus> menus;
        try {
            String orders = InputView.requestMenu();
            menus = MenuException.isMenuValid(orders);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            menus = reservationMenuSetting();
        }
        return menus;
    }

    private static User orderHistoryBeforeDiscount(User user) {
        OutputView.printOrders(user);
        OutputView.printPaymentBeforeDiscount(user);
        if(user.getTotalOrderBeforeDiscount() > 10000) {
            user = applyingDiscount(user);
        }
        return user;
    }
    private static User applyingDiscount(User user) {
        user = ApplyDiscount(user);
        return user;
    }

    private static void showDiscountHistory(User user) {
        OutputView.printBonusDiscount(user);
        OutputView.printDiscountHistory(user);
        OutputView.printTotalDiscount(user);
        OutputView.printPaymentAfterDiscount(user);
        OutputView.printBadge(user);
    }
    private static User ApplyDiscount(User user) {
       user = DdayDiscount.calcDday(user);
       user = BonusDiscount.isAvaliable(user);
       user = SpecialDiscount.isAvailable(user);
       user = WeekendWeekdayDiscount.whichDiscountAvailable(user);
       return user;
    }
}

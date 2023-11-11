package christmas.controller;

import christmas.domain.Menus;
import christmas.domain.User;
import christmas.utils.DateException;
import christmas.utils.MenuException;
import christmas.view.InputView;

import java.util.List;

public class Controller {
    public static void run () {
        userReservationSetting();

    }
    private static User userReservationSetting() {
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

}

package christmas.view;

import christmas.domain.DiscountHistory;
import christmas.domain.Menus;
import christmas.domain.User;

import java.util.List;

public class OutputView {
    public static final String ORDER_MENU = "<주문 메뉴>";
    public static final String BEFORE_DISCOUNT = "<할인 전 총주문 금액>";
    public static final String BONUS_MENU = "<증정 메누>";
    public static final String DETAIL_DISCOUNT = "<혜택 내역>";
    public static final String BONUS_CHAMPAGNE = "샴페인 1개";
    public static final String CHRISTMAS_DDAY = "크리스마스 디데이 할인: -";
    public static final String WEEKDAY_DISCOUNT = "평일 할인: -";
    public static final String WEEKEND_DISCOUNT = "주말 할인: -";
    public static final String SPECIAL_DISCOUNT = "특별 할인: -";
    public static final String BONUS_DISCOUNT = "증정 이벤트: -" ;
    public static final String WON = "원";
    public static final String ANNOUNCE_DISCOUNT = "<총혜택 금액>";
    public static final String ANNOUNCE_AFTER_DISCOUNT = "<할인 후 예상 결제 금액>";
    public static final String ANNOUNCE_BADGE = "<12월 이벤트 배지>";

    static public void printOrders(User user) {
        System.out.println(ORDER_MENU);
        List<Menus> menus = user.getOrderedMenus();
        for (Menus menu : menus) {
            System.out.println(menu.getMenuName() + " " +menu.getCount()+"개");
        }
        System.out.println();
    }

    static public void printPaymentBeforeDiscount(User user) {
        System.out.println(BEFORE_DISCOUNT);
        System.out.println(user.getTotalOrderBeforeDiscount()+"원"+"\n");
    }

    static public void printBonusDiscount(DiscountHistory discountHistory) {
        System.out.println(BONUS_MENU);
        if (discountHistory.getBonusDiscount() == 0) {
            System.out.println("없음");
        }
        if (discountHistory.getBonusDiscount() != 0) {
            System.out.println(BONUS_CHAMPAGNE+"\n");
        }
    }
    static public void printDiscountHistory(DiscountHistory history) {
        System.out.println(DETAIL_DISCOUNT);
        System.out.println(CHRISTMAS_DDAY + history.getDdayDiscount()+WON);
        printWeekendOrWeekday(history);
        System.out.println(SPECIAL_DISCOUNT + history.getSpecialDiscount()+WON);
        System.out.println(BONUS_DISCOUNT + history.getBonusDiscount()+WON+"\n");

    }
    static public void printWeekendOrWeekday(DiscountHistory history) {
        if(history.getWeekdayDiscount() == 0) {
            System.out.println(WEEKEND_DISCOUNT + history.getWeekendDiscount()+WON);
        }
        if(history.getWeekdayDiscount() != 0) {
            System.out.println(WEEKDAY_DISCOUNT +history.getWeekdayDiscount()+WON);
        }
    }

    static public void printTotalDiscount(DiscountHistory history) {
        System.out.println(ANNOUNCE_DISCOUNT);
        System.out.println("-"+history.getTotalDiscount()+WON+"\n");
    }
    static public void printPaymentAfterDiscount(DiscountHistory history, User user) {
        System.out.println(ANNOUNCE_AFTER_DISCOUNT);
        System.out.println(user.getTotalOrderBeforeDiscount() - history.getTotalDiscount()+WON+"\n");
    }
    static public void printBadge(User user) {
        System.out.println(ANNOUNCE_BADGE);
        System.out.println(user.getUserBadge());
    }
}

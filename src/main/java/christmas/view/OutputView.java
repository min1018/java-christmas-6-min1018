package christmas.view;

import christmas.domain.Menus;
import christmas.domain.User;

import java.text.DecimalFormat;
import java.util.List;

public class OutputView {
    public static final String EVENT_START = "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n";
    public static final String ORDER_MENU = "<주문 메뉴>";
    public static final String BEFORE_DISCOUNT = "<할인 전 총주문 금액>";
    public static final String BONUS_MENU = "<증정 메뉴>";
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
        System.out.println("12월 "+user.getDate()+EVENT_START);
        System.out.println(ORDER_MENU);
        List<Menus> menus = user.getOrderedMenus();
        for (Menus menu : menus) {
            System.out.println(menu.getMenuName() + " " +menu.getCount()+"개");
        }
        System.out.println();
    }

    static public void printPaymentBeforeDiscount(User user) {
        System.out.println(BEFORE_DISCOUNT);
        System.out.println(formatNumber(user.getTotalOrderBeforeDiscount())+"원"+"\n");
    }

    static public void printBonusDiscount(User user) {
        System.out.println(BONUS_MENU);
        if (user.getDiscountAmountForOption("증정") == 0) {
            System.out.println("없음\n");
        }
        if (user.getDiscountAmountForOption("증정") != 0) {
            System.out.println(BONUS_CHAMPAGNE+"\n");
        }
    }
    static public void printDiscountHistory(User user) {
        System.out.println(DETAIL_DISCOUNT);
        if (user.isUserDiscountEmpty()) {
            System.out.println("없음\n");
        }
        if (!user.isUserDiscountEmpty()) {
            printDdayDiscount(user);
            printWeekendOrWeekday(user);
            printSpecialDiscount(user);
            printBonusDiscountAmount(user);
            System.out.println();
        }

    }
    static public void printDdayDiscount(User user) {
        if(user.getDiscountAmountForOption("디데이") != 0) {
            System.out.println(CHRISTMAS_DDAY + formatNumber(user.getDiscountAmountForOption("디데이")) +WON);
        }
    }
    static public void printWeekendOrWeekday(User user) {
        if(user.getDiscountAmountForOption("주말") != 0) {
            System.out.println(WEEKEND_DISCOUNT + formatNumber(user.getDiscountAmountForOption("주말"))+WON);
        }
        if(user.getDiscountAmountForOption("평일") != 0) {
            System.out.println(WEEKDAY_DISCOUNT + formatNumber(user.getDiscountAmountForOption("평일"))+WON);
        }
    }
    static public void printSpecialDiscount(User user) {
        if(user.getDiscountAmountForOption("특별") != 0) {
            System.out.println(SPECIAL_DISCOUNT + formatNumber(user.getDiscountAmountForOption("특별"))+WON);
        }
    }
    static public void printBonusDiscountAmount(User user) {
        if(user.getDiscountAmountForOption("증정") != 0) {
            System.out.println(BONUS_DISCOUNT + formatNumber(user.getDiscountAmountForOption("증정"))+WON);
        }
    }

    static public void printTotalDiscount(User user) {
        System.out.println(ANNOUNCE_DISCOUNT);
        System.out.println("-"+formatNumber(user.getTotalDiscount())+WON+"\n");
    }
    static public void printPaymentAfterDiscount(User user) {
        System.out.println(ANNOUNCE_AFTER_DISCOUNT);
        System.out.println(formatNumber(user.getTotalOrderBeforeDiscount() - user.getTotalDiscount()+25000) +WON+"\n");
    }
    static public void printBadge(User user) {
        System.out.println(ANNOUNCE_BADGE);
        System.out.println(user.whichBadge(user.getTotalDiscount()));
    }

    static public String formatNumber(long number) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(number);
    }
}

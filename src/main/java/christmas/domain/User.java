package christmas.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int date;
    private List<Menus> orderedMenus;
    private List<DiscountOption> userDiscount;


    public User(int date, List<Menus> orderedMenus) {
        this.date = date;
        this.orderedMenus = orderedMenus;
        this.userDiscount = new ArrayList<>();
    }

    public int getDate() {
        return date;
    }
    public List<Menus> getOrderedMenus (){
        return orderedMenus;
    }
    public int getTotalOrderBeforeDiscount() {
        orderedMenus = getOrderedMenus();
        int totalOrderBeforeDiscount = 0;
        for(Menus menu : orderedMenus) {
            totalOrderBeforeDiscount += menu.getCount() * menu.getCost();
        }
        return totalOrderBeforeDiscount;
    }

    public String whichBadge(int totalDiscount) {
        Badge badge = Badge.valueOf(totalDiscount);
        return badge.getBadgeName();
    }

    public void moreDiscount(int discountAmount, String whichDiscount) {
        DiscountOption discountOption = DiscountOption.fromString(whichDiscount);
        discountOption.changeDiscountAmount(discountAmount);
        userDiscount.add(discountOption);
    }
    public boolean isUserDiscountEmpty() {
        return userDiscount.isEmpty();
    }

    public int getTotalDiscount() {
        int totalDiscount = 0;
        for (DiscountOption discount: userDiscount) {
            totalDiscount += discount.getDiscountAmount();
        }
        return totalDiscount;
    }

    public int getDiscountAmountForOption(String targetOption) {
        DiscountOption targetDiscount = DiscountOption.fromString(targetOption);
        return targetDiscount.getDiscountAmount();
    }

}

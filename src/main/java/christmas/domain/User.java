package christmas.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int date;
    private List<Menus> orderedMenus;
    private int totalOrderBeforeDiscount;

    private List<DiscountOption> userDiscount;
    private Badge userBadge;

    public User(int date, List<Menus> orderedMenus) {
        this.date = date;
        this.orderedMenus = orderedMenus;
        for(Menus menu : orderedMenus) {
            totalOrderBeforeDiscount += menu.getCount() * menu.getCost();
        }
        this.totalOrderBeforeDiscount = totalOrderBeforeDiscount;
        this.userDiscount = new ArrayList<>();
    }

    public int getDate() {
        return date;
    }
    public List<Menus> getOrderedMenus (){
        return orderedMenus;
    }
    public int getTotalOrderBeforeDiscount() {
        return totalOrderBeforeDiscount;
    }

    public String whichBadge(int totalDiscount) {
        this.userBadge = Badge.valueOf(totalDiscount);
        return userBadge.getBadgeName();
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

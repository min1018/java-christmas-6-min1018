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
    public Badge getUserBadge() {
        return userBadge;
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

    public Badge whichBadge(int totalDiscount) {
        this.userBadge = Badge.valueOf(totalDiscount);
        return userBadge;
    }


    public void moreDiscount(int discountAmount, String whichDiscount) {
        DiscountOption discountOption = DiscountOption.fromString(whichDiscount);
        discountOption.changeDiscountAmount(discountAmount);
        userDiscount.add(discountOption);
    }

    public List<Menus> orderedMenus(String menuName, int count) {
        Menus menu = Menus.valueOf(menuName);
        menu.updateCount(count);
        orderedMenus.add(menu);
        return orderedMenus;
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

package christmas.domain;


import java.util.List;

public class User {
    private int date;
    private List<Menus> orderedMenus;
    private int totalOrderBeforeDiscount;

    private List<DiscountOption> userDiscount;
    private Badge userBadge;

    public User(int date, List<Menus> orderedMenus) {
        date = this.date;
        orderedMenus = this.orderedMenus;
        for(Menus menu : orderedMenus) {
            totalOrderBeforeDiscount += menu.getCount() * menu.getCost();
        }
        totalOrderBeforeDiscount = this.totalOrderBeforeDiscount;
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

    public List<DiscountOption> moreDiscount(int discountAmount, String whichDiscount) {
        DiscountOption discountOption = DiscountOption.fromString(whichDiscount);
        discountOption.changeDiscountAmount(discountAmount);
        userDiscount.add(discountOption);
        return userDiscount;
    }

    public List<Menus> orderedMenus(String menuName, int count) {
        Menus menu = Menus.valueOf(menuName);
        menu.updateCount(count);
        orderedMenus.add(menu);
        return orderedMenus;
    }

    public int getTotalAmountMenu(List<Menus> menus) {
        int totalCount = 0;
        for (Menus menu : menus) {
            totalCount += menu.getCount();
        }
        return totalCount;
    }

}

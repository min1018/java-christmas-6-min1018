package christmas.domain;


import christmas.domain.Badge;

import java.util.List;

public class User {
    private int date;

    //보너스가 트루라면 무조건 샴페인을 증정 받은것으로 간주하고 값 출력
    private boolean bonusMenu;
    //이 두 평일 주말 할인 값이 0보다 크다면 평일 할인을 받은 것
    private List<Menus> orderedMenus;
    //total discount 에 대해서는 앞서 total Discount class 으 ㅣ함수들 가지고 와야
    //혹은 그냥 그거 그대로 가지고 오던가
    private int totalDiscount;

    public User(int date, List<Menus> orderedMenus) {
        date = this.date;
        orderedMenus = this.orderedMenus;
    }
    public List<Menus> getOrderedMenus (){
        return orderedMenus;
    }
    public List<Menus> orderedMenus(String menuName, int count) {
        Menus menu = Menus.updateCount(menuName, count);
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

    public int getTotalPayment(List<Menus> menus) {
        int totalPayment = 0;
        for(Menus menu: menus) {
            totalPayment += menu.getCount() * menu.getCost();
        }
        return totalPayment;
    }

    public boolean isBonusAvailable(int totalPayment) {
        if (totalPayment >= 120000) {
            return true;
        }
        return false;
    }
}

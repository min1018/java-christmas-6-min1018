package christmas.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public enum Menus {

    양송이수프("양송이수프", 6000, "애피타이저"),
    타파스("타파스", 5000, "애피타이저"),
    시저샐러드("시저샐러드", 8000, "애피타이저"),
    티본스테이크("티본스테이크",55000, "메인"),
    바베큐립("바비큐립", 54000, "메인"),
    해산물파스타("해산물파스타", 35000, "메인"),
    크리스마스파스타("크리스마스파스타", 25000, "메인"),
    초코케이크("초코케이크", 15000, "디저트"),
    아이스크림("아이스크림", 5000, "디저트"),
    제로콜라("제로콜라", 3000, "음료"),
    레드와인("레드와인", 60000, "음료"),
    샴페인("샴페인", 25000, "음료");

    private final String menuName;
    private final int cost;
    private final String category;
    private int count;

    private static final Map<String, Integer> menuCounts = new HashMap<>();

    Menus (String menuName, int cost, String category ) {
        this.menuName = menuName;
        this.cost = cost;
        this.category = category;
    }
    public String getMenuName() {
        return menuName;
    }
    public int getCost() {
        return cost;
    }
    public String getCategory() {
        return category;
    }
    public int getCount() {
        return menuCounts.getOrDefault(menuName, 0);
    }

    public void updateCount(int updateCount) {
        menuCounts.put(menuName, updateCount);
    }
    public static String getCateogoryByNames(String menuName) {
        return Arrays.stream(Menus.values())
                .filter(menu -> menu.menuName.equals(menuName))
                .findFirst()
                .map(menu -> menu.category)
                .orElse(null);
    }

}

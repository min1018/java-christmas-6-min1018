package christmas.domain;

import java.util.Arrays;

public enum Menus {

    SOUP("양송이수프", 6000, "애피타이저", 0),
    TAPAS("타파스", 5000, "애피타이저", 0),
    SALAD("시저샐러드", 8000, "애피타이저", 0),
    TBONE("티본스테이크",55000, "메인", 0),
    RIB("바비큐립", 54000, "메인", 0),
    SEAPASTA("해산물파스타", 35000, "메인", 0),
    CHRISTMASPASTA("크리스마스파스타", 25000, "메인", 0),
    CAKE("초코케이크", 15000, "디저트", 0),
    ICECREAM("아이스크림", 5000, "디저트", 0),
    ZEROCOKE("제로콜라", 3000, "음료", 0),
    REDWINE("레드와인", 60000, "음료", 0),
    CHAMPAGNE("샴페인", 25000, "음료", 0);

    private final String menuName;
    private final int cost;
    private final String category;
    private int count;

    Menus (String menuName, int cost, String category, int count ) {
        this.menuName = menuName;
        this.cost = cost;
        this.category = category;
        this.count = count;
    }
    public int getCost() {
        return cost;
    }
    public String getCategory() {
        return category;
    }
    public int getCount() {
        return count;
    }
    public static String getCateogoryByNames(String menuName) {
        return Arrays.stream(Menus.values())
                .filter(menu -> menu.menuName.equals(menuName))
                .findFirst()
                .map(menu -> menu.category)
                .orElse(null);
    }

    public static Menus updateCount(String menuName, int updateCount) {
        return Arrays.stream(Menus.values())
                .filter(menu -> menu.menuName.equals(menuName))
                .findFirst()
                .map(menu -> {
                    menu.count = updateCount;
                    return menu;
                })
                .orElse(null);
    }
}

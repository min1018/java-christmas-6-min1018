package christmas.utils;

import christmas.domain.Menus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class MenuException {

    static final String INVALID_ORDER = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
    public static List<Menus> isMenuValid(String menu) {
        isValidFormat(menu);
        List<Menus> menus = generateForm(menu);
        isAboveTwentyMenu(menus);
        isRepeatedMenu(menus);
        onlyDrinks(menus);
        return menus;
    }

    public static List<Menus> generateForm(String orders) {
        List<String> eachOrders = List.of(orders.split(","));

        List<Menus> menus = new ArrayList<>();
        for (String order: eachOrders) {
            String[] orderSet = order.split("-");
            isOnMenuBoard(orderSet[0]);
            isCountAboveZero(orderSet[1]);
            Menus menu = Menus.valueOf(orderSet[0]);
            menu.updateCount(parseInt(orderSet[1]));
            menus.add(menu);
        }
        return menus;
    }
    public static void isOnMenuBoard(String menuName) {
        if (Menus.getCateogoryByNames(menuName) == null){
            throw new IllegalArgumentException(INVALID_ORDER);
        }
    }
    public static void isCountAboveZero(String menuCount) {
        if (parseInt(menuCount) <= 0) {
            throw new IllegalArgumentException(INVALID_ORDER);
        }
    }
    public static void isAboveTwentyMenu(List<Menus> menus) {
        int totalOrder = 0;
        for (Menus menu: menus) {
            totalOrder += menu.getCount();
        }
        if (totalOrder > 20) {
            throw new IllegalArgumentException(INVALID_ORDER);
        }

    }

    public static void onlyDrinks(List<Menus> menus) {
        if (menus.stream().allMatch(menu -> "음료".equals(menu.getCategory()))) {
            throw new IllegalArgumentException(INVALID_ORDER);
        }
    }

    public static void isRepeatedMenu(List<Menus> menus) {
        if(menus.stream()
                .distinct()
                .collect(Collectors.toList()).size() != menus.size()) {
            throw new IllegalArgumentException(INVALID_ORDER);
        }
    }


    public static void isValidFormat(String input) {
        if (!validFormatCheck(input)) {
            throw new IllegalArgumentException(INVALID_ORDER);
        }
    }
    public static boolean validFormatCheck(String input) {
        // 정규표현식: 문자열-숫자,문자열-숫자,...
        String regex = "([가-힣a-zA-Z]+-\\d+,)*[가-힣a-zA-Z]+-\\d+";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        return matcher.matches();
    }

}

package christmas.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static final String INTRODUCE_PLANNER = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    public static final String RESERVATION_DATE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    public static final String DATE_MUST_INTEGER = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    public static final String ORDER_MENU = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

    public static void introducePlanner() {
        System.out.println(INTRODUCE_PLANNER);
    }
    public static int requestDate() {
        try {
            System.out.println(RESERVATION_DATE);
            int date = Integer.parseInt(Console.readLine());
            return date;
        } catch (NumberFormatException e){
            System.out.println(DATE_MUST_INTEGER);
            return requestDate();
        }
    }

    public static String requestMenu() {
        System.out.println(ORDER_MENU);
        String menus = Console.readLine();
        return menus;
    }


}

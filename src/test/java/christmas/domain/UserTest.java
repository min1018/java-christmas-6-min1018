package christmas.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import christmas.utils.MenuException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class UserTest {

    @Test
    @DisplayName("User속의 예약날짜를 접근할 수 있다")
    void reservationDateTest() {
        List<Menus> menus;
        String orders = "타파스-1,제로콜라-1";
        menus = MenuException.generateForm(orders);
        User user = new User(24, menus);
        assertThat(user.getDate()).isEqualTo(24);
    }
    @Test
    @DisplayName("타파스와 제로콜라 주문시 할인 전의 금액은 8500원이다.")
    void Test() {
        List<Menus> menus;
        String orders = "타파스-1,제로콜라-1";
        menus = MenuException.generateForm(orders);
        User user = new User(24, menus);
        assertThat(user.getTotalOrderBeforeDiscount()).isEqualTo(8500);
    }
    @Test
    @DisplayName("메뉴판에 없는 메뉴를 주문할 시 에러를 발생시킨다.")
    void notOnMenuTest() {
        List<Menus> menus;
        String orders = "버블티-1,제로콜라-1";
        assertThatThrownBy(() -> MenuException.generateForm(orders))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("주문 수량이 0일 시 에러를 발생시킨다.")
    void orderNotAboveTest() {
        List<Menus> menus;
        String orders = "타파스-0,제로콜라-1";
        assertThatThrownBy(() -> MenuException.generateForm(orders))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("user 객체에서 특별할인에 접근할 시 1000원을 반환한다.")
    void discountListTest() {
        List<Menus> menus;
        String orders = "타파스-1,제로콜라-1";
        menus = MenuException.generateForm(orders);
        User user = new User(24, menus);

        user.moreDiscount(1000,"특별");
        assertThat(user.getDiscountAmountForOption("특별")).isEqualTo(1000);
    }
    @Test
    @DisplayName("user 객체에서 총 할인 금액을 반환한다.")
    void totalDiscountAmountTest() {
        List<Menus> menus;
        String orders = "타파스-1,제로콜라-1";
        menus = MenuException.generateForm(orders);
        User user = new User(24, menus);

        user.moreDiscount(1000,"특별");
        user.moreDiscount(2023,"주말");
        assertThat(user.getTotalDiscount()).isEqualTo(3023);
    }

}

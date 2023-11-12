package christmas.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MenusTest {
    @Test
    @DisplayName("초코케이크를 입력할 시 디저트를 반환한다")
    void dessertTest() {
        assertThat(Menus.getCateogoryByNames("초코케이크")).isEqualTo("디저트");
    }
    @Test
    @DisplayName("해산물파스타를 2개 구매한 경우 count 항목이 2를 반환해야한다")
    void countUpdateTest() {
        Menus menu = Menus.valueOf("해산물파스타");
        menu.updateCount(2);
        assertThat(menu.getCount()).isEqualTo(2);
    }
}

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
}

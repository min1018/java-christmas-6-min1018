package christmas.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class DiscountOptionTest {

    @Test
    @DisplayName("주말을 입력 받을 시 해당하는 DiscountOption을 반환해야 합니다")
    void weekendTest() {
        assertThat(DiscountOption.fromString("주말")).isEqualTo(DiscountOption.weekendDiscount);
    }
    @Test
    @DisplayName("특별을 입력 받을 시 해당하는 SpecialOption을 반환해야 합니다")
    void specialTest() {
        assertThat(DiscountOption.fromString("특별")).isEqualTo(DiscountOption.specialDiscount);
    }
    @Test
    @DisplayName("주말을 입력 받을 시 해당하는 DiscountOption을 반환해야 합니다")
    void specialAmountEqualTest() {
        DiscountOption discountOption = DiscountOption.fromString("특별");
        discountOption.changeDiscountAmount(1000);

        assertThat(discountOption.getDiscountAmount()).isEqualTo(1000);
    }
}

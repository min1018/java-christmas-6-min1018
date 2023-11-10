package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import christmas.domain.Badge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BadgeTest {
    @Test
    @DisplayName("5100원의 혜택을 받았을 시 별 뱃지를 출력해야한다.")
    void StarBadgeTest() {
        assertThat(Badge.valueOf(5100)).isEqualTo(Badge.Star);
    }
    @Test
    @DisplayName("1100원의 혜택을 받았을 시 트리 뱃지를 출력해야한다.")
    void TreeTest() {
        assertThat(Badge.valueOf(11000)).isEqualTo(Badge.Tree);
    }
    @Test
    @DisplayName("2100원의 혜택을 받았을 시 산타 뱃지를 출력해야한다.")
    void SantaTest() {
        assertThat(Badge.valueOf(21000)).isEqualTo(Badge.Santa);
    }
}

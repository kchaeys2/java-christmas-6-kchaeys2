package model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BadgeTest {
    @Test
    void 배지반환검증(){
        Integer discount = 20000;

        String badge = Badge.findByMinPrice(discount);
        assertThat(badge).isEqualTo("산타");
    }
}
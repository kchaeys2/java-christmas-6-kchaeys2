package model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class DateTest {
    @Test
    void 날짜가숫자만있는지확인(){
        String input = "123g";

        assertThatThrownBy(() -> new Date(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 숫자검증1_31(){
        String input = "32";
        assertThatThrownBy(() -> new Date(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 크리스마스할인금액반환(){
        Date date = new Date("25");

        assertThat(date.discountChrismas())
                .isEqualTo(3400);
    }
    @Test
    void 크리스마스할인불가(){
        Date date = new Date("28");

        assertThatThrownBy(date::discountChrismas)
                .isInstanceOf(IllegalStateException.class);
    }
    @Test
    void 평일인지주말인지확인(){
        Date date = new Date("28");

        assertThat(date.checkWeek())
                .isEqualTo("평일");
    }
    @Test
    void 별유무반환(){
        Date date = new Date("25");

        assertThat(date.checkStar()).isEqualTo(true);
    }
}
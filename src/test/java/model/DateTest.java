package model;

import org.junit.jupiter.api.Test;

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

}
package model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MenuTest {
    @Test
    void 사용자값ENUM으로변경(){
        Menu menu = Menu.findByName("제로콜라");

        assertThat(menu).isEqualTo(Menu.ZEROCOLA);
    }

}
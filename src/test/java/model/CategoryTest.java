package model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CategoryTest {
    @Test
    void 몌뉴가어떤카테고리에포함되어있는지반환(){
        Category category = Category.findByMenu(Menu.BARBECUE_RIBS);

        assertThat(category).isEqualTo(Category.MAIN);
    }
}
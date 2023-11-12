package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Category {
    EMPTY(new ArrayList<>()),
    APPETIZER(Arrays.asList(Menu.BUTTONMUSHROOM_SOUP,Menu.TAPAS,Menu.CAESAR_SALAD)),
    MAIN(Arrays.asList(Menu.T_BONE_STEAK,Menu.BARBECUE_RIBS,Menu.SEAFOOD_PASTA)),
    DESSERT(Arrays.asList(Menu.CHCOLATE_CAKE,Menu.ICE_CREAM)),
    BEVERAGE(Arrays.asList(Menu.ZEROCOLA,Menu.REDWINE,Menu.CHAMPAGNE));
    private final List<Menu> menus;
    Category(List<Menu> menus){
        this.menus = menus;
    }
    public static Category findByMenu(Menu menu){
        return Arrays.stream(Category.values())
                .filter(category -> category.hasMenu(menu))
                .findAny()
                .orElse(EMPTY);
    }
    public boolean hasMenu(Menu menu){
        return menus.stream()
                .anyMatch(m -> m == menu);
    }
}

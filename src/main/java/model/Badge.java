package model;

public enum Badge {
    EMPTY("없음", 0),
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000);
    private final String name;
    private final Integer minPrice;

    Badge(String name, Integer minPrice) {
        this.name = name;
        this.minPrice = minPrice;
    }

    public static String findByMinPrice(Integer discount) {
        if (discount >= STAR.minPrice && discount < TREE.minPrice) {
            return STAR.name;
        } else if (discount >= TREE.minPrice && discount < SANTA.minPrice) {
            return TREE.name;
        } else if (discount >= SANTA.minPrice) {
            return SANTA.name;
        }
        return EMPTY.name;
    }
}

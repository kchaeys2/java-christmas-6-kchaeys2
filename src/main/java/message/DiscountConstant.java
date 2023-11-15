package message;

public enum DiscountConstant {
    POSSIBLE(10000),
    NO_DISCOUNT(0),
    CHRISMAS_INIT(1000),
    CHRISMAE_RAISE(100),
    SPECIAL(1000),
    GIFT(120000),
    WEEKS(2023);
    private final Integer discount;
    DiscountConstant(Integer discount){
        this.discount = discount;
    }

    public Integer getDiscount() {
        return discount;
    }
}

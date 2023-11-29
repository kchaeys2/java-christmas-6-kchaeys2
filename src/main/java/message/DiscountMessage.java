package message;

public enum DiscountMessage {
    CHRISMAS("크리스마스 디데이 할인: "),
    SPECIAL("특별 할인: "),
    WEEK("평일 할인: "),
    WEEKEND("주말 할인: "),
    GIFT("증정 이벤트: ");
    private final String msg;

    DiscountMessage(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}

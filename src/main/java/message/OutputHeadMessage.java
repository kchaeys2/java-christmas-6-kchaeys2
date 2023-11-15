package message;

public enum OutputHeadMessage {
    STARTAG("<"),
    ORDER_MENU("주문 메뉴"),
    TOTALPRICE("할인 전 총주문 금액"),
    GIFT("증정 메뉴"),
    DISCOUNT_CONTENT("혜택 내역"),
    TOTAL_DISCOUNT("총혜택 금액"),
    REALPRICE("할인 후 예상 결제 금액"),
    BADGE("12월 이벤트 배지"),
    ENDTAG(">");
    private final String msg;
    OutputHeadMessage(String msg){
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}

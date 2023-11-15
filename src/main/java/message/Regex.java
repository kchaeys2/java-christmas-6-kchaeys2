package message;

public enum Regex {
    IS_NUMBER("^[\\d]*$"),
    ORDER_SEPARATOR("-|,"),
    THOUSAND("%,d");
    private final String regex;
    Regex(String regex){
        this.regex = regex;
    }


    public String getRegex() {
        return regex;
    }
}

package model;

import java.util.regex.Pattern;

public class Date {
    private final Integer date;
    public Date(String date){
        Integer validationFormat = validateFormat(date);
        this.date = validateRange(validationFormat);
    }
    private Integer validateFormat(String date){
        if(Pattern.matches("^[\\\\d]*$",date)){
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
        return Integer.parseInt(date);
    }
    private Integer validateRange(Integer date){
        if (date < 1 || date > 31) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
        return date;
    }
}

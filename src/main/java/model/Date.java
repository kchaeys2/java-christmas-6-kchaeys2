package model;

import java.util.regex.Pattern;

public class Date {
    private final Integer date;
    public Date(String date){
        this.date = validateFormat(date);
    }
    private Integer validateFormat(String date){
        if(Pattern.matches("^[\\\\d]*$",date)){
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
        return Integer.parseInt(date);
    }
}

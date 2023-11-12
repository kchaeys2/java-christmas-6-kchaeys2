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
    public Integer discountChrismas(){
        if (date < 1 || date > 25){
            throw new IllegalStateException("크리스마스 할인 적용 불가");
        }
        return 1000+(date-1)*100;
    }
    public String checkWeek(){
        if (date%7 == 1 || date%7 == 2){
            return "주말";
        }
        return "평일";
    }
    public Boolean checkStar(){
        return date % 7 == 3 || date == 25;
    }
}

package model;

import message.DiscountConstant;
import message.ErrorMessage;
import message.JudgmentConstant;
import message.Regex;

import java.util.Objects;

public class Date {
    private final Integer date;

    public Date(String date) {
        Integer validationFormat = validateFormat(date);
        this.date = validateRange(validationFormat);
    }

    private Integer validateFormat(String date) {
        if (!date.matches(Regex.IS_NUMBER.getRegex())) {
            throw new IllegalArgumentException(ErrorMessage.DATE_ERROR.getMsg());
        }
        return Integer.parseInt(date);
    }

    private Integer validateRange(Integer date) {
        if (date < JudgmentConstant.DATE_MIN_SIZE.getNumber() || date > JudgmentConstant.DATE_MAX_SIZE.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.DATE_ERROR.getMsg());
        }
        return date;
    }

    public Integer discountChrismas() {
        if (date < JudgmentConstant.DATE_MIN_SIZE.getNumber() || date > JudgmentConstant.CHRISMAS.getNumber()) {
            return DiscountConstant.NO_DISCOUNT.getDiscount();
        }
        return DiscountConstant.CHRISMAS_INIT.getDiscount() + (date - 1) * DiscountConstant.CHRISMAE_RAISE.getDiscount();
    }

    public String checkWeek() {
        boolean isFriday = isDay(JudgmentConstant.FRIDAY.getNumber());
        boolean isSaturday = isDay(JudgmentConstant.SATURAY.getNumber());
        if (isFriday || isSaturday) {
            return "주말";
        }
        return "평일";
    }

    public Boolean checkStar() {
        boolean isSunday = isDay(JudgmentConstant.SATURAY.getNumber());
        boolean isChrismas = Objects.equals(date, JudgmentConstant.CHRISMAS.getNumber());
        return isSunday || isChrismas;
    }

    private Boolean isDay(Integer day) {
        return date % JudgmentConstant.WEEK_UNIT.getNumber() == day;
    }
}

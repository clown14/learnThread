package com.atguigu.interview.thread.enums;

/**
 * @program: Thread
 * @author: onion
 * @create: 2020-10-10 14:23
 **/

public enum CountryEnum {
    ONE(1,"齐"),TWO(2,"楚") ,THREE(3,"燕"), FOUR(4,"赵") ,FIVE(5,"魏"), SIX(6,"韩");


    private Integer retCode;
    private String retMessage;

    CountryEnum(Integer retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }

    public static CountryEnum forEach_CountryEnum(int index) {
        CountryEnum[] myAray = CountryEnum.values();
        for (CountryEnum element : myAray
        ) {
            if (index == element.retCode) {
                return element;
            }
        }
        return null;
    }

    public Integer getRetCode() {
        return retCode;
    }

    public void setRetCode(Integer retCode) {
        this.retCode = retCode;
    }

    public String getRetMessage() {
        return retMessage;
    }

    public void setRetMessage(String retMessage) {
        this.retMessage = retMessage;
    }
}

    
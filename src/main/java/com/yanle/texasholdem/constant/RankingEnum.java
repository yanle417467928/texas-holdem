package com.yanle.texasholdem.constant;

/**
 * @Description: 牌型枚举
 * @Author Richard
 * @Date 2018/6/5 17:22
 */public enum RankingEnum {
    HIGH_CARD("高牌", 100),
    ONE_PAIR("一对", 200),
    TWO_PAIR("两对", 300),
    THREE_OF_THE_KIND("三条", 400),
    STRAIGHT("顺子", 500),
    FLUSH("同花", 600),
    FULL_HOUSE("葫芦", 700),
    FOUR_OF_THE_KIND("四条", 800),
    STRAIGHT_FLUSH("同花顺", 900),
    ROYAL_FLUSH("皇家同花顺", 1000);

    private String type;
    private int priority;

    RankingEnum(String type, int priority) {
        this.type = type;
        this.priority = priority;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}

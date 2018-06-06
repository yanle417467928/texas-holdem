package com.yanle.texasholdem.constant;

/**
 * @Description: 扑克花色枚举
 * @Author Richard
 * @Date 2018/6/5 16:49
 */
public enum PokerColorEnum {
    /**
     * 红桃
     */
    HEART("A"),
    /**
     * 方片儿
     */
    DIAMOND("B"),
    /**
     * 黑桃
     */
    SPADE("C"),
    /**
     * 梅花儿
     */
    CLUB("D");

    private String name;

    PokerColorEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

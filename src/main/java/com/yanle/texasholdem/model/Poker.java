package com.yanle.texasholdem.model;

import com.yanle.texasholdem.constant.PokerColorEnum;
import com.yanle.texasholdem.constant.PokerNumEnum;

/**
 * @Description: 单张扑克牌模型
 * @Author Richard
 * @Date 2018/6/5 16:55
 */
public class Poker implements Comparable<Poker> {

    /**
     * 扑克花色
     */
    private PokerColorEnum color;
    /**
     * 扑克点数
     */
    private PokerNumEnum num;

    public Poker(PokerColorEnum color, PokerNumEnum num) {
        this.color = color;
        this.num = num;
    }

    public PokerColorEnum getColor() {
        return color;
    }

    public void setColor(PokerColorEnum color) {
        this.color = color;
    }

    public PokerNumEnum getNum() {
        return num;
    }

    public void setNum(PokerNumEnum num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Poker poker = (Poker) o;
        if (this.color.getName() != poker.color.getName()) return false;
        return this.num.getNumber() == poker.num.getNumber();
    }

    @Override
    public int hashCode() {
        return this.color.ordinal() + this.num.getNumber();
    }

    @Override
    public String toString() {
        return this.color.getName() + this.num.getNumber();
    }


    public int compareTo(Poker o) {
        int selfNumber = this.num.getNumber();
        int otherNumber = o.num.getNumber();
        if(selfNumber<otherNumber){
            return 1;
        }
        if (selfNumber > otherNumber) {
            return -1;
        }
        return 0;
    }


}

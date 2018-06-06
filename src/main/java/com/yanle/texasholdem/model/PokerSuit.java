package com.yanle.texasholdem.model;

import com.yanle.texasholdem.constant.PokerColorEnum;
import com.yanle.texasholdem.constant.PokerNumEnum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @Description: 整套扑克牌
 * @Author Richard
 * @Date 2018/6/5 17:17
 */
public class PokerSuit {
    private List<Poker> pokers;
    private Random random;

    public PokerSuit() {
        this.random = new Random();
        this.init();
    }

    /**
     * 初始化一副扑克牌，并打乱顺序
     */
    private void init() {
        this.pokers = new ArrayList<Poker>();
        for (PokerColorEnum colorEnum : PokerColorEnum.values()) {
            for (PokerNumEnum numEnum : PokerNumEnum.values()) {
                pokers.add(new Poker(colorEnum, numEnum));
            }
        }
        Collections.shuffle(this.pokers);
    }

    public int getSize() {
        return this.pokers.size();
    }

    public Poker dispatch() {
        return pokers.remove(random.nextInt(pokers.size()));
    }
}

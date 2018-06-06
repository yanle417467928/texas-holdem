package com.yanle.texasholdem.model.comparing;


import com.yanle.texasholdem.model.Player;

import java.util.Map;

/**
 * @Description: 一对的大小比较(先比对子, 再比三个单张)
 * @Author Richard
 * @Date 2018/6/6 08:38
 */
public class OnePairComparingImpl extends AbstractComparing {

    public int compare(Player o1, Player o2) {
        Map<Integer, Integer> p1CardMap = o1.getPokerNumCountMap();
        Map<Integer, Integer> p2CardMap = o2.getPokerNumCountMap();

        return this.pairComparing(p1CardMap, p2CardMap, 2, 2);
    }

}

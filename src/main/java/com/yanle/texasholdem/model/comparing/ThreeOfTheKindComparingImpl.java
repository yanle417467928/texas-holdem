package com.yanle.texasholdem.model.comparing;


import com.yanle.texasholdem.model.Player;

import java.util.Map;

/**
 * @Description:  三条的大小比较(直接比较三条)
 * @Author Richard
 * @Date 2018/6/6 08:38
 */
public class ThreeOfTheKindComparingImpl extends AbstractComparing {

    public int compare(Player o1, Player o2) {
        Map<Integer, Integer> p1CardMap = o1.getPokerNumCountMap();
        Map<Integer, Integer> p2CardMap = o2.getPokerNumCountMap();

        return this.multiComparing(p1CardMap, p2CardMap, 3);
    }

}

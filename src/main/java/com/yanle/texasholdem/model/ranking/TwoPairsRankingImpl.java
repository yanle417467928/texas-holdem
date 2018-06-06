package com.yanle.texasholdem.model.ranking;


import com.yanle.texasholdem.constant.RankingEnum;
import com.yanle.texasholdem.model.Player;

import java.util.Iterator;
import java.util.Map;

/**
 * @Description: 解析玩家手中的牌是不是两对(2 + 2 + 1)
 * @Author Richard
 * @Date 2018/6/5 17:38
 */
public class TwoPairsRankingImpl extends AbstractRanking {

    protected RankingResult doResolve(Player player) {

        RankingResult result = null;
        Map<Integer, Integer> rankCount = player.getPokerNumCountMap();

        boolean hasTwo = false;

        if (rankCount.size() == 3) {
            Iterator<Map.Entry<Integer, Integer>> it = rankCount.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, Integer> next = it.next();
                if (next.getValue() == 2 || next.getValue() == 1) {
                    hasTwo = true;
                    break;
                }
            }
        }

        if (hasTwo) {
            result = new RankingResult();
            result.setRankingEnum(RankingEnum.TWO_PAIR);
        }

        return result;
    }

}

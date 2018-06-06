package com.yanle.texasholdem.model.ranking;


import com.yanle.texasholdem.constant.RankingEnum;
import com.yanle.texasholdem.model.Player;

import java.util.Iterator;
import java.util.Map;

/**
 * @Description:  解析玩家手中的牌是不是一对(2+1+1+1)
 * @Author Richard
 * @Date 2018/6/5 17:38
 */
public class OnePairRankingImpl extends AbstractRanking {

    protected RankingResult doResolve(Player player) {

        RankingResult result = null;
        Map<Integer, Integer> rankCount = player.getPokerNumCountMap();

        boolean hasOne = false;

        if (rankCount.size() == 4) {
            Iterator<Map.Entry<Integer, Integer>> it = rankCount.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, Integer> next = it.next();
                if (next.getValue() == 2 || next.getValue() == 1) {
                    hasOne = true;
                    break;
                }
            }
        }

        if (hasOne) {
            result = new RankingResult();
            result.setRankingEnum(RankingEnum.ONE_PAIR);
        }

        return result;
    }

}

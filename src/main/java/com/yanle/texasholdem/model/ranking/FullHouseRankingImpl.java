package com.yanle.texasholdem.model.ranking;


import com.yanle.texasholdem.constant.RankingEnum;
import com.yanle.texasholdem.model.Player;

import java.util.Iterator;
import java.util.Map;

/**
 * @Description:  解析玩家手中的牌是不是三条+一对
 * @Author Richard
 * @Date 2018/6/5 17:38
 */
public class FullHouseRankingImpl extends AbstractRanking {

    protected RankingResult doResolve(Player player) {

        RankingResult result = null;

        boolean isFullHouse = false;
        Map<Integer, Integer> rankCount = player.getPokerNumCountMap();

        if (rankCount.size() == 2) {
            Iterator<Map.Entry<Integer, Integer>> it = rankCount.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, Integer> next = it.next();
                if (next.getValue() == 2 || next.getValue() == 3) {
                    isFullHouse = true;
                    break;
                }
            }
        }

        if (isFullHouse) {
            result = new RankingResult();
            result.setRankingEnum(RankingEnum.FULL_HOUSE);
        }

        return result;
    }

}

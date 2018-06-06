package com.yanle.texasholdem.model.ranking;


import com.yanle.texasholdem.constant.Constants;
import com.yanle.texasholdem.constant.RankingEnum;
import com.yanle.texasholdem.model.Player;

import java.util.Iterator;
import java.util.Map;

/**
 * @Description:  解析玩家手中的牌是不是四条(四张连续相同的牌)
 * @Author Richard
 * @Date 2018/6/5 17:38
 */
public class FourOfTheKindRankingImpl extends AbstractRanking {

    protected RankingResult doResolve(Player player) {

        RankingResult result = null;
        Map<Integer, Integer> rankCount = player.getPokerNumCountMap();

        boolean hasFour = false;

        Iterator<Map.Entry<Integer, Integer>> it = rankCount.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue() == Constants.HAND_CARD_NUMBERS - 1) {
                hasFour = true;
                break;
            }
        }

        if (hasFour) {
            result = new RankingResult();
            result.setRankingEnum(RankingEnum.FOUR_OF_THE_KIND);
        }

        return result;
    }

}

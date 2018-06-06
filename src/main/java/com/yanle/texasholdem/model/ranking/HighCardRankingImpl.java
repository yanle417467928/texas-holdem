package com.yanle.texasholdem.model.ranking;


import com.yanle.texasholdem.constant.Constants;
import com.yanle.texasholdem.constant.RankingEnum;
import com.yanle.texasholdem.model.Player;
import com.yanle.texasholdem.model.Poker;

import java.util.List;
import java.util.Map;

/**
 * @Description:  解析玩家手中的牌是不是单牌(1+1+1+1+1)
 * @Author Richard
 * @Date 2018/6/5 17:38
 */
public class HighCardRankingImpl extends AbstractRanking {

    protected RankingResult doResolve(Player player) {

        RankingResult result = null;
        Map<Integer, Integer> rankCount = player.getPokerNumCountMap();

        boolean allOne = false;

        if (rankCount.size() == Constants.HAND_CARD_NUMBERS) {
            List<Poker> pokers = player.getPokers();
            if (!this.isSameSuit(pokers)) {
                Poker maxCard = pokers.get(0);
                Poker minCard = pokers.get(pokers.size() - 1);
                if (maxCard.getNum().getNumber() - minCard.getNum().getNumber() >= Constants.HAND_CARD_NUMBERS) {
                    allOne = true;
                }
            }
        }

        if (allOne) {
            result = new RankingResult();
            result.setRankingEnum(RankingEnum.HIGH_CARD);
        }

        return result;
    }

}

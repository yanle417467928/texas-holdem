package com.yanle.texasholdem.model.ranking;


import com.yanle.texasholdem.constant.RankingEnum;
import com.yanle.texasholdem.model.Player;
import com.yanle.texasholdem.model.Poker;

import java.util.List;

/**
 * @Description: 解析玩家手中的牌是不是同花顺(即是 最大牌是K 且同色)
 * @Author Richard
 * @Date 2018/6/5 17:38
 */
public class StraightFlushRankingImpl extends AbstractRanking {

    protected RankingResult doResolve(Player player) {

        RankingResult result = null;

        List<Poker> pokers = player.getPokers();
        if (this.isSameSuit(pokers)) { // 如果是同色
            boolean isStraight = true;
            Poker previousCard = null;
            for (Poker poker : pokers) {
                if (previousCard != null) {
                    if (poker.getNum().getNumber() - previousCard.getNum().getNumber() != -1) {
                        isStraight = false;
                        break;
                    }
                }
                previousCard = poker;
            }
            if (isStraight == true) {
                result = new RankingResult();
                result.setRankingEnum(RankingEnum.STRAIGHT_FLUSH);
            }

        }
        return result;
    }

}
